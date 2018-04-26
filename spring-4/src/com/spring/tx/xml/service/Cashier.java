package com.spring.tx.xml.service;

import java.util.List;

/**
 * 用户购买多本书
 * @author buhuaqi
 *
 */
public interface Cashier {
	public void checkout(String username,List<Integer> isbns);
}
