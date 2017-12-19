package test.hadoop.mapreduce;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @description 
 * @author lianglong
 */
public class UserLog {
	
	/**
	 * 时间
	 */
	private Date time;
	
	/**
	 * 地点--某页面
	 */
	private String page;
	
	/**
	 * 人物--某控件
	 */
	private String widget;
	
	/**
	 * 事件
	 */
	private String event;
	
	/**
	 * 外部系统标识--数据来源
	 */
	private String refNo;
	
	/**
	 * 数据源--json格式的数据
	 */
	private String data;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getWidget() {
		return widget;
	}

	public void setWidget(String widget) {
		this.widget = widget;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
