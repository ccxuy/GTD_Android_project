package com.gtdtool.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.gtdtool.R;
import com.gtdtool.control.GtdEventOperator;
import com.gtdtool.control.MainControl;
import com.gtdtool.object.GtdEvent;

public class AddEvent extends Activity {
	String[] types=new String[]{"Simple"};
	String[] statu=new String[]{"NORMAL", "URGENT", "FINISHED"};
	Button confirm=null;
	Button cancle=null;
	Spinner type=null;
	Spinner status=null;
	EditText name=null;
	String typeStr= "Simple";
	String statusStr=null;
	private ArrayAdapter<String> typeAd=null;
	private ArrayAdapter<String> statusAd=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_event);
		iniComponent();
		typeAd=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,types);
		statusAd=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,statu);
		typeAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		statusAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		type.setAdapter(typeAd);
		status.setAdapter(statusAd);
		type.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
		});		
		
		status.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				statusStr=statu[arg2];
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				statusStr=statu[0];
			}
			
			
		});
		
		
		confirm.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				GtdEvent ge = new GtdEvent();
				ge.setName(name.getText().toString());
				MainControl.gtdEventsOp.addGtdEvents(ge);
				
				finish();
			}
		});
		
		cancle.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		
	}
	private void iniComponent(){
		confirm=(Button) findViewById(R.id.addsave);
		cancle=(Button) findViewById(R.id.addcancle);
		type=(Spinner) findViewById(R.id.type);
        status=(Spinner) findViewById(R.id.status);
		name=(EditText) findViewById(R.id.name);
		
	}
	/*this.name = "No Name";
	this.eventType = EventType.Simple;
	this.eventStatus = EventStatus.NORMAL;
	this.bookmark = "default_bookmark";
	 */
	
	
	
	
}
