package com.spring.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
	@Autowired//装配BaseRepository<T>实例，这个注解会被子类继承
	protected BaseRepository<T> repository;
	
	public void add() {
		System.out.println("add..");
		System.out.println(repository);
	}
}
