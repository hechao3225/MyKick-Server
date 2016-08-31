package com.hitech.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MysqlHelper {
	
	// 获取数据源，由c3p0的jar包提供
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	private MysqlHelper(){
	}
	
	/**
	 * 获取数据源
	 * @return 数据源对象
	 */
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}
	
	/**
	 * 获取数据库连接对象，方便执行事务
	 * @return 数据库连接对象
	 */
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
