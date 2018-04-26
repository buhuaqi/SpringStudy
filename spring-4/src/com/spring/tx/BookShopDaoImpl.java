package com.spring.tx;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * mysql不支持检查约束，我们需要手动验证
 * @author buhuaqi
 *
 */
@Repository("BookShopDao")
public class BookShopDaoImpl implements BookShopDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	//根据书号查询单价
	public int findBookPriceByIsbn(int isbn) {
		String sql = "select price from book where isbn=?";
		int price = jdbcTemplate.queryForObject(sql, int.class, isbn);
		return price;
	}

	@Override
	//根据书号更新库存（库存-1）,添加验证
	public void updateBookStock(int isbn) {
		String sql2="select stock from book_stock where isbn=?";
		int stock = jdbcTemplate.queryForObject(sql2, int.class,isbn);
		
		if(stock>0) {
			String sql ="update book_stock set stock=stock-1 where isbn=?";
			jdbcTemplate.update(sql,isbn);
		}else {
			throw new BookStockException("库存不足");
		}
	}

	@Override
	//更新账户余额,使username的balance-price，添加验证
	public void updateUserAccount(String username, int price) {
		String sql2 = "select balance from account where username=?";
		int account = jdbcTemplate.queryForObject(sql2, int.class, username);
		
		if(account-price>=0) {
			String sql = "update account set balance=balance-? where username=?";
			jdbcTemplate.update(sql,price,username);
		}else {
			throw new UserAccountException("余额不足");
		}
		
	}

}
