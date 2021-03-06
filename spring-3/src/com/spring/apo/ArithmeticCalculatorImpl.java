package com.spring.apo;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")//该bean装配名为arithmeticCalculator
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		int result = i+j;
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
