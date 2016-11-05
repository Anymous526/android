package kevin.SQLite;

import kevin.db.DatabaseHelper;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SQLiteDemo extends Activity {
   Button createButton;
   Button deleteButton;
   Button updateButton;
   Button searchButton;
   Button insertButton;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        createButton = (Button)findViewById(R.id.btn_create);
        deleteButton = (Button)findViewById(R.id.btn_delete);
        updateButton = (Button)findViewById(R.id.btn_update);
        searchButton = (Button)findViewById(R.id.btn_search);
        insertButton = (Button)findViewById(R.id.btn_insert);
        
        createButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				//创建一个DatabaseHelper对象
				DatabaseHelper dbHelper = new DatabaseHelper(SQLiteDemo.this, "text_kevin_db");
				//只有调用的DatabaseHelper对象的getReadtableDatabase()方法,或者getWriteableDatabase()方法.才会调用DatabaseHelper类中的onCreate()
				SQLiteDatabase db = dbHelper.getReadableDatabase();
			}});
        
        deleteButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				
			}});
        
        updateButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				DatabaseHelper dbHelper = new DatabaseHelper(SQLiteDemo.this, "text_kevin_db");
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("name", "zhangsanfeng");
				db.update("user", values, "id=?", new String[]{"1"});
				
			}});
        
        searchButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				DatabaseHelper dh = new DatabaseHelper(SQLiteDemo.this,"text_kevin_db");
				SQLiteDatabase db = dh.getReadableDatabase();
				Cursor c  = db.query("user", null, null, null, null,  null, null);
				while(c.moveToNext()){
					System.out.println(c.getInt(c.getColumnIndex("id")));
					System.out.println(c.getString(c.getColumnIndex("name")));
				}
				
				
			}});
        
        insertButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				ContentValues con = new ContentValues();
				con.put("id", 1);
				con.put("name","sunxun");
				DatabaseHelper databaseHelper= new DatabaseHelper(SQLiteDemo.this, "text_kevin_db");
				SQLiteDatabase db = databaseHelper.getWritableDatabase();
				db.insert("user", null, con);
				
			}
		});
    }
}