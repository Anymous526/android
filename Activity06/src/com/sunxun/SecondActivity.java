package com.sunxun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {
	Button button;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        button = (Button)findViewById(R.id.btn_second);
        button.setText("启动第三个Activity");
        button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.setClass(SecondActivity.this, ThirdActivity.class);
				startActivity(intent);
				
			}
        	
        });
    }
}
