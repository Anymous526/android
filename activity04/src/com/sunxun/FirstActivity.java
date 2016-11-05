/**
 * Activity的生命周期
 */
package com.sunxun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class FirstActivity extends Activity {
	private Button button;
	String info = "FirstActivity";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		System.out.println(info + "OnCreate calling");
		button = (Button) this.findViewById(R.id.btn_button);
		button.setText("启动第二个Activity");
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(FirstActivity.this, SecondActivity.class);
				FirstActivity.this.startActivity(intent);

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
	
	/**
	 * 当这个Activity对用户不可见的时候,会被调用
	 */
	protected void onStop() {
		System.out.println(info + "OnStop Calling");
		super.onStop();

	}

	protected void onDestroy() {
		System.out.println(info + "OnDestroy Calling");
		super.onDestroy();
	}
}