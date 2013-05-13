package com.gtdtool.ui;

import com.gtdtool.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class IntroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		
		//Load UI Component
		ImageButton goMainUiBtn = 
				(ImageButton) findViewById(R.id.intro_goMain_imageButton);
		goMainUiBtn.setOnClickListener(new OnClickGoMainUiBtnListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.intro, menu);
		return true;
	}


	public class OnClickGoMainUiBtnListener implements OnClickListener {
	
		@Override
		public void onClick(View v) {
			finish();
		}
	
	}
}
