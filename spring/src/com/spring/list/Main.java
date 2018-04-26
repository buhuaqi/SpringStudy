package com.spring.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person= (Person)cxt.getBean("person3");
		System.out.println(person);
		
		MapPerson mapPerson=(MapPerson)cxt.getBean("newPerson");
		System.out.println(mapPerson);
	}

}
