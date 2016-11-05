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
			//调用 Handler的post方法,将要执行的线程添加到队列当中
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
	//将要执行的操作写在线程对象的fun方法中
	Runnable updateThread = new Runnable() {
		@Override
		public void run() {
			System.out.println("updateThread");
			//在run方法内部,执行postDelayed或者是post方法
			handler.postDelayed(updateThread, 3000);
		}
	};

}