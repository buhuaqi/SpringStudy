package com.spring.jdbc;

public class Department {
	private int id;
	private String namae;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamae() {
		return namae;
	}
	public void setNamae(String namae) {
		this.namae = namae;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", namae=" + namae + "]";
	}
}
