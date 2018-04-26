package com.spring.tx.xml.service;
/**
 * 卖书服务
 * @author buhuaqi
 *
 */
public interface BookShopService {
	//根据书号卖书，实现书库存减一，用户账户扣除费用
	public void purchase(String username,int isbn);
}
