package com.nikhil.test.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.nikhil.imagesliderlib.adapter.GridViewImageAdapter;
import com.nikhil.imagesliderlib.helper.AppConstant;
import com.nikhil.imagesliderlib.helper.Utils;
import com.nikhil.test.model.GridImageViewListner;

public class GridViewActivity extends Activity {

	private Utils utils;
//	private List<String> imagePaths;
	private GridViewImageAdapter adapter;
	private GridView gridView;
	private int columnWidth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view);

		gridView = (GridView) findViewById(R.id.grid_view);

		utils = new Utils(GridViewActivity.this);

		AppConstant.gridviewClickListener = new GridImageViewListner(0, this);

		// Initilizing Grid View
		InitilizeGridLayout();

		// loading all image paths from SD card

		int[] drawable = { R.drawable.ic_01, R.drawable.ic_02,
				R.drawable.ic_03, R.drawable.ic_04, R.drawable.ic_05,
				R.drawable.ic_06, R.drawable.ic_07, R.drawable.ic_08,
				R.drawable.ic_09, R.drawable.ic_10, R.drawable.ic_11,
				R.drawable.ic_12, R.drawable.ic_13, R.drawable.ic_14,
				R.drawable.ic_15, };
		AppConstant.drawablelist = drawable;

		AppConstant.setBitmapDrawable(GridViewActivity.this, columnWidth);

		// Gridview adapter
		adapter = new GridViewImageAdapter(GridViewActivity.this,
				AppConstant.imageBitmapList, columnWidth);

		// setting grid view adapter
		gridView.setAdapter(adapter);
	}

	private void InitilizeGridLayout() {
		Resources r = getResources();
		float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				AppConstant.GRID_PADDING, r.getDisplayMetrics());

		columnWidth = (int) ((utils.getScreenWidth() - ((AppConstant.NUM_OF_COLUMNS + 1) * padding)) / AppConstant.NUM_OF_COLUMNS);

		gridView.setNumColumns(AppConstant.NUM_OF_COLUMNS);
		gridView.setColumnWidth(columnWidth);
		gridView.setStretchMode(GridView.NO_STRETCH);
		gridView.setPadding((int) padding, (int) padding, (int) padding,
				(int) padding);
		gridView.setHorizontalSpacing((int) padding);
		gridView.setVerticalSpacing((int) padding);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title

		return super.onOptionsItemSelected(item);

	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items

		// menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

}
