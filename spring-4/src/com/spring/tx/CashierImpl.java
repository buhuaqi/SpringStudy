package com.spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("Cashier")
public class CashierImpl implements Cashier {
	@Autowired
	private BookShopService bookShopService;

	//事务的默认传播行为为REEEQUIRED,即purchase的事务在checkout事务内运行（详情见笔记）
	@Transactional
	@Override//checkout方法被事务注解
	public void checkout(String username, List<Integer> isbns) {
		for(int isbn:isbns) {
			//purchase方法也被事务管理
			bookShopService.purchase(username, isbn);
		} 
	}
}
