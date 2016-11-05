package kevin.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Services extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("onBind OutPrint");
		return null;
	}

	/**
	 * 当创建一个Services对象之后,会首先调用这个函数
	 */
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("OnCreate OutPrint");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("onDestroy OutPrint");
	}

	/**
	 * 
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("OnStartCommand OutPrint");
		return super.onStartCommand(intent, flags, startId);
	}

}
