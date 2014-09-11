package br.com.fiap.finance.dao;

public class CategoriesDAO {
	
	public final static String TABLE_NAME  = "categories";
	
	public final static String _setupSQL   = "CREATE TABLE " + TABLE_NAME +
			"(" +
			" cat_id integer auto_increment primary key," +
			" description varchar(20) not null" +
			" )";
	
	
	
	
	

}
