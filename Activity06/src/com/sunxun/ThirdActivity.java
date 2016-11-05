package com.sunxun;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThirdActivity extends Activity {
	Button button;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        button = (Button)findViewById(R.id.btn_third);
        button.setText("·¢ËÍ¶ÌÐÅ");
        button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				Uri  uri = Uri.parse("smsto://10086");
				Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
				intent.putExtra("sms_body", "The SMS test");
				startActivity(intent);
				
			}
        	
        });
    }
}
