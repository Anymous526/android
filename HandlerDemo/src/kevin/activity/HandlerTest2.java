package kevin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class HandlerTest2 extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		
		HandlerThread handlerThread = new HandlerThread("handler_thread");
		handlerThread.start();
		MyHandler myHandler = new MyHandler(handlerThread.getLooper());
		Message msg = myHandler.obtainMessage();
		msg.obj="abc";
		Bundle b = new Bundle();
		b.putInt("age",20);
		b.putString("name", "kevin");
		msg.setData(b);
		//将msg发送到目标对象,目标对象就是生成msg的对象
		msg.sendToTarget();
		
	}
	
	class MyHandler extends Handler{
		public MyHandler(){
			}
		public MyHandler(Looper looper){
			super(looper);
		}
		@Override
		public void handleMessage(Message msg){
			String s = (String)msg.obj;
			Bundle b  = msg.getData();
			System.out.println(b.getInt("age"));
			System.out.println(b.getString("name"));
			System.out.println(s);
			System.out.println(Thread.currentThread().getId());
			System.out.println("handlerMessage");
		}
	}
}
