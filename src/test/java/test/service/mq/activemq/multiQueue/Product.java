package test.service.mq.activemq.multiQueue;

import java.io.Serializable;

public class Product implements Serializable {
	
	private static final long serialVersionUID = -7745382236398527266L;
	
	private int id;
	
	private String name;

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
	

}
