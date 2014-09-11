package br.com.fiap.finance.core;

import java.io.File;

import br.com.fiap.finance.dao.CategoriesDAO;
import br.com.fiap.finance.dao.TransactionDAO;
import br.com.fiap.finance.dao.UserDAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

public class DataSource extends SQLiteOpenHelper
{

	protected Context context;
	protected SQLiteDatabase database;

	public static String DATABASE_COMPLETE = "";
	public static final String DATABASE_NAME = "finance.db";
	public static final String DATABASE_NAME_JOURNAL = "finance.db-journal";
	public static final int DATABASE_VERSION = 1;	
	
	private final String pathDatabase = "";
	
	static
	{
		if (br.com.fiap.finance.core.Environment.DEVELOPMENT)
		{
			DATABASE_COMPLETE = DATABASE_NAME ;
		}
		else
		{
			DATABASE_COMPLETE = Environment.getExternalStorageDirectory( ).getPath( )
					+ File.separator + DATABASE_NAME ;
		}
	}
	
	public DataSource( Context context )
	{
		super( context, DATABASE_COMPLETE, null, DATABASE_VERSION );
		this.context  = context;
		this.database = context.openOrCreateDatabase( DATABASE_COMPLETE, Context.MODE_PRIVATE, null );
		this.database = getWritableDatabase( );
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		createAllTables();
		
	}
	
	public boolean createAllTables( )
	{
		try
		{
			this.database.execSQL(TransactionDAO._setupSQL);
			this.database.execSQL(CategoriesDAO._setupSQL);
			this.database.execSQL(UserDAO._setupSQL);
			
		}
		catch(Exception e)
		{
			Log.println(0, "", "Ocorreu um erro ao criar o Banco de Dados!");
		}
		
		return false;
	}

	public boolean cleanUp( )
	{
		this.database.execSQL("TRUNCATE TABLE " + TransactionDAO.TABLE_NAME);
		this.database.execSQL("TRUNCATE TABLE " + CategoriesDAO.TABLE_NAME);
		this.database.execSQL("TRUNCATE TABLE " + UserDAO.TABLE_NAME);
		
		return false;
	}	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS " + TransactionDAO.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + CategoriesDAO.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + UserDAO.TABLE_NAME);
		onCreate( db );
		
	}
	
	public void close( )
	{
		this.database.close( ) ;
	}		

	
}
