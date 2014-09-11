package br.com.fiap.finance.dao;

public class UserDAO {
	
	public final static String TABLE_NAME  = "user";
	
	public final static String _setupSQL   = "CREATE TABLE " + TABLE_NAME +
			"(" +
			" user_id integer auto_increment primary key," +
			" user_name varchar(20) not null," +
			" login varchar(20) not null," +
			" password varchar(40) not null," +
			" enable bool default 1" +
			" )";
	
	
	
	
	

}
