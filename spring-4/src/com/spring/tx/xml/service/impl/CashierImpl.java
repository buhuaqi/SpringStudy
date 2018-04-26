package com.spring.tx.xml.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.tx.xml.service.BookShopService;
import com.spring.tx.xml.service.Cashier;

public class CashierImpl implements Cashier {

	private BookShopService bookShopService;

	public BookShopService getBookShopService() {
		return bookShopService;
	}

	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}

	@Override//checkout方法被事务注解
	public void checkout(String username, List<Integer> isbns) {
		for(int isbn:isbns) {
			//purchase方法也被事务管理
			bookShopService.purchase(username, isbn);
		} 
	}
}
