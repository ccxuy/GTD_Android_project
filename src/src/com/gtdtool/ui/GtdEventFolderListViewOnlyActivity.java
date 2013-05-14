package com.gtdtool.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
		
		ArrayList<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
		for(GtdEvent ge:MainControl.gtdEventsOp.events){
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("name", ge.getName());
			item.put("status", ge.getEventStatus().toString());
			item.put("_id", ge.getId());
			
			items.add(item);
		}

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
		MainControl.gtdEventsOp.deleteGtdEvent(postion);
	}
	
//	protected int getPostionForItemByCoordinate(int x, int y) {
//		return tlv.pointToPosition(x, y);
//	}

}
