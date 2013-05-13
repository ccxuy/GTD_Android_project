package com.gtdtool.ui;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.commonsware.cwac.tlv.TouchListView;
import com.gtdtool.R;
import com.gtdtool.control.MainControl;
import com.gtdtool.object.GtdEvent;

public class GtdEventFolderListViewOnlyActivity extends ListActivity {
	private static String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
																	"consectetuer", "adipiscing", "elit", "morbi", "vel",
																	"ligula", "vitae", "arcu", "aliquet", "mollis",
																	"etiam", "vel", "erat", "placerat", "ante",
																	"porttitor", "sodales", "pellentesque", "augue", "purus"};
	private GtdEventsContentArrayAdapter<GtdEvent> adapter=null;
	private ArrayList<String> array=new ArrayList<String>(Arrays.asList(items));

	
	private TouchListView.DropListener onDrop=new TouchListView.DropListener() {
		@Override
		public void drop(int from, int to) {
				GtdEvent item=adapter.getItem(from);
				
				adapter.remove(item);
				adapter.insert(item, to);
		}
	};
	
	private TouchListView.RemoveListener onRemove=new TouchListView.RemoveListener() {
		@Override
		public void remove(int which) {
				adapter.remove(adapter.getItem(which));
		}
	};
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_gtdeventfolder_listview);

		TouchListView tlv=(TouchListView)getListView();
		adapter = new GtdEventsContentArrayAdapter<GtdEvent>(getApplication()
				,R.layout.gtdevent_item
				, MainControl.gtdEventsOp.getEvents());
		setListAdapter(adapter);
		
		tlv.setDropListener(onDrop);
		tlv.setRemoveListener(onRemove);
	}

}
