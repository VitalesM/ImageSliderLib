package com.nikhil.imagesliderlib.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AppConstant {

	// Number of columns of Grid View
	public static final int NUM_OF_COLUMNS = 3;

	// Gridview image padding
	public static final int GRID_PADDING = 8; // in dp

	// SD card image directory
	public static final String PHOTO_ALBUM = "/mnt/shared/GennyMotionShared/jamesRodriguez/";

	// supported file formats
	public static final List<String> FILE_EXTN = Arrays.asList("jpg", "jpeg",
			"png");
	
	public static OnImageClickListener gridviewClickListener = null;
	
	
	public static List<Bitmap> imageBitmapList;
	
	public static int [] drawablelist ;
	
	
	public static void setBitmapDrawable(Activity activity)
	{
		imageBitmapList = new ArrayList<Bitmap>();
	for(int i=0;i<drawablelist.length;i++)		
		imageBitmapList.add( BitmapFactory.decodeResource(activity.getResources(),drawablelist[i] ));
	
	
	}
	
	
	
	
	public static void setBitmap(Activity activity)
	{
		Utils utils = new Utils(activity);
		
		List<String> imagePaths = utils.getFilePaths();

		imageBitmapList = new ArrayList<Bitmap>();
		for (String path : imagePaths) {

			imageBitmapList.add(BitmapFactory.decodeFile(path));

		}
	}
	
	
	public static void setOddBitmap(Activity activity)
	{
		Utils utils = new Utils(activity);
		
		List<String> imagePaths = utils.getFilePaths();

		imageBitmapList = new ArrayList<Bitmap>();
		int i=0;
		for (String path : imagePaths) {
			if(i%2==1)
			imageBitmapList.add(BitmapFactory.decodeFile(path));
			i++;

		}
	}
	
	

	
	
	
}
