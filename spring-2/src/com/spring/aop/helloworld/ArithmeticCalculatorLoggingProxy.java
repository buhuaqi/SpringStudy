package com.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.script.Invocable;

public class ArithmeticCalculatorLoggingProxy {
	//要代理的对象(真实对象)
	private ArithmeticCalculator target;
	
	public ArithmeticCalculator getLoggingProxy() {
		
		//代理对象由哪一个类加载器负责加载(java.lang.ClassLoader类装载器)
		ClassLoader loader = target.getClass().getClassLoader();
		
		//获取ArithmeticCalculator接口即真实对象的实现的接口
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};
		
		//调用代理对象其中的方法时，该执行的代码
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		};
		//代理对象创建如下
		ArithmeticCalculator proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		
		return proxy;
	}
}
