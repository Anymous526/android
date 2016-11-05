package kevin.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 * @author kevin
 *DatabaseHelper��Ϊһ������SQLite��������,�ṩ������Ĺ���
 *��һ,getReadableDatabase(),getWriteableDatabae()�ɻ��SQLiteDatabase����
 *		ͨ��SQLiteDatabase������ж����ݿ����
 *�ڶ�.�ṩ��onCreate()��onUpgrade()�����ص�����.�������Ǵ������������ݿ�ʱ.
 *			 �����Լ�����
 */
public class DatabaseHelper extends SQLiteOpenHelper{
	private static final int VERSION = 1;
	
	//��SQLiteOpenHelper�����൱��,���иù��캯��
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
	 * �ú����ڵ�һ�δ�����ʱ��ִ��,
	 * ʵ�����ڵ�һ�εõ�SQLiteDatabase����ʱ��ִ��
	 * 
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("create a Database");
		//exceSQL��������ִ��SQL���
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
