package kevin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HandlerDemo extends Activity {
	private Button startButton;
	private Button endButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		startButton = (Button) findViewById(R.id.startButton);
		endButton = (Button) findViewById(R.id.endButton);
		startButton.setOnClickListener(new StartButtonListener());
		endButton.setOnClickListener(new EndButtonListener());
	}

	class StartButtonListener implements OnClickListener {
		@Override
		public void onClick(View view) {
			//���� Handler��post����,��Ҫִ�е��߳���ӵ����е���
			handler.post(updateThread);
		}
	}

	class EndButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
				handler.removeCallbacks(updateThread);
		}
	}
	
	Handler handler = new Handler();
	//��Ҫִ�еĲ���д���̶߳����fun������
	Runnable updateThread = new Runnable() {
		@Override
		public void run() {
			System.out.println("updateThread");
			//��run�����ڲ�,ִ��postDelayed������post����
			handler.postDelayed(updateThread, 3000);
		}
	};

}