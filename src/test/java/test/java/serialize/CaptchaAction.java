package test.java.serialize;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description
 * @author lianglong
 */
public class CaptchaAction {

	/**
	 * ����ͼƬ
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getImage.do")
	protected void getCaptchaImage(HttpServletRequest request, HttpServletResponse response, @RequestParam("width") int width, @RequestParam("height") int height) {
		// ��������
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		// ����ʱ��
		response.setDateHeader("Expires", 0);

		HttpSession session = request.getSession();

		// ���width,heightΪ��,Ĭ��width=60px,height=40px
		if (width == 0 || height == 0) {
			width = 60;
			height = 40;
		}

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// ���� ������
		// g.setColor(getRandColor(100,200));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		// �����ߵ���ɫ
		g.setColor(getRandColor(50, 100));
		// ���������
		Random random = new Random();
		// ����
		for (int i = 0; i < 30; i++) {
			int x1 = random.nextInt(height);
			int y1 = random.nextInt(width);
			int x2 = random.nextInt(30);
			int y2 = random.nextInt(30);
			g.drawLine(x1, y1, height + x2, width + y2);
		}
		// ���������
		String words = "23456789abcdefghkmnpqrstxyzABCDEFGHKMNPQRSTXYZ";
		char[] charArr = words.toCharArray();
		StringBuilder randStr = new StringBuilder();
		for (int j = 0; j < 4; j++) {
			char ch = charArr[random.nextInt(words.length())];
			// �����ַ�����ɫ
			g.setColor(getRandColor(60, 120));
			g.drawString(String.valueOf(ch), (j * 12) + 6, height / 2 + 7);
			randStr.append(ch);
		}
		session.setAttribute("captcha", randStr.toString());
		// ����ͼ��
		g.dispose();
		// ��ͼ��д��response��
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			ImageIO.write(image, "JPEG", sos);
			sos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sos != null) {
				try {
					sos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getJson.do")
	public foo resultJson() {
		foo f = new foo("test", "test json");
		return f;
	}

	@ResponseBody
	@RequestMapping(value = "/getStr.do")
	public String resultStr() {
		return "��������";
	}

	/**
	 * �������color
	 * 
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getRandColor(int fc, int bc) { // ������Χ��������ɫ
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	class foo implements Serializable {
		private static final long serialVersionUID = 1L;

		public foo() {
		}

		public foo(String id, String name) {
			this.id = id;
			this.name = name;
		}

		String id;
		String name;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
