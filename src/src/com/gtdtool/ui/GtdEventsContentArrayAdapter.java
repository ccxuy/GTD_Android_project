/**
 * 
 */
package com.gtdtool.ui;

import java.util.List;

import com.gtdtool.object.GtdEvent;
import com.gtdtool.R;
import com.terlici.dragndroplist.DragNDropAdapter;
import com.terlici.dragndroplist.DragNDropListView;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Andrew
 *
 */
public class GtdEventsContentArrayAdapter<T> extends ArrayAdapter<GtdEvent> implements DragNDropAdapter{

	private Context mContext;
	private int mViewResourceId;
    
	int mPosition[];
	int mHandler;
	
	private List<GtdEvent> itemList;
	
	final private int defaultImgId = R.drawable.bookmark_default;

	/**
	 * @param mContext
	 * @param mViewResourceId
	 * @param itemList
	 * @param handler for drag object resource id
	 */
	public GtdEventsContentArrayAdapter(Context mContext, int mViewResourceId,
			List<GtdEvent> itemList, int handler) {
		super(mContext, mViewResourceId, itemList);
		this.mContext = mContext;
		this.mViewResourceId = mViewResourceId;
		this.itemList = itemList;
		this.mHandler = handler;
		setup(itemList.size());
	}

	private void setup(int size) {
		mPosition = new int[size];
		
		for (int i = 0; i < size; ++i) mPosition[i] = i;
	}

	@Override
	public View getDropDownView(int position, View view, ViewGroup group) {
		return super.getDropDownView(mPosition[position], view, group);
	}
	
	@Override
	public GtdEvent getItem(int position) {
		return super.getItem(mPosition[position]);
	}
	
	@Override
	public int getItemViewType(int position) {
		return super.getItemViewType(mPosition[position]);
	}
	
	@Override
	public long getItemId(int position) {
		return super.getItemId(mPosition[position]);
	}
	
	/* 
	 * {@inheritDoc}
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		
		if (view == null) { 
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.gtdevent_item, parent, false);
        }
		
		GtdEvent geItem = itemList.get(position); 
        if (geItem != null) {
            TextView title = (TextView) view 
                    .findViewById(R.id.gtdevent_title_textView); 
            TextView author = (TextView) view 
                    .findViewById(R.id.gtdevent_author_textView); 
            TextView duration = (TextView) view 
                    .findViewById(R.id.gtdevent_duration_textView); 
            ImageView coverImage = (ImageView) view.findViewById(R.id.gtdevent_cover_imageView);

            
            
            title.setText(geItem.getName());
            author.setText(geItem.getEventType().toString());
//            duration.setText(geItem.getDuration());
            int imgId = mContext.getResources().
            		getIdentifier(geItem.getBookmark(), "string", mContext.getPackageName());
            try {
				coverImage.setImageDrawable(mContext.getResources().getDrawable(imgId));
			} catch (NotFoundException e) {
				coverImage.setImageDrawable(mContext.getResources().getDrawable(defaultImgId));
//				Log.d("GtdEventsContentArrayAdapter", "Image Uri not found. imgId="+imgId);
			}
        } 
		return view;
	}

	@Override
	public boolean isEnabled(int position) {
		return super.isEnabled(mPosition[position]);
	}
	@Override
	public void onItemDrag(DragNDropListView parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onItemDrop(DragNDropListView parent, View view,
			int startPosition, int endPosition, long id) {
		int position = mPosition[startPosition];

		if (startPosition < endPosition)
			for (int i = startPosition; i < endPosition; ++i)
				mPosition[i] = mPosition[i + 1];
		else if (endPosition < startPosition)
			for (int i = startPosition; i > endPosition; --i)
				mPosition[i] = mPosition[i - 1];
		Log.d("GtdEventsContentArrayAdapter", "startPosition = "+startPosition+" endPosition "+endPosition);
		mPosition[endPosition] = position;
	}

	@Override
	public int getDragHandler() {
		return mHandler;
	}


}
