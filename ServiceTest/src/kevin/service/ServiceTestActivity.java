package kevin.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;


public class ServiceTestActivity extends Activity {
    Button startButton,stopButton;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startButton = (Button)findViewById(R.id.btn_start);
        stopButton = (Button)findViewById(R.id.btn_stop);
        startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(ServiceTestActivity.this, Services.class);
				startService(intent);
				
			}
		});
        
        stopButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(ServiceTestActivity.this, Services.class);
				stopService(intent);
				
			}
		});
    }
}