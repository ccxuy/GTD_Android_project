package com.gtdtool.ui;

import com.example.gtdtools.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		 // TODO: Judge whether is first time to launch this application
		 //     , if true launch introduction activity.
		 
		Intent intent;
	    intent = new Intent(this, IntroActivity.class);
	    startActivity( intent );
	    finish();
	    
	    // TODO: Load Main UI component
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
