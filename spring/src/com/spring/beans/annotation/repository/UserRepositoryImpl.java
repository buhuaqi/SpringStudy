package com.spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.beans.annotation.TestObject;

/**
 * UserRepository接口的实现类
 * @author buhuaqi
 *
 */
@Repository("userRepository")//value是默认属性可不写，也可以写成(value="userRepository")
public class UserRepositoryImpl implements UserRepository {
	@Autowired(required=false)
	private TestObject testObject;
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepository save...");
		System.out.println(testObject);
	}

}
