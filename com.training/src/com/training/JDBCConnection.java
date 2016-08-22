package com.training;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author jlin Test
 */
public class JDBCConnection {

	public void test() {
	}

	// private static final String USERNAME = "sa";//webadmin
	// private static final String PASSWORD = "sasasa";//web1admin1
	// private static final String JDBCDriver =
	// "com.sybase.jdbc4.jdbc.SybDriver";
	// private static final String CONN_STRING =
	// "jdbc:sybase:Tds:%s:%d/%s?GET_COLUMN_LABEL_FOR_NAME=true&SYBSOCKET_FACTORY=%s";
	// private static final String CONN_STRING =
	// "jdbc:sybase:Tds:TRG67:7000/mds?GET_COLUMN_LABEL_FOR_NAME=true&SYBSOCKET_FACTORY=com.trgrp.fits.db.SybaseKeepAliveSocketFactory";
	// private static final String CONN_STRING =
	// "jdbc:sybase:Tds:TRG67:7000/mds";

	public static void main(String[] args) throws SQLException {

		String sql = "select * from Employees where BuildingID=?";
		ResultSet rs = null;
//		try (Connection conn = DBUtil.getConnection(DBType.SYBASE);
//				PreparedStatement pstmt = conn.prepareStatement(sql,
//						ResultSet.TYPE_SCROLL_INSENSITIVE,
//						ResultSet.CONCUR_READ_ONLY);) {
//			pstmt.setObject(1, 12);
//			rs = pstmt.executeQuery();
//			rs.last();
//			System.out.println(rs.getRow());
//		} catch (SQLException e) {
//			System.err.println(e);
//		} finally{
//			if(rs!=null){
//				rs.close();
//			}
//		}
		
		sql = "exec MyFirstProc ?";
		try (Connection conn = DBUtil.getConnection(DBType.SYBASE);
				CallableStatement cstmt = conn.prepareCall(sql,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);) {
			cstmt.setObject(1, 12);
			rs = cstmt.executeQuery();
			rs.next();
			System.out.println(rs.getObject("BuildingID"));
		} catch (SQLException e) {
			System.err.println(e);
		} finally{
			if(rs!=null){
				rs.close();
			}
		}

	}

}
