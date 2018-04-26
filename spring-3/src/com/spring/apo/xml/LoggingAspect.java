package com.spring.apo.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

/**
 * 
 * 希望每个实现ArithmeticCalulator接口的类调用任何方法时都打印日志切面
 * @author buhuaqi
 *
 */

public class LoggingAspect {
	
	public void beforeMethod(JoinPoint joinPoint){
		
		String methodName = joinPoint.getSignature().getName();//获取方法名
		
		Object[] args=joinPoint.getArgs();//获取传入目标方法的参数对象
		
		List<Object> a = Arrays.asList(args);//Arrays.asList()方法将数组转化为List集合
		//Arrays.asList()方法是将数组转化为List集合
		System.out.println("The method's name is  is " + methodName + " begins with " + a );
	}

	
	public void afterMethod(JoinPoint joinPoint){
		
		String methodName = joinPoint.getSignature().getName();//获取方法名
		
		Object[] args=joinPoint.getArgs();//获取传入目标方法的参数对象
		
		List<Object> a = Arrays.asList(args);//Arrays.asList()方法将数组转化为List集合
		//Arrays.asList()方法是将数组转化为List集合
		System.out.println("The method's name is " + methodName + " ends with" + a);
	}
	
	
	public void afterReturning(JoinPoint joinPoint,Object returnValue) {
		
		String methodName = joinPoint.getSignature().getName();//获取方法名
		
		System.out.println("The method's name is " + methodName + " afterReturning with" + returnValue);
		
	}
	
	
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
	
		String methodName = joinPoint.getSignature().getName();//获取方法名
		
		System.out.println("The method's name is " + methodName + " exception "+ex );
	}

	/**
	 * 环绕通知，必须携带ProceedingJoinPoint类型参数，必须要有返回值（为目标方法的返回值）
	 * 环绕通知类似于动态代理全过程：ProceedingJoinPoint类型参数可以决定是否执行目标方法
	 * (上述我们已经写了四个通知,而实际上环绕通知里包括其他通知)
	 
	@Around("execution(* com.spring.apo.ArithmeticCalculator.*(..))")
	public Object aroudMethod(ProceedingJoinPoint pjp) {
		Object result = null;
		String methodName = pjp.getSignature().getName();
		try {
			//前置通知
			System.out.println("环绕通知定义的前置通知方法："+methodName);
			//执行目标方法
			result = pjp.proceed();
			//返回通知
			System.out.println("环绕通知定义的返回通知方法："+methodName);
		} catch (Throwable e) {
			// 异常通知
			System.out.println("环绕通知定义的异常通知方法："+methodName);
		}
		//后置通知
		System.out.println("环绕通知定义的后置通知方法："+methodName);
		return result;
	}*/
	
}

/*
 * 注：定义通知注解的参数属性，及属性值类型，在这里就是在定义代理对象中的参数属性，及值类型
 */