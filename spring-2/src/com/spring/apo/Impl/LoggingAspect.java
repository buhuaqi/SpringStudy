package com.spring.apo.Impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 日志切面类
 * @author buhuaqi
 *
 */
//把这个类声明为一个切面：1.把该类放到IOC容器中，让IOC容器管理（@Component）
//					2.在声明为一个切面（@Aspect）

@Aspect
@Component	
public class LoggingAspect {
	//需求：这是一个日志类，我们希望这个方法在Main方法执行前执行
	//@Before为前置通知：声明在目标方法开始之前执行，这里我们打印日志，表示在（）中的方法开始之前执行，全类名加方法名
	//如果想在所有方法起作用将方法名换成*代替
	@Before("execution(public int com.spring.apo.Impl.ArithmeticCalculator.add(int, int))")
	public void beforeMethod(JoinPoint joinPoint) {//在方法中我们可以传一个JoinPoint参数用来获取一些方法基本信息
		String methodName=joinPoint.getSignature().getName();//获取方法签名
		System.out.println("The method begins");
	}
	
	//后置通知，在方法执行后执行，注意无论方法是否出现异常该通知都会执行
	@After("execution(public int com.spring.apo.Impl.ArithmeticCalculator.add(int, int))")
	public void afterMethod() {
		System.out.println("The method over");
	}
}
