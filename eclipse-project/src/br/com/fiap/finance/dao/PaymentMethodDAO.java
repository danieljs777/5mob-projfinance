package br.com.fiap.finance.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import br.com.fiap.finance.core.DataSource;
import br.com.fiap.finance.model.CategoryVO;
import br.com.fiap.finance.model.PaymentMethodVO;
import br.com.fiap.finance.model.TransactionVO;

public class PaymentMethodDAO extends DataSource {

	public final static String TABLE_NAME  = "payment_method";
	private SQLiteStatement insertStmt ;
	private SQLiteStatement updateStmt ;
	
	private PaymentMethodVO voReference;
	
	
	private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
			"( category )" +
			" values (?)" ;
	
	private static final String UPDATE = "UPDATE " + TABLE_NAME + " SET" +
			" description = ?" +
			" WHERE id = ? " ;		
	
	public final static String _setupSQL   = "CREATE TABLE " + TABLE_NAME +
			"(" +
			" id integer auto_increment primary key," +
			" description varchar(20) not null" +
			" )";
	
	
	public PaymentMethodDAO(Context context) {
		super(context);
	}
	
	public PaymentMethodVO getById(Integer id)
	{
		PaymentMethodVO payment = new PaymentMethodVO( ) ;
		
		Cursor cursor = this.database.rawQuery( "SELECT * FROM " + TABLE_NAME + " WHERE id = ?", new String[] { id.toString() } ) ;
		if (cursor.moveToFirst( ))
		{
			payment.setId( cursor.getInt( 0 ) ) ;
			payment.setDescription( cursor.getString( 1 ) ) ;
		}
		
		if (cursor != null && !cursor.isClosed( ))
		{
			cursor.close( ) ;
		}
		
		return payment;
	}	
	
	public long insert(PaymentMethodVO vo)
	{
		this.voReference = vo;
		this.insertStmt = super.database.compileStatement( INSERT ) ;
		this.insertStmt = this._prepareStatement(this.insertStmt, false);
		
		return this.insertStmt.executeInsert( ) ;		
		
	}
	
	public long update(PaymentMethodVO vo)
	{
		this.voReference = vo;
		this.updateStmt = super.database.compileStatement( UPDATE ) ;
		this.updateStmt = this._prepareStatement(this.updateStmt, true);
		
		return this.updateStmt.executeUpdateDelete() ;		
		
	}		
	
	private SQLiteStatement _prepareStatement(SQLiteStatement statement, boolean update)
	{
		statement.bindString( 1, this.voReference.getDescription() ) ;
		
		if(update)
			statement.bindLong( 2, this.voReference.getId() ) ;	
		
		return statement;
		
	}
	
	private CategoryVO _populateVO(Cursor cursor)
	{
		CategoryVO category = new CategoryVO( ) ;
		category.setId( cursor.getInt( 0 ) ) ;
		category.setDescription( cursor.getString( 1 ) ) ;
		
		return category;
	}			

	
	

}
