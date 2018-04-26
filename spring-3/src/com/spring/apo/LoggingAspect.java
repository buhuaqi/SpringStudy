package com.spring.apo;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 通过@Aspect注解自动创建动态代理对象的五种通知类型示例
 * 希望每个实现ArithmeticCalulator接口的类调用任何方法时都打印日志切面
 * @author buhuaqi
 *
 */
//注：该类写了环绕通知，测试时建议先将环绕通知注释掉
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	/**
	 * 定义切入点表达式，便于代码重用(改方法中一般不写代码)
	 */
	@Pointcut("execution(* com.spring.apo.ArithmeticCalculator.*(..))")//表示对ArithmeticCalculator下的所有方法执行如下事务
	public void declareJoinPointExpression() {}
	
	/**
	 * 前置通知
	 * @param joinPoint
	 */
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		
		String methodName = joinPoint.getSignature().getName();//获取方法名
		
		Object[] args=joinPoint.getArgs();//获取传入目标方法的参数对象
		
		List<Object> a = Arrays.asList(args);//Arrays.asList()方法将数组转化为List集合
		//Arrays.asList()方法是将数组转化为List集合
		System.out.println("The method's name is  is " + methodName + " begins with " + a );
	}

	/**
	 * 后置通知，无论方法是否出现异常都执行
	 * @param joinPoint
	 */
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		
		String methodName = joinPoint.getSignature().getName();//获取方法名
		
		Object[] args=joinPoint.getArgs();//获取传入目标方法的参数对象
		
		List<Object> a = Arrays.asList(args);//Arrays.asList()方法将数组转化为List集合
		//Arrays.asList()方法是将数组转化为List集合
		System.out.println("The method's name is " + methodName + " ends with" + a);
	}
	
	/**
	 * 返回通知，只有方法正常执行，该通知才执行（如果在主方法中的除法运算法则中，我们定义1000/0，则运算异常，此时该通知不能执行）
	 * 返回通知时可以访问到返回值，在方法签名中加returning属性
	 * 此时书写格式如下
	 * @param joinPoint
	 */
	@AfterReturning(value="declareJoinPointExpression()",returning="returnValue")
	public void afterReturning(JoinPoint joinPoint,Object returnValue) {
		
		String methodName = joinPoint.getSignature().getName();//获取方法名
		
		System.out.println("The method's name is " + methodName + " afterReturning with" + returnValue);
		
	}
	
	/**
	 * 异常通知，只有在方法出异常的时候才会执行，可以访问到异常对象，比如在主方法中定义除以0方法异常
	 * 这里的异常类型可以自己定义，比如下面定义了Exception（只要是异常，就会执行），也可以指定NullPointerException等其他异常类型
	 * 这时只有符合这些异常类型时才会执行该通知
	 * @param joinPoint
	 */
	@AfterThrowing(value="declareJoinPointExpression()",throwing="ex")
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