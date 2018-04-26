package com.spring.tx;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {
	private ApplicationContext applicationContext=null;
	private BookShopDao bookShopDao=null;
	private BookShopService bookShopService=null;
	private Cashier cashier = null;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopDao = (BookShopDao) applicationContext.getBean("BookShopDao");
		bookShopService = (BookShopService) applicationContext.getBean("BookShopService");
		cashier = (Cashier) applicationContext.getBean("Cashier");
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
	
	/**
	 * 以下全是测试单个方法
	 */
	@Test
	//JUnit测试不能传参数，这里我们直接指定isbn
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn(1001));
	}
	
	@Test
	public void testBookShopDaoUpdateBookStock() {
			bookShopDao.updateBookStock(1001);
	}
	
	@Test
	public void testBookShopDaoupdateUserAccount() {
		bookShopDao.updateUserAccount("AA", 800);
	}
}
