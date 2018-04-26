package com.dongtaidailijizhi;
/**
 * 创建动态代理类
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

	private Subject subject;//要代理的真实对象
	
	public DynamicProxy(Subject subject) {
		// TODO Auto-generated constructor stub
		this.subject=subject;
	}
	
	//proxy代理的对象，method真实对象的方法，args真实对象的参数
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//在代理真是对象前我们可以添加一些自己的操作：示例
		System.out.println("before rent house");
		System.out.println("Method:"+method);
		
		//当代理对象调用真是对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		method.invoke(subject, args);
		
		return null;
	}

}
