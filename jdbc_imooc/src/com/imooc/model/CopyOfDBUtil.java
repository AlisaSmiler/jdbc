package com.imooc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CopyOfDBUtil
{

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	private static final String URL = "jdbc:mysql://192.168.135.130:3306/imooc";
	private static final String USERNAME = "root";
	private static final String PASSWD = "666666";
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{

//		1、加载驱动程序
	    Class.forName("com.mysql.jdbc.Driver");
//	    2、创建数据库链接
	    Connection conn=DriverManager.getConnection(URL, USERNAME, PASSWD);
//	    3、操作数据库
	    Statement stmt =  conn.createStatement();
	    ResultSet rs = stmt.executeQuery("select user_name,age from imooc_goddess"); 
	  
	    while(rs.next()){
	    	System.out.println(rs.getString("user_name")+","+rs.getInt("age"));
	    }
	    
		
	}

}
