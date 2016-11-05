package com.kevin;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelloWrold extends Activity {
	private TextView textView = null;
	private Button button = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helloworld);
        //setContentView(R.layout.main);
        //ªÒ»°TestView,Button
        textView = (TextView)findViewById(R.id.textview);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Random r = new Random();
				textView.setTextColor(Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
				
			}
		});
    }
   
}