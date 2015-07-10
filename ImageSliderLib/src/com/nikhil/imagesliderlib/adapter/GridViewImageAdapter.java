package com.nikhil.imagesliderlib.adapter;

import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.nikhil.imagesliderlib.helper.AppConstant;
import com.nikhil.imagesliderlib.helper.OnImageClickListener;

public class GridViewImageAdapter extends BaseAdapter {

	private Activity _activity;
	private int imageWidth;
	
	private List<Bitmap> imageList;

	public GridViewImageAdapter(Activity activity, List<Bitmap> imageList,
			int imageWidth) {
		this._activity = activity;
		this.imageList = imageList;
		this.imageWidth = imageWidth;
	}

	@Override
	public int getCount() {
		return this.imageList.size();
	}

	@Override
	public Object getItem(int position) {
		return this.imageList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(_activity);
		} else {
			imageView = (ImageView) convertView;
		}

		

		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setLayoutParams(new GridView.LayoutParams(imageWidth,
				imageWidth));
		imageView.setImageBitmap(imageList.get(position));

		// image view click listener
		if(AppConstant.gridviewClickListener == null)
		imageView.setOnClickListener(new OnImageClickListener(position,_activity));
		else
			imageView.setOnClickListener(AppConstant.gridviewClickListener);	

		return imageView;
	}

	

	/*
	 * Resizing image size
	 */
	/*public static Bitmap decodeFile(String filePath, int WIDTH, int HIGHT) {
		try {

			File f = new File(filePath);

			BitmapFactory.Options o = new BitmapFactory.Options();
			o.inJustDecodeBounds = true;
			BitmapFactory.decodeStream(new FileInputStream(f), null, o);

			final int REQUIRED_WIDTH = WIDTH;
			final int REQUIRED_HIGHT = HIGHT;
			int scale = 1;
			while (o.outWidth / scale / 2 >= REQUIRED_WIDTH
					&& o.outHeight / scale / 2 >= REQUIRED_HIGHT)
				scale *= 2;

			BitmapFactory.Options o2 = new BitmapFactory.Options();
			o2.inSampleSize = scale;
			return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}*/

}
