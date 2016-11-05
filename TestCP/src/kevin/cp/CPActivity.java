package kevin.cp;

import kevin.cp.FirstProviderMetaData.UserTableMetaData;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CPActivity extends Activity {
	Button insertButton;
	Button queryButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		insertButton = (Button) findViewById(R.id.btn_insert);
		insertButton.setOnClickListener(new insertOnClickListener());
		queryButton = (Button) findViewById(R.id.btn_query);
		queryButton.setOnClickListener(new queryOnClickListener());
	}

	class insertOnClickListener implements OnClickListener {

		@Override
		public void onClick(View view) {
			ContentValues value = new ContentValues();
			value.put(FirstProviderMetaData.UserTableMetaData.USER_NAME,
					"zhangsan");
			Uri uri = getContentResolver().insert(
					FirstProviderMetaData.UserTableMetaData.CONTENT_URI, value);
			System.out.println("uri--->" + uri.toString());

		}

	}

	class queryOnClickListener implements OnClickListener {

		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			Cursor c = getContentResolver().query(
					Uri.parse("content://kevin.cp.FirstContentProvider/users"), null,
					null, null, null);
			while(c.moveToNext()){
				System.out.println(c.getString(c.getColumnIndex(UserTableMetaData.USER_NAME)));
			}

		}

	}

}