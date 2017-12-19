package com.weixin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.bean.TextMessage;
import com.weixin.util.StringUtil;

/**
 * @description
 * @author lianglong
 */
@Controller
@RequestMapping
public class WeixinController {

	private Logger log = Logger.getLogger(this.getClass());
	
	private String appID = "wxe3e6ba7cd62ee9dc";
	private String appsecret = "d81854956e74f92e5bcb5c409b3bc1f2";
	private String accessToken = "5KvkJJ1ZUD86SCbivYG7iyHGGMcYZboS1wMTZdeLiFQGKE-jA2koi7mfNCMBJZwQwyoOYCbwFMQsDDkOe8iOi1K2p1E7YoSAoGXTkNQNnlkHMUgAEAQVD";

	@ResponseBody
	@RequestMapping(value="api", method=RequestMethod.POST)
	public String checkSignature(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			TextMessage tm = new TextMessage();
			Map<String, String> map = StringUtil.xml2Map(request);
			String toUserName =  map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
//			String createTime = map.get("createTime");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			String msgId = map.get("MsgId");
			if("text".equals(msgType)){
				tm.setToUserName(fromUserName);
				tm.setContent("主人，我现在还小，还不能跟您聊天~~");
				tm.setCreateTime(new Date());
				tm.setFromUserName(toUserName);
				tm.setMsgId(msgId);
				tm.setMsgType(msgType);
			} else if("event".equals(msgType)) {
				String eventType = map.get("Event");
				if("subscribe".equals(eventType)){
					// 关注事件
					
				}
				
			}
			log.info(tm);
			log.info(StringUtil.obj2Xml(tm));
			return StringUtil.obj2Xml(tm);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "/n");
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
