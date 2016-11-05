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
 * 1,在Activity03当中,要声明四个控件
 * 2,要为其中的两个控制设置显示的值
 * 3,创建一个监听器类.监听按钮按下的动作
 * 4,将监听器类的对象,绑定按钮上面
 * @author kevin
 *
 */
public class activity03 extends Activity {
	private EditText factorOne;
	private EditText factorTwo;
	private TextView symbol;
	private Button calculate;
	
	/**
	 * 当客户点击菜单中的某一个选项时,会调用方法.将将你点击的那个选项传进来
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
        //为symbol 和calculate 设置显示的值
//        symbol.setText("乘以");
//        calculate.setText("计算");
        symbol.setText(R.string.symbol);
        calculate.setText(R.string.calculate);
        //将监听器的对象绑定到按钮对象上面
        calculate.setOnClickListener(new CalculateListener());
       }
    /**
     * 当客户点击menu按钮的时候调用此方法
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
			//取得两个EditText控件的值
			String factorOneStr = factorOne.getText().toString();
			String factorTwoStr = factorTwo.getText().toString();
			//将这两个值存放到Intent对象中
			Intent intent = new Intent();
			intent.putExtra("one", factorOneStr);
			intent.putExtra("two", factorTwoStr);
			intent.setClass(activity03.this, ResultActivity.class);
			//使用Intent对象来启动ResultActivity
			activity03.this.startActivity(intent);
			
		}
    	
    }
}