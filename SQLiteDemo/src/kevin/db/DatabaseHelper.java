package kevin.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 * @author kevin
 *DatabaseHelper作为一个访问SQLite的助手类,提供两方面的功能
 *第一,getReadableDatabase(),getWriteableDatabae()可获得SQLiteDatabase对象
 *		通过SQLiteDatabase对象进行对数据库操作
 *第二.提供了onCreate()和onUpgrade()两个回调函数.允许我们创建和升级数据库时.
 *			 进行自己操作
 */
public class DatabaseHelper extends SQLiteOpenHelper{
	private static final int VERSION = 1;
	
	//在SQLiteOpenHelper的子类当中,必有该构造函数
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		}
	
	public DatabaseHelper(Context context, String name) {
		 this(context, name, VERSION);
		}

	public DatabaseHelper(Context context, String name, int version) {
		super(context, name, null, version);
		}
	
	/**
	 * 该函数在第一次创建的时候执行,
	 * 实际是在第一次得到SQLiteDatabase对象时被执行
	 * 
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("create a Database");
		//exceSQL函数用于执行SQL语句
		db.execSQL("create table user(id int,name varchar(20))");
		
	}

	/**
	 * 
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("Update a Database");
		
	}

}
