package br.com.fiap.finance.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import br.com.fiap.finance.core.DataSource;
import br.com.fiap.finance.model.CategoryVO;
import br.com.fiap.finance.model.PaymentMethodVO;
import br.com.fiap.finance.model.TransactionCategoryVO;
import br.com.fiap.finance.model.TransactionVO;

public class TransactionCategoryDAO extends DataSource {
	
	public final static String TABLE_NAME  = "transaction_category";
	private SQLiteStatement insertStmt ;
	private SQLiteStatement updateStmt ;
	
	private TransactionCategoryVO voReference;
	
	private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
			"( tran_id, cat_id  )" +
			" values (?, ?)" ;
	
	private static final String UPDATE = "UPDATE " + TABLE_NAME + " SET" +
			" tran_id = ?, cat_id = ?" +
			" WHERE id = ? " ;			
	
	public final static String _setupSQL   = "CREATE TABLE " + TABLE_NAME +
			"(" +
			" tran_id integer," +
			" cat_id integer," +
			" primary key(tran_id, cat_id)" +
			" )";
	
	public TransactionCategoryDAO(Context context) {
		super(context);
	}	
	
	public long insert(TransactionCategoryVO vo)
	{
		this.voReference = vo;
		this.insertStmt = super.database.compileStatement( INSERT ) ;
		this.insertStmt = this._prepareStatement(this.insertStmt, false);
		
		return this.insertStmt.executeInsert( ) ;		
		
	}
	
	public long update(TransactionCategoryVO vo)
	{
		this.voReference = vo;
		this.updateStmt = super.database.compileStatement( UPDATE ) ;
		this.updateStmt = this._prepareStatement(this.updateStmt, true);
		
		return this.updateStmt.executeUpdateDelete() ;		
		
	}		
	
	private SQLiteStatement _prepareStatement(SQLiteStatement statement, boolean update)
	{
		statement.bindLong( 1, this.voReference.getTranId() ) ;
		statement.bindLong( 2, this.voReference.getCatId() ) ;
		
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
