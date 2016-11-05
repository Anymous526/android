package test.contact.db;

import test.contact.entity.User;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	public final static  String DB_NAME = "contact";
	public final static int VERSION = 1;
	
	private static DBHelper  instance = null;
	private SQLiteDatabase db = null;
	public static DBHelper getInstance(Context context){
		if(instance == null){
			instance = new DBHelper(context);
			
		}
		return instance;
	}
	private void openDatebase(){
		if(db == null){
			db = this.getWritableDatabase();
		}
	}
	private DBHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuffer tableCreate = new StringBuffer();
		tableCreate.append("create table user (_id integer primary key autoincrement,")
									.append("name text,")
									.append("mobilephone text,")
									.append("familyphone text,")
									.append("officephone text,")
									.append("position text,")
									.append("company text,")
									.append("address text,")
									.append("email text,")
									.append("othercontact text,")
									.append("zipcode text,")
									.append("remark text,")
									.append("imageid int)");
		db.execSQL(tableCreate.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql  = "drop table if exists user";
		db.execSQL(sql);
		onCreate(db);
		
	}

	public void save(User user){
		openDatebase();
		ContentValues value = new ContentValues();
		value.put("name", user.name);
		value.put("mobilephone", user.mobilePhone);
		value.put("familyphone", user.familyPhoe);
		value.put("officephone", user.officePhoe);
		value.put("position", user.postion);
		value.put("company", user.company);
		value.put("address", user.address);
		value.put("email", user.email);
		value.put("othercontact", user.otherContact);
		value.put("zipcode", user.zipCode);
		value.put("remark", user.remark);
		value.put("imageid", user.imageId);
		
		db.insert("user", null, value);
	}
}
