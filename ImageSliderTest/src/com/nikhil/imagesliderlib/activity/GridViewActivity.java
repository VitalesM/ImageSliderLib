package com.nikhil.imagesliderlib.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.GridView;

import com.nikhil.imagesliderlib.adapter.GridViewImageAdapter;
import com.nikhil.imagesliderlib.helper.AppConstant;
import com.nikhil.imagesliderlib.helper.Utils;
import com.nikhil.imagesliderlib.model.GridImageViewListner;

public class GridViewActivity extends Activity {

	private Utils utils;
	private List<String> imagePaths;
	private GridViewImageAdapter adapter;
	private GridView gridView;
	private int columnWidth;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view);

		gridView = (GridView) findViewById(R.id.grid_view);

		utils = new Utils(GridViewActivity.this);
		
		
		AppConstant.gridviewClickListener = new GridImageViewListner(0,this);

		// Initilizing Grid View
		InitilizeGridLayout();

		// loading all image paths from SD card
		
		//int[] drawable = {R.drawable.};
		
		
		AppConstant.setBitmap(GridViewActivity.this);

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

}
