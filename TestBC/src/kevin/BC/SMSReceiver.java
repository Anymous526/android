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
		//����Intent�����е�����
		Bundle bundle = intent.getExtras();
		//��Bundle��������һ��������Ϊ"pdus",������Ե�ֵһ��Object������
		Object[] myOBjpdus = (Object[])bundle.get("pdus");
		//����һ��SmsMessage������
		SmsMessage[] message = new SmsMessage[myOBjpdus.length];
		for(int i=0;i<myOBjpdus.length;i++){
			//ʹ��Object�����鵱�еĶ��󴴽�SmsMessage����
			message[i] = SmsMessage.createFromPdu((byte[]) myOBjpdus[i]);
			//����SmsMessage�����getDisplayMessagBody���Եõ���Ϣ��
			System.out.println(message[i].getDisplayMessageBody());
		}
		
	}

}
