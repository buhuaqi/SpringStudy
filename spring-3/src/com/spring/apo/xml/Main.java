package com.spring.apo.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		ArithmeticCalculator arithmeticCalculator=(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		int result = arithmeticCalculator.add(1, 2);
		System.out.println("result:"+result);
		
		result = arithmeticCalculator.div(1000,	0);
		System.out.println("result:"+result);
	}

}
