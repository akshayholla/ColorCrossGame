package com.pilot.akugameengine;

import android.graphics.Paint;

public class Sprite {
	public Paint mPaint;
	public int xpos,ypos;
	public Sprite(int x,int y,int c)
	{
		xpos=x;
		ypos=y;
		mPaint = new Paint();
		mPaint.setDither(true);
		mPaint.setColor(c);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setStrokeWidth(4);
	}
	public void moveUpSprite()
	{
		ypos +=75;
	}

	public void moveDownSprite()
	{
		ypos -=75;
	}
}
