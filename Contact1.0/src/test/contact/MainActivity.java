package test.contact;

import java.util.ArrayList;
import java.util.HashMap;

import test.contact.db.DBHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	GridView gv_buttom_menu;
	ListView lv_userList;
	SimpleAdapter adapter;
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==0){
			if(resultCode ==1){
				//�����û��ɹ� ����ˢ��
				ArrayList userdata = DBHelper.getInstance(this).getUserList();
				adapter = new SimpleAdapter(this, userdata,
						R.layout.list_item, new String[] { "imageid", "name",
								"mobilephone" }, new int[] { R.id.user_image,
								R.id.tv_showname, R.id.tv_showmobilephone });
				lv_userList.setAdapter(adapter);
			}else if(resultCode ==2){
				//�����û�ʧ�� ��ˢ�� 
			}
				
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);
		loadUserList();
	}

	private void loadUserList() {
		lv_userList = (ListView) this.findViewById(R.id.lv_userlist);
		ArrayList data = DBHelper.getInstance(this).getUserList();
		adapter = new SimpleAdapter(this, data,
				R.layout.list_item, new String[] { "imageid", "name",
						"mobilephone" }, new int[] { R.id.user_image,
						R.id.tv_showname, R.id.tv_showmobilephone });
		lv_userList.setAdapter(adapter);
		lv_userList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				HashMap map = (HashMap)parent.getItemAtPosition(position);
				Intent intent = new Intent(MainActivity.this, DetailActivity.class);
				intent.putExtra("usermap", map);
				//��requestCodeΪ3��ʱ���������ת��DetailActivityҳ��
				MainActivity.this.startActivityForResult(intent, 3);
			}
			
		});

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			if (gv_buttom_menu == null) {
				loadButtomMenu();
			}
			if (gv_buttom_menu.getVisibility() == View.GONE) {
				gv_buttom_menu.setVisibility(View.VISIBLE);
			} else {
				gv_buttom_menu.setVisibility(View.GONE);
			}

		}

		return super.onKeyDown(keyCode, event);
	}

	private void loadButtomMenu() {
		gv_buttom_menu = (GridView) this.findViewById(R.id.gv_buttom_menu);
		gv_buttom_menu.setBackgroundResource(R.drawable.bottom_bar);
		gv_buttom_menu.setNumColumns(5);
		gv_buttom_menu.setGravity(Gravity.CENTER);
		gv_buttom_menu.setVerticalSpacing(10);
		gv_buttom_menu.setHorizontalSpacing(10);
		ArrayList data = new ArrayList();
		HashMap map = new HashMap();
		map.put("itemImage", R.drawable.ic_menu_add);
		map.put("itemText", "����");
		data.add(map);

		map = new HashMap();
		map.put("itemImage", R.drawable.ic_menu_search);
		map.put("itemText", "����");
		data.add(map);

		map = new HashMap();
		map.put("itemImage", R.drawable.ic_menu_delete);
		map.put("itemText", "ɾ��");
		data.add(map);

		map = new HashMap();
		map.put("itemImage", R.drawable.ic_menu_agenda);
		map.put("itemText", "�˵�");
		data.add(map);

		map = new HashMap();
		map.put("itemImage", R.drawable.ic_menu_close_clear_cancel);
		map.put("itemText", "�˳�");
		data.add(map);

		SimpleAdapter adapter = new SimpleAdapter(this, data,
				R.layout.item_menu, new String[] { "itemImage", "itemText" },
				new int[] { R.id.item_image, R.id.item_text });
		gv_buttom_menu.setAdapter(adapter);
		gv_buttom_menu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				//HashMap map = (HashMap)parent.getItemAtPosition(1);
				switch(position){
					case 0:{
						Intent intent = new Intent(MainActivity.this,AddNew.class);
					    //0�������������ת����ӽ���
						startActivityForResult(intent, 0);
						break;
					}
					case 1:{
						
						break;
					}
					case 2:{
						break;
					}
					case 3:{
						break;
					}
					case 4:{
						break;
					}
					case 5:{
						break;
					}
				}
				
			}
			
		});
	}
}
