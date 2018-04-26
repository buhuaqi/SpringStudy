package com.spring.beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cxt = new ClassPathXmlApplicationContext("beans-factory.xml");
		Car car = (Car)cxt.getBean("car1");
		System.out.println(car);
		Car car1=(Car)cxt.getBean("car2");
		System.out.println(car1);
	}
}
