package com.spring.tx.xml;

public interface BookShopDao {
	//根据书号查询单价
	public int findBookPriceByIsbn(int isbn);
	
	//根据书号更新库存（库存-1）
	public void updateBookStock(int isbn);
	
	//更新账户余额,使username的balance-price
	public void updateUserAccount(String username,int price);
}
