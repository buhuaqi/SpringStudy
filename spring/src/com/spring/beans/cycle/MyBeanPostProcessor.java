package com.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	
	@Override//在init()方法之后被调用
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessAfterInitialization:"+bean+","+beanName);
		Car car1 = new Car();
		car1.setBrand("Ai");
		return car1;
	}
	
	@Override//在init()方法之前被调用
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessBeforeInitialization:"+bean+","+beanName);
		Car car = new Car();
		car.setBrand("AU");
		return car;
	}

}
