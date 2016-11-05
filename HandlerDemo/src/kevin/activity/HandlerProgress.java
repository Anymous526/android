package kevin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class HandlerProgress extends Activity{
	Button button;
	ProgressBar bar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handler);
		button  = (Button)findViewById(R.id.startButton);
		button.setOnClickListener(new ButtonOnClickListener());
		bar = (ProgressBar)findViewById(R.id.bar);
	}
	class ButtonOnClickListener implements OnClickListener{
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			bar.setVisibility(View.VISIBLE);
			handler.post(updateBar);
			}
	}
	
	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			if(msg.arg1 == 100){
				bar.setVisibility(View.GONE);
			}else{
				bar.setProgress(msg.arg1);
			}
			handler.post(updateBar);
		}
		
	};
	Runnable updateBar = new Runnable(){
		int i = 0;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Segin Thread");
			i = i+1;
			//�õ�һ����Ϣ����.Message������Android�ṩ
			Message msg = handler.obtainMessage();
			//��msg�����arg1��������Ϊi,��arg1��arg2������Ա����������Ϣ
			//�ŵ���ϵͳ�������Ľ���
			msg.arg1 = i;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//��msgѹ����Ϣ����
			handler.sendMessage(msg);
			if(i == 100){
				handler.removeCallbacks(updateBar);
			}
		}
		
	};
}
