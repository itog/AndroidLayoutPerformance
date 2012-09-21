package com.pigmal.android.example.layoutperformancecheck;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				StringBuffer sb = new StringBuffer();
				sb.append(measureInflateTime(MainActivity.this, R.layout.layout10));
				sb.append(",");
				sb.append(measureInflateTime(MainActivity.this, R.layout.layout100));
				sb.append(",");
				sb.append(measureInflateTime(MainActivity.this, R.layout.layout_w_shape10));
				sb.append(",");
				sb.append(measureInflateTime(MainActivity.this, R.layout.layout_w_shape100));
				sb.append(",");
				sb.append(measureInflateTime(MainActivity.this, R.layout.layout_w_layer10));
				sb.append(",");
				sb.append(measureInflateTime(MainActivity.this, R.layout.layout_w_layer100));
				sb.append(",");
				sb.append(measureInflateTime(MainActivity.this, R.layout.layout_flat10));
				sb.append(",");
				sb.append(measureInflateTime(MainActivity.this, R.layout.layout_flat100));
				sb.append(",");
				sb.append(measureInflateTime(MainActivity.this, R.layout.layout_include10));
				sb.append(",");
				sb.append(measureInflateTime(MainActivity.this, R.layout.layout_include100));
				Log.d("Performance", sb.toString());
			}
		});
	}
	
	long measureInflateTime(Context c, int layout) {
		long start = 0;
		long end = 0;

		start = System.currentTimeMillis();
		View.inflate(c, layout, null);
		end = System.currentTimeMillis();
		return end - start;
	}
}
