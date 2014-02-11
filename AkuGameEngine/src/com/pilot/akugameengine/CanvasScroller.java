package com.pilot.akugameengine;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

public class CanvasScroller extends View {

	private static int timeInt = 40;
	private Handler screenRefresh = new Handler();
	private int screen_width;
	private int screen_height;
	RectBox b[] = new RectBox[4];
	public Paint mPaint;
	
	int colours[] = { Color.BLUE, Color.BLACK, Color.CYAN, Color.GREEN,
			Color.WHITE, Color.YELLOW, Color.RED };
	Sprite sp;
	int cN=6;
	Random r = new Random();
	int score=0;
	int offset=30;
	String sc=Integer.toString(score);

	public CanvasScroller(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

		screenRefresh.postDelayed(threadRefresh, timeInt);
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		screen_width = metrics.widthPixels;
		screen_height = metrics.heightPixels;
		
		mPaint = new Paint();
		mPaint.setColor(Color.BLACK);
		mPaint.setTextSize(60);
		
		Log.d("com.pilot.aku", " screen size is " + screen_width);
		b[0] = new RectBox(screen_width, screen_height, 200, 200, 5,
				colours[6]);
		b[1] = new RectBox(screen_width, screen_height, 0, 350, 10,
				colours[5]);
		b[2] = new RectBox(screen_width, screen_height, 200, 500, 9,
				colours[4]);
		b[3] = new RectBox(screen_width, screen_height, 0, 650, 7,
				colours[3]);
		sp = new Sprite(screen_width / 2, 750,
				colours[cN]);
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		for (RectBox ele : b) {
			ele.drawRect();
			canvas.drawRect(ele.xpos, ele.ypos, ele.xpos + 50, ele.ypos + 50,
					ele.mPaint);

		}
		hitDetect();
		canvas.drawCircle(sp.xpos, sp.ypos, 25, sp.mPaint);
		canvas.drawText(sc,screen_width/2-offset,100 ,mPaint);
	}

	private Runnable threadRefresh = new Runnable() {

		@Override
		public void run() {
			invalidate();
			screenRefresh.postDelayed(threadRefresh, timeInt);
		}

	};

	public void spriteUp() {
		sp.moveUpSprite();
	}

	public void spriteDown() {
		sp.moveDownSprite();
	}

	public void hitDetect() {
		for (RectBox ele : b) {
			if (((sp.xpos >= ele.xpos) && (sp.xpos <= ele.xpos + 50))
					&& ((ele.ypos + 50 >= sp.ypos) && (ele.ypos <= sp.ypos))) {
				// Log.d("debug", sp.xpos + " " + ele.xpos + ":" + sp.ypos + " "
				// + ele.ypos);
				// sp.mPaint.setColor(ele.mPaint.getColor());
				if (ele.mPaint.getColor() == sp.mPaint.getColor()) {
					ele.mPaint.setStyle(Paint.Style.FILL);
					cN--;
					resetSp();
					score+=25;
					sc=Integer.toString(score);
					if(score==100)
					{
						sc="You Won";
						offset=120;
					}
				} else {
					resetSp();
					
				}

			}
		}
	}

	public void resetSp() {
		sp.ypos = 750;
		sp.mPaint.setColor(colours[cN]);
	}
}
