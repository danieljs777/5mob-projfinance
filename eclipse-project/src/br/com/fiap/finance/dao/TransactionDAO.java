package br.com.fiap.finance.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import br.com.fiap.finance.core.DataSource;
import br.com.fiap.finance.model.TransactionVO;

public class TransactionDAO extends DataSource {

	public final static String TABLE_NAME  = "transaction";
	private SQLiteStatement insertStmt ;
	private SQLiteStatement updateStmt ;
	
	private TransactionVO voReference;
	
	public final static String _setupSQL   = "CREATE TABLE " + TABLE_NAME +
			"(" +
			" id integer auto_increment primary key," +
			" category integer" +
			" description varchar(50) not null," +
			" type smallint not null," +
			" amount decimal(9,2) not null," +
			" tran_date date not null," +
			" tran_time time," +
			" gps_coordinations varchar(100)," +
			" payment_method integer," +
			" store varchar(50)," +
			" )";
	
	private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
			"( category, description, type, amount, tran_date, tran_time, gps_coordinations, payment_method, store )" +
			" values (?, ?, ?, ?, ?, ?, ?, ?)" ;
	
	private static final String UPDATE = "UPDATE " + TABLE_NAME + " SET" +
			" category = ?, description = ?, type=?, amount=?, tran_date=?, tran_time=?, gps_coordinations=?, payment_method=?, store=?" +
			" WHERE id = ? " ;

	public TransactionDAO(Context context) {
		super(context);
		
	}	
	
	public long insert(TransactionVO vo)
	{
		this.voReference = vo;
		this.insertStmt = super.database.compileStatement( INSERT ) ;
		this.insertStmt = this._prepareStatement(this.insertStmt, false);
		
		return this.insertStmt.executeInsert( ) ;		
		
	}
	
	public long update(TransactionVO vo)
	{
		this.voReference = vo;
		this.updateStmt = super.database.compileStatement( UPDATE ) ;
		this.updateStmt = this._prepareStatement(this.updateStmt, true);
		
		return this.updateStmt.executeUpdateDelete() ;		
		
	}	
	
	public void deleteAll( )
	{
		super.database.delete( TABLE_NAME, null, null ) ;
	}	
	
	public List<TransactionVO> selectAll( )
	{
		List<TransactionVO> list = new ArrayList<TransactionVO>( ) ;
		Cursor cursor = this.database.query( TABLE_NAME, null, null, null, null, null, "codigo" ) ;
		if (cursor.moveToFirst( ))
		{
			do
			{
				TransactionVO transacao = this._populateVO(cursor);

				list.add( transacao ) ;
			}
			while (cursor.moveToNext( )) ;
		}
		if (cursor != null && !cursor.isClosed( ))
		{
			cursor.close( ) ;
		}
		return list ;
	}	
	
	public List<TransactionVO> selectAllByCategory( Integer catId )
	{
		return this.selectAllByCriteria("category", catId);
	}

	public List<TransactionVO> selectAllByType( Integer typeId )
	{
		return this.selectAllByCriteria("type", typeId);
	}
	
	public List<TransactionVO> selectAllByPayment( Integer paymId )
	{
		return this.selectAllByCriteria("payment_method", paymId);
	}	

	public List<TransactionVO> selectAllByCriteria( String field, Integer catId )
	{
		List<TransactionVO> list = new ArrayList<TransactionVO>( ) ;
		Cursor cursor = this.database.rawQuery( "SELECT * FROM " + TABLE_NAME + " WHERE " + field + " = ?", new String[] { catId.toString() } ) ;
		
		if (cursor.moveToFirst( ))
		{
			do
			{
				TransactionVO transacao = this._populateVO(cursor);

				list.add( transacao ) ;
			}
			while (cursor.moveToNext( )) ;
		}
		if (cursor != null && !cursor.isClosed( ))
		{
			cursor.close( ) ;
		}
		
		return list ;
	}		
	
	public List<TransactionVO> selectAllByDateRange( String isoDateStart, String isoDateEnd)
	{
		List<TransactionVO> list = new ArrayList<TransactionVO>( ) ;
		Cursor cursor = this.database.rawQuery( "SELECT * FROM " + TABLE_NAME + " WHERE tran_date BETWEEN ? AND ?", 
												new String[] { isoDateStart.toString(), isoDateEnd.toString() } ) ;
		
		if (cursor.moveToFirst( ))
		{
			do
			{
				TransactionVO transacao = this._populateVO(cursor);

				list.add( transacao ) ;
			}
			while (cursor.moveToNext( )) ;
		}
		if (cursor != null && !cursor.isClosed( ))
		{
			cursor.close( ) ;
		}
		return list ;
	}
	
	public TransactionVO getById(Integer id)
	{

		TransactionVO transacao = new TransactionVO();
		
		Cursor cursor = this.database.rawQuery( "SELECT * FROM " + TABLE_NAME + " WHERE id = ?", new String[] { id.toString() } ) ;
		if (cursor.moveToFirst( ))
		{
			transacao = this._populateVO(cursor);
		}
		
		if (cursor != null && !cursor.isClosed( ))
		{
			cursor.close( ) ;
		}
		
		return transacao;
	}
	
	private TransactionVO _populateVO(Cursor cursor)
	{
		TransactionVO transacao = new TransactionVO( ) ;
		transacao.setId( cursor.getInt( 0 ) ) ;
		transacao.setDescription( cursor.getString( 1 ) ) ;
		transacao.setType( cursor.getInt( 2 ) ) ;
		transacao.setAmount( cursor.getDouble( 3 ) ) ;
		transacao.setTranDate( cursor.getString( 4 ) ) ;
		transacao.setTranTime( cursor.getString( 5 ) ) ;
		transacao.setGpsCoordinations( cursor.getString( 6 ) ) ;
		transacao.setPaymentMethod( cursor.getInt( 7 ) ) ;
		transacao.setStore( cursor.getString( 8 ) ) ;
		
		return transacao;
	}	
	
	private SQLiteStatement _prepareStatement(SQLiteStatement statement, boolean update)
	{
		statement.bindString( 1, this.voReference.getDescription() ) ;
		statement.bindDouble( 2, this.voReference.getType() ) ;
		statement.bindDouble( 3, this.voReference.getAmount() ) ;
		statement.bindString( 4, this.voReference.getTranDate().toString() ) ;
		statement.bindString( 5, this.voReference.getTranTime() ) ;
		statement.bindString( 6, this.voReference.getGpsCoordinations() ) ;
		statement.bindLong( 7, this.voReference.getPaymentMethod() ) ;
		statement.bindString( 8, this.voReference.getStore() ) ;	
		
		if(update)
			statement.bindLong( 9, this.voReference.getId() ) ;	
		
		return statement;
		
	}

}
