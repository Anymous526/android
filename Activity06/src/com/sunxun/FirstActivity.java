/**
 *  ��ʾActivity��task.Activitys �ᱻ����һ��ջ��.�Ƚ������ԭ��.���Activity������finish();����ʱ.
 *  �ͻᱻ����,�������ջ��
 */
package com.sunxun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstActivity extends Activity {
    Button button;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        button = (Button)findViewById(R.id.btn_first);
        button.setText("�����ڶ���Activity");
        button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.setClass(FirstActivity.this, SecondActivity.class);
				startActivity(intent);
				finish();
				
			}
        	
        });
    }
}