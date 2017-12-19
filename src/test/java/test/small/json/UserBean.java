package test.small.json;

import java.util.Date;
import java.util.List;

public class UserBean {
	
	private int id;
	
	private String name;
	
	private List<String> attr;
	
	private List<SubUserBean> subUserList;
	
	private Date date;
	
	private SubUserBean subUserBean;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getAttr() {
		return attr;
	}

	public void setAttr(List<String> attr) {
		this.attr = attr;
	}

	public List<SubUserBean> getSubUserList() {
		return subUserList;
	}

	public void setSubUserList(List<SubUserBean> subUserList) {
		this.subUserList = subUserList;
	}

	public SubUserBean getSubUserBean() {
		return subUserBean;
	}

	public void setSubUserBean(SubUserBean subUserBean) {
		this.subUserBean = subUserBean;
	}

}
