package com.spring.apo.Impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.创建IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从IOC获取bean实例
		ArithmeticCalculator arithmeticCalculator=(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		//3.使用bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println(result);
	}

}
