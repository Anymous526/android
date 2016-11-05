package test.contact;

import test.contact.db.DBHelper;
import test.contact.entity.User;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher.ViewFactory;

public class AddNew extends Activity {
	ImageButton btn_img;
	AlertDialog imageChooseDialog;
	private int[] images = { R.drawable.icon, R.drawable.image1,
			R.drawable.image2, R.drawable.image3, R.drawable.image4,
			R.drawable.image5, R.drawable.image6, R.drawable.image7,
			R.drawable.image8, R.drawable.image9, R.drawable.image10,
			R.drawable.image11, R.drawable.image12, R.drawable.image13,
			R.drawable.image14, R.drawable.image15, R.drawable.image16,
			R.drawable.image17, R.drawable.image18, R.drawable.image19,
			R.drawable.image20, R.drawable.image21, R.drawable.image22,
			R.drawable.image21, R.drawable.image24, R.drawable.image25,
			R.drawable.image26, R.drawable.image27, R.drawable.image28,
			R.drawable.image29, R.drawable.image30, R.drawable.image31,
			R.drawable.image32, };

	Gallery gallery;
	ImageSwitcher is;
	int imagePostion;
	// 接收值

	EditText et_name;
	EditText et_mobilePhone;
	EditText et_familyPhone;
	EditText et_officePhone;
	EditText et_postion;
	EditText et_company;
	EditText et_address;
	EditText et_zipCode;
	EditText et_email;
	EditText et_othetContact;
	EditText et_remark;
	// 下面两个Button
	Button btn_save;
	Button btn_rerutn;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addnew);
		// 初始化EditText Button
		this.initWidget();

		// 响应下面Button事件
		btn_save.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = et_name.getText().toString();

				if (name.equals("")) {
					Toast.makeText(AddNew.this, "姓名不能为空", Toast.LENGTH_LONG)
							.show();
					return;
				}

				String modilePhone = et_mobilePhone.getText().toString();
				String officePhone = et_officePhone.getText().toString();
				String familyPhone = et_familyPhone.getText().toString();
				String postion = et_postion.getText().toString();
				String company = et_company.getText().toString();
				String address = et_address.getText().toString();
				String zipcode = et_zipCode.getText().toString();
				String email = et_email.getText().toString();
				String otherContact = et_othetContact.getText().toString();
				String remark = et_remark.getText().toString();
				int imageId = images[imagePostion];
				
				User user = new User();
				user.address = address;
				user.company = company;
				user.email = email;
				user.familyPhoe = familyPhone;
				user.imageId = imageId;
				user.mobilePhone = modilePhone;
				user.name = name;
				user.officePhoe = officePhone;
				user.otherContact = otherContact;
				user.postion = postion;
				user.remark = remark;
				user.zipCode =zipcode;
				
				//save user to database(SLimt)
				DBHelper.getInstance(AddNew.this).save(user);
			}
		});
		btn_img = (ImageButton) findViewById(R.id.btn_img);
		btn_img.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				initImageChooseDialog();
				imageChooseDialog.show();
			}

		});

	}

	// 初始化文本框
	public void initWidget() {
		et_name = (EditText) this.findViewById(R.id.et_name);
		et_mobilePhone = (EditText) this.findViewById(R.id.et_mobilephone);
		et_familyPhone = (EditText) this.findViewById(R.id.et_familyphone);
		et_officePhone = (EditText) this.findViewById(R.id.et_officephone);
		et_postion = (EditText) this.findViewById(R.id.et_position);
		et_company = (EditText) this.findViewById(R.id.et_company);
		et_address = (EditText) this.findViewById(R.id.et_address);
		et_zipCode = (EditText) this.findViewById(R.id.et_zipcode);
		et_email = (EditText) this.findViewById(R.id.et_email);
		et_othetContact = (EditText) this.findViewById(R.id.et_other);
		et_remark = (EditText) this.findViewById(R.id.et_remark);

		btn_save = (Button) this.findViewById(R.id.btn_save);
		btn_rerutn = (Button) this.findViewById(R.id.btn_return);
	}

	private void initImageChooseDialog() {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("请选择头像");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				btn_img.setImageResource(images[imagePostion]);

			}
		});

		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		});
		LayoutInflater inflater = LayoutInflater.from(this);
		View view = inflater.inflate(R.layout.imageswitch, null);
		gallery = (Gallery) view.findViewById(R.id.img_gallery);
		gallery.setAdapter(new ImageAdapter(this));
		gallery.setSelection(images.length / 2);
		is = (ImageSwitcher) view.findViewById(R.id.img_swithcer);
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int postion, long id) {
				imagePostion = postion;
				is.setImageResource(images[postion]);

			}

		});

		is.setFactory(new MyViewFactory(this));

		builder.setView(view);
		imageChooseDialog = builder.create();
	}

	class ImageAdapter extends BaseAdapter {
		private Context context;

		public ImageAdapter(Context context) {
			this.context = context;
		}

		public int getCount() {
			// TODO Auto-generated method stub
			return images.length;
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView iv = new ImageView(context);
			iv.setImageResource(images[position]);
			iv.setAdjustViewBounds(true);
			iv.setLayoutParams(new Gallery.LayoutParams(80, 80));
			iv.setPadding(15, 10, 15, 10);
			return iv;
		}

	}

	class MyViewFactory implements ViewFactory {
		private Context context;

		public MyViewFactory(Context context) {
			this.context = context;
		}

		@Override
		public View makeView() {
			ImageView iv = new ImageView(context);
			iv.setLayoutParams(new ImageSwitcher.LayoutParams(100, 100));
			return iv;
		}

	}

}