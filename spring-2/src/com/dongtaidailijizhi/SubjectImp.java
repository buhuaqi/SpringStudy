package com.dongtaidailijizhi;
/**
 * Subject实现类
 * @author buhuaqi
 *
 */
public class SubjectImp implements Subject {

	@Override
	public void rent() {
		// TODO Auto-generated method stub
		System.out.println("I want to rent my house");
	}

	@Override
	public void hello(String str) {
		// TODO Auto-generated method stub
		System.out.println("Hello:" + str);
	}

}
