package mars.activity02;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class activity02 extends Activity {
	/** Called when the activity is first created. */
	private Button myButton = null;
	private Button Jump = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView t = (TextView) findViewById(R.id.tv);
		t.setText(Html.fromHtml("<font color=blue>哈哈</font>"));

		Jump = (Button) findViewById(R.id.btn_jump);
		myButton = (Button) findViewById(R.id.myButton);
		myButton.setText("发送短信");
		myButton.setOnClickListener(new MyButtonListerner());
		Jump.setText("跳到下一个Activity");
		Jump.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent inten = new Intent();
				inten.putExtra("textInfo", "text1234");
				inten.setClass(activity02.this, OtherActivity.class);
				activity02.this.startActivity(inten);

			}
		});
	}

	class MyButtonListerner implements OnClickListener {

		public void onClick(View v) {
			Uri uri = Uri.parse("smsto://0800000123");
			Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
			// Extra是一对键值对
			intent.putExtra("sms_body", "The SMS text");
			startActivity(intent);

		}
	}

}