package test.small.httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientTest {
	
	private static String queryUrl = "http://api2.ofpay.com/queryuserinfo.do?userpwd=acf82178ff63944db9d2f214dc6c7cf2&userid=A53168&version=6.0";
	
	private static String bigUrl = "http://api.ofpay.com/querybigcard.do";
	
	private static String pUrl = "http://api2.ofpay.com/telquery.do?userid=A53168&userpws=acf82178ff63944db9d2f214dc6c7cf2&phoneno=15105184799&pervalue=50&version=6.0";
	// ģ���
	private static String mobile = "http://simpac.handpay.com.cn/simulator/http.htm?_code_=ofcard&_url_=/telquery.do?pervalue=50&phoneno=15105184799";
	
	public static void main(String[] args) {
		testUserInfo();
//		testBig();
	}
	
	public static void testUserInfo(){
		//����HttpClient��ʵ��
	    HttpClient httpClient = new HttpClient();
	    //����GET������ʵ��
//	    GetMethod getMethod = new GetMethod("http://www.baidu.com");
	    GetMethod getMethod = new GetMethod(pUrl);
	    //ʹ��ϵͳ�ṩ��Ĭ�ϵĻָ�����
	    getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
	    try{
	    	//ִ��getMethod 
	    	int statusCode = httpClient.executeMethod(getMethod);
	    	if (statusCode != HttpStatus.SC_OK){
	    		System.err.println("Method failed: " + getMethod.getStatusLine());
	    	}
	    	System.out.println("charset="+getMethod.getResponseCharSet());
	    	
	    	//��ȡ���� 
	    	String newStr = new String(getMethod.getResponseBodyAsString().getBytes("ISO-8859-1"),"gb2312");
	    	System.out.println(newStr);
	    	
	    }catch(HttpException e){
	    	//�����������쳣��������Э�鲻�Ի��߷��ص�����������
    	   System.out.println("Please check your provided http address!");
    	   e.printStackTrace();
	    }catch(IOException e){
	    	//���������쳣
	    	e.printStackTrace();
	    }finally{
	    	//�ͷ�����
	    	getMethod.releaseConnection();
	    }
	}
	
	public static void testBig(){
	    HttpClient httpClient = new HttpClient();
	    PostMethod post = new PostMethod(bigUrl);
	    post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
	    post.setParameter("userid", "A53168");
	    post.setParameter("userpwd", "acf82178ff63944db9d2f214dc6c7cf2");
	    post.setParameter("version", "6.0");
	    try{
	    	int statusCode = httpClient.executeMethod(post);
	    	if (statusCode != HttpStatus.SC_OK){
	    		System.err.println("Method failed: " + post.getStatusLine());
	    	}
	    	System.out.println("charset="+post.getResponseCharSet());
	    	
	    	//��ȡ���� 
	    	String newStr = new String(post.getResponseBodyAsString().getBytes("ISO-8859-1"),"utf-8");
	    	System.out.println(newStr);
	    	
	    }catch(HttpException e){
	    	//�����������쳣��������Э�鲻�Ի��߷��ص�����������
    	   System.out.println("Please check your provided http address!");
    	   e.printStackTrace();
	    }catch(IOException e){
	    	//���������쳣
	    	e.printStackTrace();
	    }finally{
	    	//�ͷ�����
	    	post.releaseConnection();
	    }
	}


}
