package com.spring.apo.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
/**
 * 需求：多个切面使用时优先级问题
 * 		
 * 参数验证切面
 * @author buhuaqi
 *
 */

public class ValidateAspect {
	//使用本包中其他类定义的切点表达式（类名.重用方法名），不同包全类名加方法名
	
	public void ValidateAspect(JoinPoint joinPoint) {
		System.out.println("验证参数："+ Arrays.asList(joinPoint.getArgs()));//打印参数
	}
}
