package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author jlin Test
 */
public class JDBCConnection {

	public void test() {
	}

	private static final String USERNAME = "sa";//webadmin
	private static final String PASSWORD = "sasasa";//web1admin1
	private static final String JDBCDriver = "com.sybase.jdbc4.jdbc.SybDriver";
//	private static final String CONN_STRING = "jdbc:sybase:Tds:%s:%d/%s?GET_COLUMN_LABEL_FOR_NAME=true&SYBSOCKET_FACTORY=%s";
//	private static final String CONN_STRING = "jdbc:sybase:Tds:TRG67:7000/mds?GET_COLUMN_LABEL_FOR_NAME=true&SYBSOCKET_FACTORY=com.trgrp.fits.db.SybaseKeepAliveSocketFactory";
	private static final String CONN_STRING = "jdbc:sybase:Tds:TRG67:7000/mds";

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from Employees where BuildingID=21";
		try {
			sql = "GetOrders";
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
                System.out.println("Number of row: " + rs.getRow() + " OrderID: " + rs.getString("OrderID"));
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			System.err.println(e);
		} finally{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		
	}

}
