package test.contact.db;

import java.util.ArrayList;
import java.util.HashMap;

import test.contact.entity.User;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

@SuppressWarnings("unchecked")
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

	public long save(User user){
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
		return db.insert("user", null, value);
	}
	public ArrayList getUserList() {
		openDatebase();
		Cursor cursor = db.query("user", null, null, null, null,null, null);
		ArrayList list = new ArrayList();
		while(cursor.moveToNext()){
			HashMap map = new HashMap();
			map.put("_id", cursor.getInt(cursor.getColumnIndex("_id")));
			map.put("familyphone", cursor.getInt(cursor.getColumnIndex("familyphone")));
			map.put("officephone", cursor.getInt(cursor.getColumnIndex("officephone")));
			map.put("position", cursor.getInt(cursor.getColumnIndex("position")));
			map.put("company", cursor.getInt(cursor.getColumnIndex("company")));
			map.put("address", cursor.getInt(cursor.getColumnIndex("address")));
			map.put("email", cursor.getInt(cursor.getColumnIndex("email")));
			map.put("othercontact", cursor.getInt(cursor.getColumnIndex("othercontact")));
			map.put("zipcode", cursor.getInt(cursor.getColumnIndex("zipcode")));
			map.put("remark", cursor.getInt(cursor.getColumnIndex("remark")));
			map.put("imageid", cursor.getInt(cursor.getColumnIndex("imageid")));
			map.put("name", cursor.getString(cursor.getColumnIndex("name")));
			map.put("mobilephone", cursor.getString(cursor.getColumnIndex("mobilephone")));
			list.add(map);
		}
		return list;
	}
}
