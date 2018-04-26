package com.spring.apo.xml;
/**
 * 需求：希望每个实现该接口的类调用任何方法时都打印日志（一句话）
 * @author buhuaqi
 *
 */
public interface ArithmeticCalculator {
	int add(int i, int j);
	int sub(int i, int j);
	int mul(int i, int j);
	int div(int i, int j);
}
