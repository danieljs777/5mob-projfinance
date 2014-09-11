package br.com.fiap.finance.dao;

public class TransactionDAO {
	
	public final static String TABLE_NAME  = "transaction";
	
	public final static String _setupSQL   = "CREATE TABLE " + TABLE_NAME +
			"(" +
			" tran_id integer auto_increment primary key," +
			" description varchar(50) not null," +
			" type smallint not null," +
			" amount decimal(9,2) not null," +
			" tran_date date not null," +
			" tran_time time," +
			" gps_coordinations varchar(100)," +
			" payment_method smallint " +
			" )";
	
	
	
	public boolean insert(String[] data)
	{
		String sqlStatement = "INSERT INTO " + this.TABLE_NAME;
		
		
		return false;
		
	}
	
	

}
