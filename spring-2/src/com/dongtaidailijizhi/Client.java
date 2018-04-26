package com.dongtaidailijizhi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		//代理的真实对象
		Subject subject=new SubjectImp();
		
		//我们需要代理哪个对象就将这个对象传进去
		InvocationHandler handler = new DynamicProxy(subject);
		
		 /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数subjectImp.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
		ClassLoader loader = handler.getClass().getClassLoader();
		Class<?>[] interfaces = subject.getClass().getInterfaces();
		InvocationHandler h=handler;
		Subject sjproxy = (Subject) Proxy.newProxyInstance(loader, interfaces, h);//创建代理对象sjproxy
	
		System.out.println(sjproxy.getClass().getName());
		sjproxy.rent();
		sjproxy.hello("world");
	}

}
