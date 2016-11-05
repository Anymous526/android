package com.sunxun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/**
 * 1,��Activity03����,Ҫ�����ĸ��ؼ�
 * 2,ҪΪ���е���������������ʾ��ֵ
 * 3,����һ����������.������ť���µĶ���
 * 4,����������Ķ���,�󶨰�ť����
 * @author kevin
 *
 */
public class activity03 extends Activity {
	private EditText factorOne;
	private EditText factorTwo;
	private TextView symbol;
	private Button calculate;
	
	/**
	 * ���ͻ�����˵��е�ĳһ��ѡ��ʱ,����÷���.�����������Ǹ�ѡ�����
	 */
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == 1){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initControl();
        //Ϊsymbol ��calculate ������ʾ��ֵ
//        symbol.setText("����");
//        calculate.setText("����");
        symbol.setText(R.string.symbol);
        calculate.setText(R.string.calculate);
        //���������Ķ���󶨵���ť��������
        calculate.setOnClickListener(new CalculateListener());
       }
    /**
     * ���ͻ����menu��ť��ʱ����ô˷���
     */
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0,1,1,R.string.exit);
		menu.add(0,2,2,R.string.about);
    	return super.onCreateOptionsMenu(menu);
	}
	/**
     * 
     */
    private void initControl(){
    	factorOne = (EditText) this.findViewById(R.id.factorOne);
    	factorTwo = (EditText)this.findViewById(R.id.factorTwo);
    	symbol = (TextView)this.findViewById(R.id.symbol);
    	calculate = (Button)this.findViewById(R.id.calculate);
  
    }
    
    class CalculateListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			//ȡ������EditText�ؼ���ֵ
			String factorOneStr = factorOne.getText().toString();
			String factorTwoStr = factorTwo.getText().toString();
			//��������ֵ��ŵ�Intent������
			Intent intent = new Intent();
			intent.putExtra("one", factorOneStr);
			intent.putExtra("two", factorTwoStr);
			intent.setClass(activity03.this, ResultActivity.class);
			//ʹ��Intent����������ResultActivity
			activity03.this.startActivity(intent);
			
		}
    	
    }
}