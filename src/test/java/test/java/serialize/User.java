package test.java.serialize;

import java.io.Serializable;

/**
 * @description 
 * @author lianglong
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = -770793506433070484L;

	private long id;
	
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
