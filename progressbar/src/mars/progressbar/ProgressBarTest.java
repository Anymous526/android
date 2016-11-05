package mars.progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarTest extends Activity {
	/** Called when the activity is first created. */
	// ��������
	private ProgressBar firstBar = null;
	private ProgressBar secondBar = null;
	private Button myButton = null;
	private int i = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ���ݿؼ���ID��ȡ�ô���ؼ��Ķ���
		firstBar = (ProgressBar) findViewById(R.id.firstBar);
		secondBar = (ProgressBar) findViewById(R.id.secondBar);
		myButton = (Button) findViewById(R.id.myButton);
		myButton.setOnClickListener(new ButtonListener());
	}

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (i == 0) {
				// ���ý��������ڿɼ���״̬
				firstBar.setVisibility(View.VISIBLE);
				firstBar.setMax(150);
				secondBar.setVisibility(View.VISIBLE);
			} else if (i < firstBar.getMax()) {
				// �������������ĵ�ǰֵ
				firstBar.setProgress(i);
				// ���õڶ��������ĵ�ǰֵ
				firstBar.setSecondaryProgress(i + 10);
				// ��ΪĬ�ϵĽ������޷���ʾ���е�״̬
				// secondBar.setProgress(i);

			} else {
				// ���ý��������ڲ��ɼ�״̬
				firstBar.setVisibility(View.GONE);
				secondBar.setVisibility(View.GONE);
			}
			i = i + 10;
		}

	}

}