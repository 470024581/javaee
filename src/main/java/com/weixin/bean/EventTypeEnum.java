package com.weixin.bean;

/**
 * @description 事件类型枚举
 * @author lianglong
 */
public enum EventTypeEnum {
	
	SUBSCRIBE("subscribe", "关注事件"),
	UNSUBSCRIBE("unsubscribe", "取消关注事件"),
	// 不清楚这个事件具体的场景和意义
	SCAN("SCAN", "用户已关注时的事件推送"),
	LOCATION("LOCATION", "地理位置事件"),
	CLICK("CLICK", "点击（菜单）事件"),
	VIEW("VIEW", "查看网址（菜单）事件"),
	;
	
	private String name;
	
	private String desc;

	private EventTypeEnum(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

}
