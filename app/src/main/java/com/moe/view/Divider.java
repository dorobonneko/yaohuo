package com.moe.view;
import android.support.v7.widget.RecyclerView;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.util.TypedValue;
import android.util.DisplayMetrics;

public class Divider extends RecyclerView.ItemDecoration
{
	private Paint paint=new Paint();
	private Rect rect=new Rect();
	public Divider(int color,int left,int top,int right,int bottom,DisplayMetrics dm){
		paint.setColor(color);
		rect.set((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,left,dm),(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,top,dm),(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,right,dm),(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,bottom,dm));
	}
	public Divider(int size){
		paint.setColor(0x00000000);
		rect.set(size,size/2,size,size);
	}
	public Divider(int left,int top,int right,int bottom,DisplayMetrics dm){
		this(0x00000000,left,top,right,bottom,dm);
	}
	public Divider(DisplayMetrics dm){
		this(0x00000000,5,dm);
	}
	public Divider(int color,int height,DisplayMetrics dm){
	this(color,height/2,0,height/2,height,dm);
	
	}


	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
	{
		//if(parent.getChildAdapterPosition(view)!=parent.getAdapter().getItemCount()-1)
		outRect.set(rect);
		}

	@Override
	public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state)
	{
		int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom();
            c.drawRect(left+rect.left, top+rect.top, right+rect.right, bottom+rect.bottom, paint);
        }

			}

	
	
}
