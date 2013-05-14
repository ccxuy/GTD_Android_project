package com.gtdtool.ui;

import com.example.gtdtools.R;
import com.example.gtdtools.R.layout;
import com.example.gtdtools.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.view.View;

public class IntroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		
		Gallery gallery = (Gallery) findViewById(R.id.gallery);
	    gallery.setAdapter(new ImageAdapter(this));

    	ImageButton goMainUiBtn = 
				(ImageButton) findViewById(R.id.intro_goMain_imageButton);
		goMainUiBtn.setOnClickListener(new OnClickGoMainUiBtnListener());
    	goMainUiBtn.setVisibility(View.GONE);
    	
	    gallery.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView parent, View v, int position, long id) {
	            Toast.makeText(IntroActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	            
	            if(position == 4){
		            ImageButton goMainUiBtn = 
							(ImageButton) findViewById(R.id.intro_goMain_imageButton);
					goMainUiBtn.setOnClickListener(new OnClickGoMainUiBtnListener());
	            	goMainUiBtn.setVisibility(View.VISIBLE);
	            }
	            else{
	            	
	            }
	        }
	    });
	    
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
	
	public class ImageAdapter extends BaseAdapter {
	    int mGalleryItemBackground;
	    private Context mContext;

	    private Integer[] mImageIds = {
	            R.drawable.img_0090,
	            R.drawable.img_0091,
	            R.drawable.img_0092,
	            R.drawable.img_0093,
	            R.drawable.img_0094,
	    };

	    public ImageAdapter(Context c) {
	        mContext = c;
	        TypedArray attr = mContext.obtainStyledAttributes(R.styleable.HelloGallery);
	        mGalleryItemBackground = attr.getResourceId(
	                R.styleable.HelloGallery_android_galleryItemBackground, 0);
	        attr.recycle();
	    }

	    public int getCount() {
	        return mImageIds.length;
	    }

	    public Object getItem(int position) {
	        return position;
	    }

	    public long getItemId(int position) {
	        return position;
	    }

	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView imageView = new ImageView(mContext);

	        imageView.setImageResource(mImageIds[position]);
//	        imageView.setLayoutParams(new Gallery.LayoutParams(150, 100));
	        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	        imageView.setBackgroundResource(mGalleryItemBackground);

	        return imageView;
	    }
	}
	
}
