package com.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法：直接调用某一个类的静态方法，就可以返回bean的实例
 * @author buhuaqi
 *
 */
public class StaticCarFactory {
	private static Map<String,Car> cars=new HashMap<String,Car>();//map集合
	
	static {//静态代码快只在这个类被装载的时候才会被执行，存放多个型号car
		cars.put("audi", new Car("Audi",300000));
		cars.put("ford", new Car("ford",400000));
	}
	
	//静态工厂方法
	public static Car getCar(String name) {
		return cars.get(name);
	}
}
