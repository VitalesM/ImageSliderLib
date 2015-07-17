/**
 * @author Nikhil V
 *
 * Jul 17, 2015
 */
package com.nikhil.imagesliderlib.adapter;

import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.nikhil.imagesliderlib.R;

/**
 * @author Nikhil V
 *
 */
public class GalleryImageAdapter extends BaseAdapter {
	private Context context;
	private int itemBackground;
	private List<Bitmap> imageList;
	

	
	public GalleryImageAdapter(Context c,List<Bitmap> imageList,TypedArray typedArray)
	{
		this.imageList = imageList;
		context = c;
		// sets a grey background; wraps around the images
		
		itemBackground = typedArray.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
		typedArray.recycle();
	}
	// returns the number of images
	public int getCount() {
		return imageList.size();
	}
	// returns the ID of an item
	public Object getItem(int position) {
		return imageList.get(position);
	}
	// returns the ID of an item
	public long getItemId(int position) {
		return imageList.get(position).hashCode();
	}
	// returns an ImageView view
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = new ImageView(context);
		imageView.setImageBitmap(imageList.get(position));
		imageView.setLayoutParams(new Gallery.LayoutParams(300, 300));
		imageView.setBackgroundResource(itemBackground);
		return imageView;
	}
}
