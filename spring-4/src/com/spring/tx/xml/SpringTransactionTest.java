package com.spring.tx.xml;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.tx.xml.service.BookShopService;
import com.spring.tx.xml.service.Cashier;

public class SpringTransactionTest {
	private ApplicationContext applicationContext=null;
	private BookShopDao bookShopDao=null;
	private BookShopService bookShopService=null;
	private Cashier cashier = null;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext-tx-xml.xml");
		bookShopDao = (BookShopDao) applicationContext.getBean("bookShopDao");
		bookShopService = (BookShopService) applicationContext.getBean("bookShopService");
		cashier = (Cashier) applicationContext.getBean("cashier");
	}
	
	/**
	 * 测试事务传播行为
	 */
	@Test
	public void testTransactionlProragation() {
		cashier.checkout("AA", Arrays.asList(1001,1002));
	}
	
	/**
	 * 测试购书服务
	 */
	@Test
	public void testBookShopService() {
		bookShopService.purchase("AA", 1001);
	}
	

}
