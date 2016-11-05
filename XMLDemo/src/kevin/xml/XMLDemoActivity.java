package kevin.xml;

import java.io.StringReader;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

import kevin.utils.HttpDownloader;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class XMLDemoActivity extends Activity {
    Button button = null;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button)findViewById(R.id.btn_button);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				HttpDownloader hd = new HttpDownloader();
				String resultStr = hd.download("http://10.0.2.2/s/work.xml");
				System.out.println(resultStr);
				try {
					//创建一个SAXParserFactory
					SAXParserFactory  factory = SAXParserFactory.newInstance();
					XMLReader reader = factory.newSAXParser().getXMLReader();
					//为XMLReader设置内容处理器
					reader.setContentHandler( new MyContentHandler());
					//开始解析文件
					reader.parse(new InputSource(new StringReader(resultStr)));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
    }
}