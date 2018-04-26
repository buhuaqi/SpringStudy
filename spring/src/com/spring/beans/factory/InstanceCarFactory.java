package com.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;
/**
 * 实例工厂方法：现需要创建工厂本身，在调用工厂的实例方法，来返回bean的实例
 * @author buhuaqi
 *
 */
public class InstanceCarFactory {
	private Map<String,Car> cars=null;
	
	public InstanceCarFactory() {
		cars = new HashMap<String,Car>();
		cars.put("audi", new Car("audi",300000));
		cars.put("fort", new Car("fort",400000));
	}
	
	public 	Car getCar(String brand) {
		return cars.get(brand);
	}
}
