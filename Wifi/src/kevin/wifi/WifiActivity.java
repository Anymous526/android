package kevin.wifi;

import java.net.ContentHandler;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class WifiActivity extends Activity {
    private Button statWifi;
    private Button stopWifi;
    private Button chekcWifi;
    private WifiManager wifiManager;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        statWifi = (Button)findViewById(R.id.btn_start);
        statWifi.setOnClickListener(new StatWifiListener());
        stopWifi = (Button)findViewById(R.id.btn_stop);
        stopWifi.setOnClickListener(new StatWifiListener());
        chekcWifi  = (Button)findViewById(R.id.btn_check);
        chekcWifi.setOnClickListener(new CheckWifi());
    }
    
    class StatWifiListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			wifiManager = (WifiManager)WifiActivity.this.getSystemService(Context.WIFI_SERVICE);
			wifiManager.setWifiEnabled(true);
			System.out.println("wifi state ---> "+ wifiManager.getWifiState());
			Toast.makeText(WifiActivity.this, "当前Wifi网卡状态为"+wifiManager.getWifiState(), Toast.LENGTH_SHORT);
		}
    	
    }
    
    class StopWiftListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			wifiManager = (WifiManager)WifiActivity.this.getSystemService(Context.WIFI_SERVICE);
			wifiManager.setWifiEnabled(false);
			System.out.println("wifi state ---> "+ wifiManager.getWifiState());
			Toast.makeText(WifiActivity.this, "当前Wifi网卡状态为"+wifiManager.getWifiState(), Toast.LENGTH_SHORT);
			
		}
    	
    }
    
    class CheckWifi implements OnClickListener{

		@Override
		public void onClick(View v) {
			wifiManager = (WifiManager)WifiActivity.this.getSystemService(Context.WIFI_SERVICE);
			System.out.println("wifi state ---> "+ wifiManager.getWifiState());
			Toast.makeText(WifiActivity.this, "当前Wifi网卡状态为"+wifiManager.getWifiState(), Toast.LENGTH_SHORT);
			
		}
    	
    }
}