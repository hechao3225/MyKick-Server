package com.hitech.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MysqlHelper {
	
	// ��ȡ����Դ����c3p0��jar���ṩ
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	private MysqlHelper(){
	}
	
	/**
	 * ��ȡ����Դ
	 * @return ����Դ����
	 */
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}
	
	/**
	 * ��ȡ���ݿ����Ӷ��󣬷���ִ������
	 * @return ���ݿ����Ӷ���
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
