package com.gtdtool.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.gtdtool.R;
import com.gtdtool.control.MainControl;
import com.gtdtool.object.GtdEvent;
import com.terlici.dragndroplist.DragNDropListView;
import com.terlici.dragndroplist.DragNDropSimpleAdapter;

public class GtdEventFolderListViewOnlyActivity extends ListActivity {
	private GtdEventsContentArrayAdapter<GtdEvent> adapter=null;
	private DragNDropListView tlv = null;
	float historicX = Float.NaN, historicY = Float.NaN;
	static final int DELTA = 50;
	enum Direction {LEFT, RIGHT;}
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_gtdeventfolder_listview);
		
		loadGtdEventsAdapterToListView();
	}

	/**
	 * 
	 */
	private void loadGtdEventsAdapterToListView() {
		ArrayList<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
		for(GtdEvent ge:MainControl.gtdEventsOp.events){
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("name", ge.getName());
			item.put("status", ge.getEventStatus().toString());
			item.put("_id", ge.getId());
			
			items.add(item);
		}
//		Log.d(this.getClass().getName(), "GtdEvents items: "+items.size());
		
		tlv=(DragNDropListView)getListView();
//		adapter = new GtdEventsContentArrayAdapter<GtdEvent>(getApplication()
//				,R.layout.gtdevent_item
//				, MainControl.gtdEventsOp.getEvents(),R.id.grabber);
		tlv.setDragNDropAdapter(new DragNDropSimpleAdapter(this,
				 items,
				 R.layout.gtdevent_item,
				 new String[]{"name","status"},
				 new int[]{R.id.gtdevent_title_textView,R.id.gtdevent_duration_textView},
				 R.id.grabber));
		tlv.setOnTouchListener(new OnTouchListener() {
		    @Override
		    public boolean onTouch(View v, MotionEvent event) 
		    {
		        // TODO Auto-generated method stub
		        switch (event.getAction()) 
		        {
		            case MotionEvent.ACTION_DOWN:
		            historicX = event.getX();
		            historicY = event.getY();
		            break;

		            case MotionEvent.ACTION_UP:
		            if (event.getX() - historicX < -DELTA) 
		            {
//		                FunctionDeleteRowWhenSlidingLeft();
		                return true;
		            }
		            else if (event.getX() - historicX > DELTA)  
		            {
		            	Log.d(this.getClass().getName(), "Pre x: "+historicX+" after: "+historicX);
		                FunctionDeleteRowWhenSlidingRight(
		                		tlv.pointToPosition((int)event.getX(), (int)event.getY()));
		                return true;
		            } break;
		            default: return false;
		        }
		        return false;
		    }
		});
	}

	protected void FunctionDeleteRowWhenSlidingRight(int postion) {
		Log.d(this.getClass().getName(), "Deleting "+postion);
		MainControl.gtdEventsOp.deleteGtdEvent(postion);
		loadGtdEventsAdapterToListView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.evenaddmenu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Intent intent=new Intent(this,AddEvent.class);
		startActivityForResult(intent,0);
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		loadGtdEventsAdapterToListView();
		super.onActivityResult(requestCode, resultCode, data);
	}
	
//	protected int getPostionForItemByCoordinate(int x, int y) {
//		return tlv.pointToPosition(x, y);
//	}

	
	
}
