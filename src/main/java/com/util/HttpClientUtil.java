package com.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @Description apache http 工具包
 * @author gqwang
 * @date 2016年1月26日下午3:21:17
 * 
 */
public class HttpClientUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(HttpClientUtil.class);

	private static String CHARSET = "UTF-8";

	/**
	 * 用httpclient 发送post 请求 如果参数为null,会转化成""
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String httpPost(String url, Map<String, Object> params) {
		String result = null;
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
		post.addRequestHeader("Content-Type", "text/html;charset=" + CHARSET);
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, Object> en : params.entrySet()) {
				String key = en.getKey();
				String value = en.getValue().toString();
				if (!StringUtil.isNotBlank(value)) {
					value = "";
				}
				NameValuePair v = new NameValuePair(key, value);
				post.addParameter(v);
			}
		}
		// 设置发送内容的编码 post 设置了header 这里可以不用设置
		// client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
		// CHARSET);
		try {
			client.executeMethod(post);
			if (post.getStatusCode() == HttpStatus.SC_OK) {
				result = post.getResponseBodyAsString();
			}
		} catch (HttpException e) {
			logger.error("httpclient send post error", e);
		} catch (IOException e) {
			logger.error("httpclient send post error", e);
		} finally {
			post.releaseConnection();
		}
		return result;
	}

	public static String httpPost(String url, Map<String, Object> params,
			Map<String, String> headerParams) {
		String result = null;
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
		post.addRequestHeader("Content-Type", "text/html;charset=" + CHARSET);
		if (headerParams != null && !headerParams.isEmpty()) {
			for (Map.Entry<String, String> en : headerParams.entrySet()) {
				String k = en.getKey();
				String v = en.getValue();
				if (!StringUtil.isNotBlank(v)) {
					v = "";
				}
				post.addRequestHeader(k, v);
			}
		}
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, Object> en : params.entrySet()) {
				String key = en.getKey();
				String value = en.getValue().toString();
				if (!StringUtil.isNotBlank(value)) {
					value = "";
				}
				NameValuePair v = new NameValuePair(key, value);
				post.addParameter(v);
			}
		}
		try {
			client.executeMethod(post);
			if (post.getStatusCode() == HttpStatus.SC_OK) {
				result = post.getResponseBodyAsString();
			}
		} catch (HttpException e) {
			logger.error("httpclient send post error", e);
		} catch (IOException e) {
			logger.error("httpclient send post error", e);
		} finally {
			post.releaseConnection();
		}
		return result;
	}

	public static String httpGet(String url) {
		return httpGet(url, null);
	}

	public static String httpGet(String url, Map<String, String> params) {
		return httpGet(url, params, null);
	}

	public static File httpGetFile(String url, String fileName, String suffix) {
		byte[] bytes = httpGetBytes(url);
		File file = null;
		try {
			file = File.createTempFile(fileName, suffix);
			BufferedOutputStream bos = null;
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(file);
				bos = new BufferedOutputStream(fos);
				bos.write(bytes);
			} finally {
				if (bos != null) {
					bos.close();
				}
				if (fos != null) {
					fos.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public static byte[] httpGetBytes(String url) {
		return httpGetBytes(url, null, null);
	}

	public static byte[] httpGetBytes(String url, Map<String, String> params,
			Map<String, String> headers) {
		byte[] bs = null;
		HttpClient client = new HttpClient();
		StringBuffer sb = new StringBuffer(url);
		sb.append("?");
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> en : params.entrySet()) {
				String key = en.getKey();
				String value = en.getValue();
				if (StringUtil.isBlank(value)) {
					value = "";
				} else {
					try {
						value = URLEncoder.encode(value, CHARSET);
					} catch (UnsupportedEncodingException e) {
						logger.error("set http get param error", e);
						sb.append(key).append("=").append(value).append("&");
						continue;
					}
				}
				sb.append(key).append("=").append(value).append("&");
			}
			// 删除最后一个 & 符号
			sb.deleteCharAt(sb.length() - 1);
		}
		GetMethod get = new GetMethod(sb.toString());
		get.addRequestHeader("Content-Type", "text/html;charset=" + CHARSET);
		if (headers != null && !params.isEmpty()) {
			for (Entry<String, String> en : headers.entrySet()) {
				String key = en.getKey();
				String value = en.getValue();
				get.addRequestHeader(key, value);
			}
		}
		try {
			client.executeMethod(get);
			if (get.getStatusCode() == HttpStatus.SC_OK) {
				bs = get.getResponseBody();
			}
		} catch (HttpException e) {
			logger.error("httpclient send get error", e);
		} catch (IOException e) {
			logger.error("httpclient send get error", e);
		} finally {
			get.releaseConnection();
		}
		return bs;
	}

	public static String httpGet(String url, Map<String, String> params,
			Map<String, String> headers) {
		String result = null;
		// byte[] bytes = httpGetBytes(url, params, headers);
		// try {
		// result = new String(bytes, CHARSET);
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		HttpClient client = new HttpClient();
		StringBuffer sb = new StringBuffer(url);
		sb.append("?");
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> en : params.entrySet()) {
				String key = en.getKey();
				String value = en.getValue();
				if (StringUtil.isBlank(value)) {
					value = "";
				} else {
					try {
						value = URLEncoder.encode(value, CHARSET);
					} catch (UnsupportedEncodingException e) {
						logger.error("set http get param error", e);
						sb.append(key).append("=").append(value).append("&");
						continue;
					}
				}
				sb.append(key).append("=").append(value).append("&");
			}
			// 删除最后一个 & 符号
			sb.deleteCharAt(sb.length() - 1);
		}
		GetMethod get = new GetMethod(sb.toString());
		get.addRequestHeader("Content-Type", "text/html;charset=" + CHARSET);
		if (headers != null && !params.isEmpty()) {
			for (Entry<String, String> en : headers.entrySet()) {
				String key = en.getKey();
				String value = en.getValue();
				get.addRequestHeader(key, value);
			}
		}
		try {
			client.executeMethod(get);
			if (get.getStatusCode() == HttpStatus.SC_OK) {
				result = get.getResponseBodyAsString();
			}
		} catch (HttpException e) {
			logger.error("httpclient send get error", e);
		} catch (IOException e) {
			logger.error("httpclient send get error", e);
		} finally {
			get.releaseConnection();
		}
		return result;
	}

	/**
	 * 返回responseBoby和responseHeader
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static Map<String, Object> httpGetResultMap(String url,
			Map<String, String> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		HttpClient client = new HttpClient();
		StringBuffer sb = new StringBuffer(url);
		sb.append("?");
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> en : params.entrySet()) {
				String key = en.getKey();
				String value = en.getValue();
				if (!StringUtil.isNotBlank(value)) {
					value = "";
				} else {
					try {
						value = URLEncoder.encode(value, CHARSET);
					} catch (UnsupportedEncodingException e) {
						logger.error("set http get param error", e);
						sb.append(key).append("=").append(value).append("&");
						continue;
					}
				}
				sb.append(key).append("=").append(value).append("&");
			}
			// 删除最后一个 & 符号
			sb.deleteCharAt(sb.length() - 1);
		}
		GetMethod get = new GetMethod(sb.toString());
		get.addRequestHeader("Content-Type", "text/html;charset=" + CHARSET);
		try {
			client.executeMethod(get);
			if (get.getStatusCode() == HttpStatus.SC_OK) {
				String respBody = get.getResponseBodyAsString();
				Header[] respHeader = get.getResponseHeaders();
				result.put("respBody", respBody);
				result.put("respHeader", respHeader);
			}
		} catch (HttpException e) {
			logger.error("httpclient send get error", e);
		} catch (IOException e) {
			logger.error("httpclient send get error", e);
		} finally {
			get.releaseConnection();
		}
		return result;
	}


	/**
	 * 输入流转成字符串
	 * 
	 * @param is
	 * @return
	 */
	public static String inputStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is),
				16 * 1024); // 强制缓存大小为16KB，一般Java类默认为8KB
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) { // 处理换行符
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/**
	 * 发送json参数的post方法
	 * 
	 * @param url
	 *            发送地址
	 * @param json
	 *            字符型的json参数
	 * @return 状态码
	 */
	public static String postJson(String url, String json) {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		try {
			RequestEntity se = new StringRequestEntity(json,
					"application/json", CHARSET);
			method.setRequestEntity(se);
			// 使用系统提供的默认的恢复策略
			method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler());
			// 设置超时的时间5m
			method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
			int status = client.executeMethod(method);
			if (status == HttpStatus.SC_OK) {
				return method.getResponseBodyAsString();
			}
			return method.getResponseBodyAsString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
