package com.gifprojecs;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.os.SystemClock;
import android.view.View;

public class GifView extends View {
	Movie movie;
	private long mMovieStart=0;

	public GifView(Context context, InputStream inputStream) {
		super(context);
		movie = Movie.decodeStream(inputStream);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		//canvas.drawColor(Color.TRANSPARENT);
		super.onDraw(canvas);
		final long now = SystemClock.uptimeMillis();

		if (mMovieStart == 0) {
			mMovieStart = now;
		}
		final int realTime=(int )((now-mMovieStart)%movie.duration());
		movie.setTime(realTime);
		movie.draw(canvas, 10,10);
		this.invalidate();

	}
}
