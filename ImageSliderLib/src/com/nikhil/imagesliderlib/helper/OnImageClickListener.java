/**
 * @author Nikhil V
 *
 * Jul 10, 2015
 */
package com.nikhil.imagesliderlib.helper;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author Nikhil V
 *
 */
public class OnImageClickListener implements OnClickListener {

	private int postion;
	private Activity activity;

	// constructor
	public OnImageClickListener(int position,Activity activity) {
		this.postion = position;
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		// on selecting grid view image
		// launch full screen activity
	/*	Intent i = new Intent(activity, FullScreenViewActivity.class);
		i.putExtra("position", postion);
		activity.startActivity(i);*/
	}

}