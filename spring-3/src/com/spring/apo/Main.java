package com.spring.apo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArithmeticCalculator arithmeticCalculator=(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
	
		//验证arithmeticCalculator对象是由哪个类执行，如果不使用AOP(即@AspectJ)，该对象就是由ArithmeticCalculatorImpl类创建执行的
		//而我们用了AOP本质是动态代理机制，此时该对象是由代理对象创建
		System.out.println(arithmeticCalculator.getClass().getName());
		
		int result = arithmeticCalculator.add(1, 2);
		System.out.println("result:"+result);
		
		result = arithmeticCalculator.div(1000,	10);
		System.out.println("result:"+result);
	}

}
