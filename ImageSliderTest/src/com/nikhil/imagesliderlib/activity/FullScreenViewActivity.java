package com.nikhil.imagesliderlib.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.nikhil.imagesliderlib.adapter.FullScreenImageAdapter;
import com.nikhil.imagesliderlib.helper.AppConstant;

public class FullScreenViewActivity extends Activity {

	private FullScreenImageAdapter adapter;
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen_view);

		viewPager = (ViewPager) findViewById(R.id.pager);

		Intent i = getIntent();
		int position = i.getIntExtra("position", 0);
		
		AppConstant.setOddBitmap(FullScreenViewActivity.this);

		adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
				AppConstant.imageBitmapList);

		viewPager.setAdapter(adapter);

		// displaying selected image first
		viewPager.setCurrentItem(position);
	}
}
