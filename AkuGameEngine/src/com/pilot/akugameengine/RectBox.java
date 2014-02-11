package com.pilot.akugameengine;

import android.graphics.Paint;

public class RectBox {
	
	public int xpos,ypos;
	boolean rflag=true;
	boolean lflag=false,hit=false;
	@SuppressWarnings("unused")
	private int screen_width,screen_height;
	private int speed;
	public Paint mPaint;
	public RectBox(int sW,int sH,int x,int y,int spd,int c)
	{
		screen_width=sW;
		screen_height=sH;
		xpos=x;
		ypos=y;
		speed=spd;
		mPaint = new Paint();
		mPaint.setDither(true);
		mPaint.setColor(c);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setStrokeWidth(4);
	}
	public void drawRect() {
		if(rflag)
		{
			xpos += speed;
		}
		if (lflag)
		{
			xpos -= speed;
		}
		if(rflag && (xpos+50)>screen_width)
		{
			rflag=false;
			lflag=true;
		}
		if(lflag && xpos<0)
		{
			rflag=true;
			lflag=false;
		}
	}

}
