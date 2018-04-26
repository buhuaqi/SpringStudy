package com.spring;

public class HelloWorld {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		//用来验证在创建IOC容器的时候是否为setName方法赋值
		System.out.println("setName:"+name);
		this.name = name;
	}
	
	public void hello() {
		System.out.println("hello:"+name);
	}
	
	//用来验证创建IOC容器是否调用构造器
	public HelloWorld(){
		System.out.println("This is a Constructor");
	}
}
