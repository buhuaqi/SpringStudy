package com.spring.apo;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 需求：多个切面使用时优先级问题
 * 		注解@Order()可指定切面优先级，值越小优先级越高
 * 参数验证切面
 * @author buhuaqi
 *
 */
@Order(1)
@Aspect
@Component
public class ValidateAspect {
	//使用本包中其他类定义的切点表达式（类名.重用方法名），不同包全类名加方法名
	@Before("LoggingAspect.declareJoinPointExpression()")
	public void ValidateAspect(JoinPoint joinPoint) {
		System.out.println("验证参数："+ Arrays.asList(joinPoint.getArgs()));//打印参数
	}
}
