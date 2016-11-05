package kevin.mp3;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import kevin.download.HttpDownloader;
import kevin.entity.Mp3Info;
import kevin.xml.Mp3ListContentHandler;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Mp3ListActivity extends ListActivity {
    private static final int UPDATE = 1;
    private static final int ABOUT =  2;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

	/**
	 * 在用户点击Menu键后.会调用该方法.在这个方法当中加入自己的
	 * 按钮控件
	 */
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, UPDATE, 1, R.string.mp3list_update);
		menu.add(0, ABOUT, 2, R.string.mp3list_about);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == UPDATE){
			//用户点击了更新列表按钮
			String xml = downloadXML("http://10.0.2.2:8080/mp3/resouces.xml");
			pase(xml);
		}else if(item.getItemId() == ABOUT){
			//用户点击了关于按钮
		}
		return super.onOptionsItemSelected(item);
	}
    
  
	private String downloadXML(String url){
		HttpDownloader httpDowloader = new HttpDownloader();
		String result = httpDowloader.download(url);
		return result;
	}
	
	private List<Mp3Info> pase(String xmlStr){
		SAXParserFactory saxParerFactory = SAXParserFactory.newInstance();
		try {
			XMLReader xmlReader = saxParerFactory.newSAXParser().getXMLReader();
			List<Mp3Info> infos = new ArrayList<Mp3Info>();
			Mp3ListContentHandler mp3ListContentHandler = new Mp3ListContentHandler(infos);
			xmlReader.setContentHandler(mp3ListContentHandler);
			xmlReader.parse(new InputSource(new StringReader(xmlStr)));
			for(Iterator iterator = infos.iterator();iterator.hasNext();){
				Mp3Info mp3Info = (Mp3Info)iterator.next();
				System.out.println(mp3Info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}