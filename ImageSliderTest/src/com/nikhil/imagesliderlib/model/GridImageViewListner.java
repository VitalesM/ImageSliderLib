/**
 * @author Nikhil V
 *
 * Jul 10, 2015
 */
package com.nikhil.imagesliderlib.model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.nikhil.imagesliderlib.activity.FullScreenViewActivity;
import com.nikhil.imagesliderlib.helper.OnImageClickListener;

/**
 * @author Nikhil V
 *
 */
public class GridImageViewListner extends OnImageClickListener {

	/**
	 * @param position
	 * @param activity
	 */
	public GridImageViewListner(int position, Activity activity) {
		super(position, activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//super.onClick(v);
		
		Intent i = new Intent(activity, FullScreenViewActivity.class);
		i.putExtra("position", position);
		activity.startActivity(i);
		
	}
	
	

}
