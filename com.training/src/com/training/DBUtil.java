package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String USERNAME = "sa";//webadmin
	private static final String PASSWORD = "sasasa";//web1admin1
	private static final String CONN_STRING = "jdbc:sybase:Tds:TRG67:7000/mds";
	
	public static Connection getConnection(DBType dbType) throws SQLException{
		switch(dbType){
		case SYBASE:
			System.out.println(DBType.SYBASE);
            return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		case MYSQL:
			System.out.println(DBType.MYSQL);
            return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
        default:
			System.out.println("Other");
            return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		}
	}
}
