package com.spring.beans.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//首先只要创建IOC容器就调用了xml文件中bean的构造器，并加载相应的setter方法，并且调用init()方法进行初始化
		ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("beans-cycle.xml");
		Car car=(Car)cxt.getBean("car");
		System.out.println(car);
		cxt.close();//在关闭调用销毁方法
	}
}
