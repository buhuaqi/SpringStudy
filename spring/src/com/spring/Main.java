package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*HelloWorld helloWorld = new HelloWorld();
		helloWorld.setName("buhuaqi");*/
		
		//创建Spring的IOC容器对象，在创建容器的时候会调用构造器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从IOC容器获取Bean实例
		/*HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");//"helloWorld"为bean的名称
		//调用
		helloWorld.hello();*/
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		 car = (Car) ctx.getBean("car2");
		System.out.println(car);
		
		Person person = (Person)ctx.getBean("person");
		System.out.println(person);
	}

}
