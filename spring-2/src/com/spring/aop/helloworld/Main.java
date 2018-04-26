package com.spring.aop.helloworld;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArithmeticCalculator arithmeticCalculator=new ArithmeticCalculatorImplLogging();
		
		System.out.println(arithmeticCalculator.add(1, 1));
	}

}
