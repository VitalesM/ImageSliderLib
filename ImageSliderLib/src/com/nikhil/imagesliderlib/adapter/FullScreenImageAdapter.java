package com.nikhil.imagesliderlib.adapter;

import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.nikhil.imagesliderlib.R;
import com.nikhil.imagesliderlib.helper.TouchImageView;

public class FullScreenImageAdapter extends PagerAdapter {

	private Activity _activity;
	private List<Bitmap> imageBitmapList;
	private LayoutInflater inflater;

	// constructor
	public FullScreenImageAdapter(Activity activity,
			List<Bitmap> imageBitmapList) {
		this._activity = activity;
		this.imageBitmapList = imageBitmapList;
	}

	@Override
	public int getCount() {
		return this.imageBitmapList.size();
	}

	@Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }
	
	@Override
    public Object instantiateItem(ViewGroup container, int position) {
        TouchImageView imgDisplay;
       
 
        inflater = (LayoutInflater) LayoutInflater.from(_activity);
        View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container,
                false);
 
        imgDisplay = (TouchImageView) viewLayout.findViewById(R.id.imgDisplay);
       
        
       /* BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = BitmapFactory.decodeFile(_imagePaths.get(position), options);*/
        imgDisplay.setImageBitmap(imageBitmapList.get(position));
        
        // close button click event
      

        ((ViewPager) container).addView(viewLayout);
 
        return viewLayout;
	}
	
	@Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
 
    }

}
