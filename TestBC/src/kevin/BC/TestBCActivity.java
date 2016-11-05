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
        sendbutton.setText("������Ϣ");
        regbutton  = (Button)findViewById(R.id.btn_reg);
        regbutton.setText("��");
        unregButton = (Button)findViewById(R.id.btn_unreg);
        unregButton.setText("�����");
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
				//����һ��BroiadcasastReceiver
				smsReceiver = new SMSReceiver();
				//����һ��IntentFilter����
				IntentFilter filter = new IntentFilter();
				filter.addAction(SMS_ACTION);
				//��BroadcastReceiver����ע�ᵽϵͳ����
				TestBCActivity.this.registerReceiver(smsReceiver, filter);
			}
		});
        
        unregButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//���BroadcastReceiver����ע��
				TestBCActivity.this.unregisterReceiver(smsReceiver);
				
			}
		});
    }
}