package com.spring.bean.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cxt = new ClassPathXmlApplicationContext("application.xml");
	//	Person person = (Person)cxt.getBean("person");
	//	System.out.println(person);
		
	//	Car car=(Car)cxt.getBean("car1");
	//	System.out.println(car);
		Car car=(Car)cxt.getBean("car");
		System.out.println(car);
		Person person=(Person)cxt.getBean("person1");
		System.out.println(person);
	}

}
