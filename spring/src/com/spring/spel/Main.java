package com.spring.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("application-spel.xml");
		Address address=(Address)cxt.getBean("address");
		System.out.println(address);
		
		Car car = (Car)cxt.getBean("car");
		System.out.println(car);
		
		Person person=(Person) cxt.getBean("person");
		System.out.println(person);
	}
}
