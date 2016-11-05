package kevin.BC;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;

public class SMSReceiver extends BroadcastReceiver{
	
	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("Receiver message");
		//接受Intent对象中的数据
		Bundle bundle = intent.getExtras();
		//在Bundle对象当中有一个属性名为"pdus",这个属性的值一个Object的数组
		Object[] myOBjpdus = (Object[])bundle.get("pdus");
		//创建一个SmsMessage的数组
		SmsMessage[] message = new SmsMessage[myOBjpdus.length];
		for(int i=0;i<myOBjpdus.length;i++){
			//使用Object的数组当中的对象创建SmsMessage对象
			message[i] = SmsMessage.createFromPdu((byte[]) myOBjpdus[i]);
			//调用SmsMessage对象的getDisplayMessagBody可以得到消息体
			System.out.println(message[i].getDisplayMessageBody());
		}
		
	}

}
