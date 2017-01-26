package com.example.planes;



import android.graphics.Bitmap;

public class Bullet extends MovingObj{

	
	public Bullet(float x, float y, float vx, float vy,Bitmap bitmaps) {
		super(x, y, vx, vy, bitmaps);
		// TODO Auto-generated constructor stub
		
	}
	public void go()
	{
		this.xstart+=this.xspeed;
		this.ystart+=this.yspeed;
	}

}
