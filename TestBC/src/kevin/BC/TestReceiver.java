package kevin.BC;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TestReceiver extends BroadcastReceiver{
	
	public TestReceiver(){
		System.out.println("TestReciver");
	}
	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("OnReceiver");
		
	}

}
