package com.weixin.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.util.CheckUtil;

/**
 * @description 
 * @author lianglong
 */
@Controller
@RequestMapping
public class CheckController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@ResponseBody
	@RequestMapping("api")
	public String checkSignature(String signature, String timestamp, String nonce, String echostr){
		log.info("进来了。。。！！！");
		try {
			HdfsDao.uploadFile("C:\\Users\\Administrator\\Desktop\\试用期转正申请表&试用期表现评定表 - 梁龙.docx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			return echostr;
		}
		return null;
	}
	
}
