package com.pilot.akugameengine;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.akugameengine.R;

public class MainActivity extends Activity {
	CanvasScroller bg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// try to remove title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);

		RelativeLayout rLay = (RelativeLayout) findViewById(R.id.mainLayout);
		bg=new CanvasScroller(this.getBaseContext());
		rLay.addView(bg);
		
	}
	public void spriteUp(View v) {
	 bg.spriteUp();

	}
	public void spriteDown(View V) {
		bg.spriteDown();

	}
}
