package kevin.activity;

import java.util.*;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class listView extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
//        Map<String,String> map1 = new HashMap<String, String>();
//        Map<String,String> map2 = new HashMap<String, String>();
//        Map<String,String> map3 = new HashMap<String, String>();
//        map1.put("ip", "192.168.1.0");
//        map1.put("name", "xiaozhang0");
//        map2.put("ip", "192.168.1.1");
//        map2.put("name", "xiaozhang1");
//        map3.put("ip", "192.168.1.2");
//        map3.put("name", "xiaozhang2");
//        
        Map<String,String> map1 = null;
        for(int i=0;i<9;i++){
        	map1 = new HashMap<String, String>();
        	map1.put("ip", "192.168.1."+i);
        	map1.put("name","xiaozhang"+i);
        	list.add(map1);
        }
        
        SimpleAdapter simple = new SimpleAdapter(this, list, R.layout.user, new String[]{"ip","name"}, new int[]{R.id.fir,R.id.sec});
        setListAdapter(simple);
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		System.out.println("id-----" +id);
		System.out.println("position----"+position);
	}
}