package com.sunxun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 1,����Activity03���д��ݵ�ֵ 2,����������ֵ�Ļ� 3,�������ʾ��Activity��
 */
public class ResultActivity extends Activity {
	private TextView resultView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		resultView = (TextView)this.findViewById(R.id.result);
		//�õ�Intent�����е�ֵ
		Intent intent = getIntent();
		int factorOne = Integer.parseInt(intent.getStringExtra("one"));
		int factorTwo = Integer.parseInt(intent.getStringExtra("two"));
		//������
		int result  = factorOne * factorTwo;
		//��ʾ�������ĳ˻�
		resultView.setText(result + "");

	}

}
