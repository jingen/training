package com.training;

public enum DBType {

	SYBASE("Sybase"), MYSQL("Mysql");
	
	private String dbName;
	DBType(String dbName){
		this.dbName = dbName;
	}
	
	@Override
	public String toString(){
		return this.dbName;
	}
}
