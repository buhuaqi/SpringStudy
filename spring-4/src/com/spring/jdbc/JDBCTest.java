package com.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

class JDBCTest {
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	//构造代码块，会在调用任何方法时都会将以下代码插入每个方法的最前端
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	@Test
	void t() {
		String sql = "DELETE from book_stock where isbn=1001";
		jdbcTemplate.update(sql);
	}
	/**
	 * ctrl+t显示一个类或者接口下面的子接口或子类
	 * 我们还可以使用创建对象的方法来update数据，将需要操作的数据存放到一个对象实例中，来更新
	 * 好处：因为sql中参数名必须与类属性一致，便于维护
	 * 缺点：较为麻烦
	 */
	@Test
	public void testNamedParameterJdbcTemplate2() {
		String sql = "insert into employees(last_name,email,dept_id) VALUES(:lastName,:email,:department)";
		Employee employee = new Employee();
		employee.setLastName("bhq");
		employee.setEmail("852462@qq.com");
		employee.setDepartment(2);
		
		//new一个bean属性sql参数源
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	/**
	 * NamedParameterJdbcTemplate对象必须传入带参数的
	 * 使用它执行的sql语句可以为参数起名（ln指代的是last_name）格式如下
	 * 他的update操作需要传入一个map集合
	 * 1.好处：数据表中参数多的时候这种方式更便于维护，因为之前修改表是通过？完成，而我们起了别名方便了维护
	 * 2.缺点：在添加数据的时候较为麻烦，因为map集合需要多个put来提供键值对的录入
	 */
	@Test
	public void testNamedParameterJdbcTemplate() {
		String sql = "insert into employees(last_name,email,dept_id) VALUES(:ln,:email,:dept_id)";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ln", "阿萨德");
		paramMap.put("email", "136059151@qq.com");
		paramMap.put("dept_id",2);
		namedParameterJdbcTemplate.update(sql, paramMap);//需要一个Map集合
	}
	
	/**
	 * 统计数据表中个数
	 */
	@Test
	void testQueryForObject1() {
		String sql = "select count(id) from employees";//查询id个数
		System.out.println(jdbcTemplate.queryForObject(sql, Long.class));//因为返回值为数字，我们无须使用RowMapper来指定结果类型，直接用java自带的Long来返回数值
	}
	
	/**
	 * 查到实体类的集合(批量查询，结果集放到List集合)
	 * jdbcTemplate.query()查询方法返回一个List集合，我们依旧用rowMapper来指定结果集类型
	 */
	@Test
	void testQueryForList() {
		String sql = "select * from employees where id>=?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper,1);
	
		System.out.println(employees);
	}
	
	/**
	 * 从数据库中获取一条记录，实际得到对应的一个对象 
	 * JdbcTemplate.queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args) 方法来执行查询
	 * 1.其中的RowMapper指定如何去映射结果集，常用的实现类为BeanPropertyRowMapper
	 * 2.不支持级联属性，JdbcTemplate是一个JDBC工具，不是ORM框架
	 */
	@Test
	void testQueryForObject() {
		String sql = "select * from employees where id=?";
		
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 2);
		
		System.out.println(employee);
	}
	
	/**
	 * 批量更新
	 * 使用JdbcTemplate对象提供的batchUpdate方法批量操作
	 */
	@Test
	void testBatchUpdate() {
		String sql="INSERT INTO employees(last_name,email,dept_id) VALUES(?,?,?)";
		
		//由下述可知batchArgs是一个数组集合
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		
		Object[] object=new Object[] {"小民","287510038@qq.com","1"};
		Object[] object1=new Object[] {"文案","287510038@qq.com","1"};
		Object[] object2=new Object[] {"王涛","287510038@qq.com","1"};
		batchArgs.add(object);//可以直接写成batchArgs.add(new Object[] {"buhuaqi","287510038@qq.com","1"});
		batchArgs.add(object1);
		batchArgs.add(object2);
		
		jdbcTemplate.batchUpdate(sql,batchArgs);
	}
	
	/**
	 * 执行UPDATE,DELETE,INSERT
	 */
	@Test
	void testUpdate() {
		String sql="UPDATE employees SET last_name = ? WHERE id = ?";
		jdbcTemplate.update(sql, "卜华奇","1");
	}
	
	/**
	 * 测试数据源是否连接正常
	 * @throws SQLException
	 */
	@Test
	void testDataSource() throws SQLException {
		DataSource dataSource= (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}

}
