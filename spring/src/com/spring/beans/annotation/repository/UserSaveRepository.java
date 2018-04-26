package com.spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserSaveRepository implements UserRepository {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserSaverRepository save..");
	}

}
