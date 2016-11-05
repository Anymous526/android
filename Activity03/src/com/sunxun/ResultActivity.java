package com.sunxun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 1,接受Activity03当中传递的值 2,计算这两个值的积 3,将结果显示在Activity上
 */
public class ResultActivity extends Activity {
	private TextView resultView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		resultView = (TextView)this.findViewById(R.id.result);
		//得到Intent对象当中的值
		Intent intent = getIntent();
		int factorOne = Integer.parseInt(intent.getStringExtra("one"));
		int factorTwo = Integer.parseInt(intent.getStringExtra("two"));
		//计算结果
		int result  = factorOne * factorTwo;
		//显示两个数的乘积
		resultView.setText(result + "");

	}

}
