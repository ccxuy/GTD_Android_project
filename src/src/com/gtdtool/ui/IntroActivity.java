package com.gtdtool.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.gtdtool.R;

public class IntroActivity extends Activity implements OnClickListener, OnPageChangeListener{
  /*private ViewFlipper viewFlipper=null;
	private Activity introActivity=null;*/
	
	private GestureDetector gesture=null;
	private ViewPager vp=null;
	private ViewPagerAdapter vpAdapter=null;
	private List<View> views=null;
	private GestureDetector gestureDetector = null;  
	int[] imgs={R.drawable.img1,R.drawable.img2};
	int[] dotsimg={R.drawable.page_indicator_unfocused,R.drawable.page_indicator_focused};
	int currentIndex=0;
	ImageView[] dots;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		/*introActivity=this;
		//Load UI Component
		//ImageButton goMainUiBtn =(ImageButton) findViewById(R.id.intro_goMain_imageButton);
		//goMainUiBtn.setOnClickListener(new OnClickGoMainUiBtnListener());
		viewFlipper=(ViewFlipper) findViewById(R.id.viewflipper);
		//gestureDetector = new GestureDetector(this); 
		gesture = new GestureDetector(this);
		//Initialize the images
		int[] imgs={R.drawable.img1,R.drawable.img2};
		
		//Add image to the flipper
		 for(int id:imgs){
			ImageView imgView=new ImageView(this);
			imgView.setImageResource(id);
			//imgView.setScaleType(ImageView.ScaleType.FIT_XY);
			viewFlipper.addView(imgView, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));  	
			Log.i("Message", "onCreate_intro");
		 }
		*/
		//viewFlipper.setAutoStart(false);
		
		
		 
		views=new ArrayList<View>();
		
		LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		
		for(int id:imgs){
			ImageView imgView=new ImageView(this);
			imgView.setImageResource(id);
			//imgView.setScaleType(ImageView.ScaleType.FIT_XY);
			imgView.setLayoutParams(params);
			views.add(imgView);
			Log.i("Message", "onCreate_intro");
		}
		ImageView img=new ImageView(this);
		img.setVisibility(0);
		views.add(img);
		vp=(ViewPager) findViewById(R.id.viewpager);
		vpAdapter=new ViewPagerAdapter(views);
		vp.setAdapter(vpAdapter);
		vp.setOnPageChangeListener(this);
		initDots();
	}
	
	
	private void initDots(){
		LinearLayout LL=(LinearLayout) findViewById(R.id.dots);
		dots=new ImageView[imgs.length];
		for(int i=0;i<imgs.length;i++){
			dots[i]=(ImageView) LL.getChildAt(i);
			dots[i].setEnabled(true);
			dots[i].setOnClickListener(this);
			dots[i].setTag(i);
		}
		
		dots[0].setEnabled(false);
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


	 




	 





	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gesture.onTouchEvent(event);
	}






	 

	private void setView(int position){
		if(position<0||position>imgs.length)return;
		else{
			vp.setCurrentItem(position);
		}
	}
	
	private void setDots(int position){
		if(position<0||position>imgs.length-1)return;
		for(ImageView iv:dots){
			iv.setEnabled(true);
		}
		dots[position].setEnabled(false);
	}


	 






 





 




	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		if(currentIndex==imgs.length){finish();}
	}






	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		currentIndex=arg0;
		setDots(arg0);
		setView(arg0);
	}






	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		 
	}






	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}





	 
}
