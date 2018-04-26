package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("BookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShopDao;
	
	/**
	 * 购书服务方法
	 * 这里不添加事务的话，可能出现书有库存，钱不够，执行的时候会出现，库存减一，但账户不扣钱！
	 */
	//1.传播属性propagation=Propagation.REQUIRES_NEW此时其他方法调用该方法时，purchase使用自己的事务，执行成功或失败与其他事务无关
	//2.isolation指定事务的隔离级别READ_COMMITTED（读已提交，最常用）
	//3.默认情况下Spring事务异常时，直接回滚,属性norollbackFor（类名）norollbackForClassName（全类名）指定哪些异常无需回滚
	//4.readOnly只读属性，设置为true则下列方法只能读取数据库，如果修改数据库，事务执行失败回滚
	//5.timeout设置过期时间，单位秒，超过该时间事务强制回滚，比如因网路，或CPU负载过大，导致事务处理出现卡顿，休眠等状况，超过该时间事务强制回滚
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED,
			readOnly=false,
			timeout=3)
			//noRollbackFor= {UserAccountException.class})通常情况不需设置，保持默认即可
	public void purchase(String username, int isbn) {
	//这里用线程休眠模拟其他因素导致执行该事务时出现暂停，时间为5s超过3s，事务回滚
		try {
			Thread.sleep(1000);//单位毫秒
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//1.获取书单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.更新书库存
		bookShopDao.updateBookStock(isbn);
		//3.更新用户账户余额
		bookShopDao.updateUserAccount(username, price);
	}

}
