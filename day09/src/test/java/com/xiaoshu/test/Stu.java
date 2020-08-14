package com.xiaoshu.test;

/**
 * @author shao
 *
 */
public class Stu {
	private String name;
	private Integer id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Stu [name=" + name + ", id=" + id + "]";
	}
	public Stu(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}
	public Stu() {
		super();
		
	}
	
}
