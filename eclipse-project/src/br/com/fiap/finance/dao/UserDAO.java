package br.com.fiap.finance.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import br.com.fiap.finance.core.DataSource;
import br.com.fiap.finance.model.TransactionVO;
import br.com.fiap.finance.model.UserVO;

public class UserDAO extends DataSource {
	
	public final static String TABLE_NAME  = "user";
	private SQLiteStatement insertStmt ;
	private SQLiteStatement updateStmt ;
	
	private UserVO voReference;	
	
	public final static String _setupSQL   = "CREATE TABLE " + TABLE_NAME +
			"(" +
			" id integer auto_increment primary key," +
			" user_name varchar(20) not null," +
			" login varchar(20) not null," +
			" password varchar(40) not null," +
			" enable bool default 1" +
			" )";
	
	private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
			"( user_name, login, password )" +
			" values (?, ?, ?)" ;		
	
	public UserDAO(Context context) {
		super(context);
		
	}		
	
	public long insert(UserVO vo)
	{
		this.voReference = vo;
		this.insertStmt = super.database.compileStatement( INSERT ) ;
		this.insertStmt = this._prepareStatement(this.insertStmt, false);
		
		return this.insertStmt.executeInsert( ) ;		
		
	}	
	
	private SQLiteStatement _prepareStatement(SQLiteStatement statement, boolean update)
	{
		statement.bindString( 1, this.voReference.getUserName() ) ;
		statement.bindString( 2, this.voReference.getLogin() ) ;
		statement.bindString( 3, this.voReference.getPassword() ) ;
		
		if(update)
			statement.bindLong( 4, this.voReference.getId() ) ;	
		
		return statement;
		
	}
	
	private UserVO _populateVO(Cursor cursor)
	{
		UserVO user = new UserVO( ) ;

		user.setUserName( cursor.getString( 1 ) ) ;
		
		return user;
	}		
	
	
	public Boolean authenticate( String userName, String password)
	{
		List<UserVO> list = new ArrayList<UserVO>( ) ;
		Cursor cursor = this.database.rawQuery( "SELECT * FROM " + TABLE_NAME + " WHERE user_name = ? AND password = ?", 
												new String[] { userName.toString(), password.toString() } ) ;

		boolean authenticated = (cursor.getCount() > 1);
		
		if (cursor != null && !cursor.isClosed( ))
		{
			cursor.close( ) ;
		}
		
		return authenticated ;
	}	
	

	

}
