package com.imooc.test;

import java.sql.SQLException;
import java.util.List;

import com.imooc.model.DBUtil;
import com.imooc.model.Goddess;

public class Main
{

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		
//		List<Goddess> aa = DBUtil.query();
//		for (Goddess goddess : aa)
//		{
//			System.out.println(goddess.toString());
//		}
		
		System.out.println(DBUtil.queryOneGoddess(1).toString());
		System.out.println(DBUtil.queryGoddess("xiaohua").toString());
		System.out.println(DBUtil.queryGoddess("小美").toString());


		
		

	}

}
