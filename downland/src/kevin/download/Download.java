package kevin.download;

import kevin.utils.HttpDownloader;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Download extends Activity {
    Button textButton;
    Button mp3Button;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textButton = (Button)findViewById(R.id.btn_text);
        mp3Button = (Button)findViewById(R.id.btn_mp3);
        
        textButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HttpDownloader httpDownload = new HttpDownloader();
				String lrc = httpDownload.download("http://10.0.2.2/s/s.lrc");
				System.out.println(lrc);
			}
		});
        
        mp3Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				HttpDownloader httpDownload = new HttpDownloader();
				int  result = httpDownload.downFile("http://10.0.2.2/s/s.mp3","mp3/","a.mp3");
				System.out.println(result);
				
			}
		});
    }
}