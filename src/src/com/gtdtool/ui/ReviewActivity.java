package com.gtdtool.ui;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import com.gtdtool.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

public class ReviewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = execute(ReviewActivity.this);
		startActivity(intent);
		/*setContentView(R.layout.activity_review);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);*/
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.review, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpTo(this, new Intent(this,
					GtdEventFolderListActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
	
	//设置饼状图
		public Intent execute(Context context) {
			double[] values = new double[] { 16, 40 }; // 这是 完成的接口，第一个是 完成的，第二个是未完成的
			int[] colors = new int[] { Color.BLUE, Color.RED };
			DefaultRenderer renderer = buildCategoryRenderer(colors);
			renderer.setZoomButtonsVisible(true);
			renderer.setZoomEnabled(true);
			renderer.setChartTitleTextSize(60);
			renderer.setChartTitle("Tasks");
			return ChartFactory.getPieChartIntent(context,
					buildCategoryDataset("Tasks View", values), renderer,
					"Tasks View");
		}

		//设置饼状图的Renderer
		protected DefaultRenderer buildCategoryRenderer(int[] colors) {
			DefaultRenderer renderer = new DefaultRenderer();
			renderer.setLabelsTextSize(30);
			renderer.setLegendTextSize(20);
			renderer.setMargins(new int[] { 20, 30, 15, 0 });
			for (int color : colors) {
				SimpleSeriesRenderer r = new SimpleSeriesRenderer();
				r.setColor(color);
				renderer.addSeriesRenderer(r);
			}
			return renderer;
		}

		//设置饼状图的Series
		protected CategorySeries buildCategoryDataset(String title, double[] values) {
			CategorySeries series = new CategorySeries(title);

			double[] value = values;
			series.add("finished", value[0]);
			series.add("unfinished", value[1]);
			return series;
		}
}
