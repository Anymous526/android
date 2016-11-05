package mars.activity02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity{
	private TextView myTextView = null;
	private TextView myTextView1 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		//得到Intent 
		Intent intent = getIntent();
		//得到intent中的
		String value =  intent.getStringExtra("textInfo");
		
		myTextView = (TextView)findViewById(R.id.myTextView);
		myTextView1 = (TextView)findViewById(R.id.textView);
		myTextView.setText(R.string.other);
		myTextView1.setText("接收到的数据:;"+value);
	}
	
}
