package com.sunxun;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioDemo extends Activity {
	private RadioGroup genderGroup = null;
	private RadioButton femaleButton = null;
	private RadioButton maleButton = null;
	private CheckBox swimBox = null;
	private CheckBox runBox = null;
	private CheckBox readBox = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio);
		genderGroup = (RadioGroup) findViewById(R.id.genderGroup);
		femaleButton = (RadioButton) findViewById(R.id.femaleButton);
		maleButton = (RadioButton) findViewById(R.id.maleButton);
		// ÎªRadioGroupÉèÖÃ¼àÌýÆ÷
		genderGroup
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						if (femaleButton.getId() == checkedId) {
							System.out.println("famale");
							Toast.makeText(RadioDemo.this, "famale",
									Toast.LENGTH_SHORT).show();

						} else if (maleButton.getId() == checkedId) {
							System.out.println("male");
							Toast.makeText(RadioDemo.this, "male",
									Toast.LENGTH_SHORT).show();
						}

					}
				});

		swimBox = (CheckBox) findViewById(R.id.swim);
		runBox = (CheckBox) findViewById(R.id.run);
		readBox = (CheckBox) findViewById(R.id.read);

		swimBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(isChecked){
					System.out.println("swimBox Checked");
				}else{
					System.out.println("swimBox not Checkted");
				}

			}
		});

		runBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(isChecked){
					System.out.println("RunBox Checked");
				}else{
					System.out.println("RunBox not Checkted");
				}

			}
		});

		readBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(isChecked){
					System.out.println("readBox Checked");
				}else{
					System.out.println("readBox not Checkted");
				}

			}
		});
	}
}