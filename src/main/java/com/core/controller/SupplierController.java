package com.core.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.dao.domain.HestiaSupplier;

/**
 * @author lliang
 */
@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@ResponseBody
	@RequestMapping(value = "/supplier")
	public HestiaSupplier supplier() throws IOException {
		log.info("Supply-Clotho-notifyGoodsBack 锟斤拷锟侥讹拷锟斤拷通知锟剿伙拷锟斤拷锟�锟斤拷锟斤拷锟斤拷锟絩equest锟斤拷");
		HestiaSupplier hs = new HestiaSupplier();
		log.error("Supply-Clotho-notifyGoodsBack 锟斤拷锟斤拷通知锟剿匡拷锟斤拷-锟斤拷锟斤拷锟斤拷锟絩equest锟斤拷null锟斤拷");
		return hs;
	}
	
	@RequestMapping(value = "/list")
	public String list(){
		
		return "list";
	}
}
