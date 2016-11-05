package test.contact;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class DetailActivity extends Activity {
	ImageButton btn_img;
	EditText et_name;
	EditText et_mobilePhone;
	EditText et_familyPhone;
	EditText et_officePhone;
	EditText et_position;
	EditText et_company;
	EditText et_address;
	EditText et_zipCode;
	EditText et_email;
	EditText et_othetContact;
	EditText et_remark;
	Button btn_modify;
	Button btn_delete;
	Button btn_return;
	private boolean flag = false; 

	private int[] images = { R.drawable.image1, R.drawable.image2,
			R.drawable.image3, R.drawable.image4, R.drawable.image5,
			R.drawable.image6, R.drawable.image7, R.drawable.image8,
			R.drawable.image9, R.drawable.image10, R.drawable.image11,
			R.drawable.image12, R.drawable.image13, R.drawable.image14,
			R.drawable.image15, R.drawable.image16, R.drawable.image17,
			R.drawable.image18, R.drawable.image19, R.drawable.image20,
			R.drawable.image21, R.drawable.image22, R.drawable.image21,
			R.drawable.image24, R.drawable.image25, R.drawable.image26,
			R.drawable.image27, R.drawable.image28, R.drawable.image29,
			R.drawable.image30, R.drawable.image31, R.drawable.image32 };

	private HashMap map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		initWidget();
		Intent intent = getIntent();
		map = (HashMap) intent.getSerializableExtra("usermap");
		displayDate();
		setEtidTextDisable();
		
		btn_modify.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setEditTextAble();
				if(flag){
					flag = false;
					btn_modify.setText("修改");
					setEtidTextDisable();
				}else{
					flag = true;
					btn_modify.setText("保存");
					setEditTextAble();
				}
				
				
			}
		});
	}

	/**
	 * 显示数据
	 * @param map
	 */
	private void displayDate() {
		et_name.setText(String.valueOf(map.get("name")));
		et_mobilePhone.setText(String.valueOf(map.get("mobilephone")));
		et_familyPhone.setText(String.valueOf(map.get("familyphone")));
		et_officePhone.setText(String.valueOf(map.get("officephone")));
		et_position.setText(String.valueOf(map.get("position")));
		et_company.setText(String.valueOf(map.get("company")));
		et_address.setText(String.valueOf(map.get("address")));
		et_zipCode.setText(String.valueOf(map.get("zipcode")));
		et_email.setText(String.valueOf(map.get("email")));
		et_othetContact.setText(String.valueOf(map.get("othercontact")));
		et_remark.setText(String.valueOf(map.get("remark")));
		btn_img.setImageResource(Integer.valueOf(Integer.parseInt(String.valueOf(map.get("imageid"))) ));
	}

	/**
	 * function:初始化控件
	 */
	public void initWidget() {
		et_name = (EditText) this.findViewById(R.id.et_name);
		et_mobilePhone = (EditText) this.findViewById(R.id.et_mobilephone);
		et_familyPhone = (EditText) this.findViewById(R.id.et_familyphone);
		et_officePhone = (EditText) this.findViewById(R.id.et_officephone);
		et_position = (EditText) this.findViewById(R.id.et_position);
		et_company = (EditText) this.findViewById(R.id.et_company);
		et_address = (EditText) this.findViewById(R.id.et_address);
		et_zipCode = (EditText) this.findViewById(R.id.et_zipcode);
		et_email = (EditText) this.findViewById(R.id.et_email);
		et_othetContact = (EditText) this.findViewById(R.id.et_other);
		et_remark = (EditText) this.findViewById(R.id.et_remark);
		btn_img = (ImageButton) this.findViewById(R.id.btn_img);
		btn_delete = (Button)this.findViewById(R.id.btn_delete);
		btn_modify = (Button)this.findViewById(R.id.btn_modify);
		btn_return = (Button)this.findViewById(R.id.btn_return);
	}
	/**
	 * 将控件设计为不可编辑
	 */
	private void setEtidTextDisable(){
		et_name.setEnabled(false);
		et_mobilePhone.setEnabled(false);
		et_familyPhone.setEnabled(false);
		et_officePhone.setEnabled(false);
		et_position.setEnabled(false);
		et_company.setEnabled(false);
		et_address.setEnabled(false);
		et_zipCode.setEnabled(false);
		et_email.setEnabled(false);
		et_zipCode.setEnabled(false);
		et_othetContact.setEnabled(false);
		et_remark.setEnabled(false);
		btn_img.setEnabled(false);
		
		
	}
	
	private void setEditTextAble(){
		et_name.setEnabled(true);
		et_mobilePhone.setEnabled(true);
		et_familyPhone.setEnabled(true);
		et_officePhone.setEnabled(true);
		et_position.setEnabled(true);
		et_company.setEnabled(true);
		et_address.setEnabled(true);
		et_zipCode.setEnabled(true);
		et_email.setEnabled(true);
		et_zipCode.setEnabled(true);
		et_othetContact.setEnabled(true);
		et_remark.setEnabled(true);
		btn_img.setEnabled(true);
		
	}
	
}
