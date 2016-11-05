package com.sunxun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity{
	String info = "SecodnActivity";
	Button button;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        System.out.println(info + "OnCreate Calling");
        button = (Button)this.findViewById(R.id.btn_button);
        button.setText("µÚ¶þ¸ö");
        button.setOnClickListener(new OnClickListener(){
        	@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent();
				
				
			}
        });
    }

	protected void onStart() {
		System.out.println(info + "OnStart calling");
		super.onStart();

	}

	protected void onRestart() {
		System.out.println(info + "OnRestart Calling");
		super.onRestart();
	}

	protected void onResume() {
		System.out.println(info + "OnResume Calling");
		super.onResume();
	}

	protected void onPause() {
		System.out.println(info + "OnPause Calling");
		super.onPause();

	}

	protected void onStop() {
		System.out.println(info + "OnStop Calling");
		super.onStop();

	}

	protected void onDestroy() {
		System.out.println(info + "OnDestroy Calling");
		super.onDestroy();
	}
}
