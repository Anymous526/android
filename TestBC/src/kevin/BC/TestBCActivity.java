package kevin.BC;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestBCActivity extends Activity {
    Button sendbutton ;
    Button regbutton;
    Button unregButton;
    SMSReceiver smsReceiver;
    private static final String SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        sendbutton = (Button)findViewById(R.id.btn_sen);
        sendbutton.setText("发送信息");
        regbutton  = (Button)findViewById(R.id.btn_reg);
        regbutton.setText("绑定");
        unregButton = (Button)findViewById(R.id.btn_unreg);
        unregButton.setText("解除绑定");
        sendbutton.setOnClickListener(new OnClickListener() {
			@Override
        	public void onClick(View view) {
				
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_EDIT);
				TestBCActivity.this.sendBroadcast(intent);
				
			}
		});
        
        regbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//生成一个BroiadcasastReceiver
				smsReceiver = new SMSReceiver();
				//生成一个IntentFilter对象
				IntentFilter filter = new IntentFilter();
				filter.addAction(SMS_ACTION);
				//将BroadcastReceiver对象注册到系统当中
				TestBCActivity.this.registerReceiver(smsReceiver, filter);
			}
		});
        
        unregButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//解除BroadcastReceiver对象注册
				TestBCActivity.this.unregisterReceiver(smsReceiver);
				
			}
		});
    }
}