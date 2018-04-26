package com.spring.aop.helloworld;

import java.util.Date;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		System.out.println("The method add begins with"+new Date(System.currentTimeMillis()));
		int result = i+j;
		System.out.println("The method add over with"+new Date(System.currentTimeMillis()));
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result = i-j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result = i*j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result = i/j;
		return result;
	}

}
