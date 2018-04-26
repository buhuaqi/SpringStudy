package com.spring.tx.xml.service.impl;

import com.spring.tx.xml.BookShopDao;
import com.spring.tx.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {
	
	private BookShopDao bookShopDao;
	
	/**
	 * 购书服务方法
	 * 这里不添加事务的话，可能出现书有库存，钱不够，执行的时候会出现，库存减一，但账户不扣钱！
	 */
	
	public void purchase(String username, int isbn) {
		//1.获取书单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.更新书库存
		bookShopDao.updateBookStock(isbn);
		//3.更新用户账户余额
		bookShopDao.updateUserAccount(username, price);
	}

	public BookShopDao getBookShopDao() {
		return bookShopDao;
	}

	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}

}
