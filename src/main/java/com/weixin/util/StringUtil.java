package com.weixin.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.weixin.bean.TextMessage;

/**
 * @description 
 * @author lianglong
 */
public class StringUtil {
	
	public static Map<String, String> xml2Map(HttpServletRequest request) throws Exception{
		Map<String, String> map = new HashMap<>();
		SAXReader reader = new SAXReader();
		
		InputStream is = request.getInputStream();
		Document doc = reader.read(is);
		
		Element root = doc.getRootElement();
		List<Element> list = root.elements();
		for(Element e : list){
			map.put(e.getName(), e.getText());
		}
		is.close();
		return map;
	}
	
	public static String obj2Xml(TextMessage tm){
		XStream x = new XStream();
		x.alias("xml", tm.getClass());
		return x.toXML(tm);
	}

}
