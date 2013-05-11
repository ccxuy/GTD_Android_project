/**
 * 
 */
package com.gtdtool.ui;

import java.util.List;

import com.gtdtool.object.GtdEvent;
import com.gtdtools.R;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Andrew
 *
 */
public class GtdEventsContentArrayAdapter<T> extends ArrayAdapter<GtdEvent> {

	private Context mContext;
	private int mViewResourceId;
    
	private List<GtdEvent> itemList;
	
	final private int defaultImgId = R.drawable.bookmark_default;

	/**
	 * @param mContext
	 * @param mViewResourceId
	 * @param itemList
	 */
	public GtdEventsContentArrayAdapter(Context mContext, int mViewResourceId,
			List<GtdEvent> itemList) {
		super(mContext, mViewResourceId, itemList);
		this.mContext = mContext;
		this.mViewResourceId = mViewResourceId;
		this.itemList = itemList;
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
                    .findViewById(R.id.songItem_title_textView); 
            TextView author = (TextView) view 
                    .findViewById(R.id.songItem_author_textView); 
            TextView duration = (TextView) view 
                    .findViewById(R.id.songItem_duration_textView); 
            ImageView coverImage = (ImageView) view.findViewById(R.id.songItem_cover_imageView);

            
            
            title.setText(geItem.getName());
            author.setText(geItem.getEventType().toString());
//            duration.setText(geItem.getDuration());
            int imgId = mContext.getResources().
            		getIdentifier(geItem.getBookmark(), "string", mContext.getPackageName());
            try {
				coverImage.setImageDrawable(mContext.getResources().getDrawable(imgId));
			} catch (NotFoundException e) {
				coverImage.setImageDrawable(mContext.getResources().getDrawable(defaultImgId));
				Log.d("GtdEventsContentArrayAdapter", "Image Uri not found. imgId="+imgId);
			}
        } 
		return view;
	}


}
