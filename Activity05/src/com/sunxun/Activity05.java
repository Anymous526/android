/**
 * 演示了第二个Activity是对话框的形式.需要在AndroidManifest.xml配置该Activity时指定 
 * android:theme="@android:style/Theme.Dialog"
 */
package com.sunxun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity05 extends Activity {
    Button button = null;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        button = (Button)findViewById(R.id.btn_fir);
        button.setText("跳到第二个Activity");
        button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(Activity05.this,SecondActivity.class);
				startActivity(intent);
			}
        	
        });
    }
}