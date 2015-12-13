package com.imooc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil
{

	private static final String URL = "jdbc:mysql://192.168.135.130:3306/imooc?useUnicode=true&characterEncoding=UTF-8";
	
	
	
	private static final String USERNAME = "root";
	private static final String PASSWD = "666666";
	
	public static  Connection getConn() throws ClassNotFoundException, SQLException{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn=DriverManager.getConnection(URL, USERNAME, PASSWD);
	    return conn;
	}

	public  static List<Goddess>  query() throws ClassNotFoundException, SQLException
	{
		List<Goddess> list = new ArrayList<Goddess>() ;//List

		Goddess g = null;
		Connection conn = getConn();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("select user_name,age from imooc_goddess");

		while (rs.next())
		{
			g = new Goddess();
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			list.add(g);
		}
		return list;    	
	}
	
	public  static Goddess  queryOneGoddess(Integer id) throws ClassNotFoundException, SQLException 
	{

		Goddess g = null;
		Connection conn = getConn();
//		Statement stmt = conn.createStatement();
		String sql = " select user_name,age from imooc_goddess" 
		            +" where id = ? ";
		
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while (rs.next())
		{
			g = new Goddess();
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
		}
		return g;   
	}

	
	public static Goddess queryGoddess(String username) throws ClassNotFoundException, SQLException{
		Goddess g =   null;
		Connection conn = getConn();
		StringBuilder sb=new StringBuilder();

		sb.append(" select user_name,age from imooc_goddess" );
		sb.append(" where user_name like ?");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString()) ;
		ptmt.setString(1, "%"+username+"%");
		System.out.println(sb.toString());

		ResultSet rs=ptmt.executeQuery();
				
		while (rs.next())
		{
			g = new Goddess();
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
		}
		return g;   


	}
	
	
	public void queryGoddess(int age){
		
	}
	
	public  void addGoddess()
	{

	}
	
	public void delGoddess(){
		
	}

	public void updateGoddess(){
		
	}
	


	

	
	
	

	


}
