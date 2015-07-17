package com.nikhil.imagesliderlib.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class AppConstant {

	// Number of columns of Grid View
	public static int NUM_OF_COLUMNS = 3;

	// Gridview image padding
	public static  int GRID_PADDING = 8; // in dp

	// SD card image directory
	public static  String PHOTO_ALBUM = "/mnt/shared/GennyMotionShared/jamesRodriguez/";

	// supported file formats
	public static final List<String> FILE_EXTN = Arrays.asList("jpg", "jpeg",
			"png");
	
	public static OnImageClickListener gridviewClickListener = null;
	
	
	public static List<Bitmap> imageBitmapList;
	
	public static int [] drawablelist ;
	
	
	public static void setBitmapDrawable(Activity activity,int columnWidth)
	{
		imageBitmapList = new ArrayList<Bitmap>();
		
	for(int i=0;i<drawablelist.length;i++)		
		imageBitmapList.add( decodeSampledBitmapFromResource(activity.getResources(), drawablelist[i], 100, 100));
	
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
	
	

	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);

	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	}
	
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;

        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
}
	
	
	
	
	
	
}
