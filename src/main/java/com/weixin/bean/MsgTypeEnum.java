package com.weixin.bean;

/**
 * @description 消息类型枚举
 * @author lianglong
 */
public enum MsgTypeEnum {
	
	TEXT("text", "文字消息"),
	IMAGE("image", "图片消息"),
	VOICE("voice", "语音消息"),
	VIDEO("video", "视频消息"),
	SHORTVIDEO("shortvideo", "小视频消息"),
	LOCATION("location", "地理位置消息"),
	LINK("link", "链接消息"),
	EVENT("event", "事件消息"),
	;
	
	private MsgTypeEnum(String name, String desc){
		this.name = name;
		this.desc = desc;
	}
	
	private String name;
	
	private String desc;
	
	public String getName(){
		return name;
	}
	
	public String getDesc(){
		return desc;
	}

}
