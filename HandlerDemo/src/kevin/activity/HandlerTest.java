package kevin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class HandlerTest extends Activity{
	private Handler handler = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//handler.post(r);
		Thread t = new Thread(r);
		t.start();
		System.out.println("Activity --->" + Thread.currentThread().getId());
		
		System.out.println("ActivityName--->" +Thread.currentThread().getName());
		
	}
	
	Runnable r = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Handle --->"+Thread.currentThread().getId());
			System.out.println("HandleName --->"+Thread.currentThread().getName());
			try {
				Thread.sleep(6000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		}
		
	};

}
