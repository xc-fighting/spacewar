package com.example.planes;
/*****
 * 所有敌机，子弹，玩家的基类
 * 
 * 
 * 
 * ******/
import android.graphics.Bitmap;
import android.graphics.Canvas;


public   class MovingObj {
	
	/*
	 * 成员属性
	 * */
	
	public float xstart;//开始的x
	public float ystart;//开始的y
	public float xspeed;//x速度
	public float yspeed;//y速度
	
	public Bitmap resource;//素材背景图
	
	public int picwidth;
	public int picheight;
	
	/*
	 * 成员函数
	 * */
	public MovingObj(float x,float y,float vx,float vy,Bitmap bitmaps)
	{
		this.xstart=x;
		this.ystart=y;
		this.xspeed=vx;
		this.yspeed=vy;
		
		/*
		 * 通过图片获取图片的宽和高
		 * */
		this.resource=bitmaps;
		this.picwidth=resource.getWidth();
		this.picheight=resource.getHeight();
		
	}
	
	public MovingObj(float x,float y,float vx,float vy)
	{
		this.xstart=x;
		this.ystart=y;
		this.xspeed=vx;
		this.yspeed=vy;
	}
	
	public MovingObj(float x,float y,Bitmap bitmap)
	{
		this.xstart=x;
		this.ystart=y;
		
		this.resource=bitmap;
		this.picwidth=resource.getWidth();
		this.picheight=resource.getHeight();
	}
	
	public MovingObj(float x,float y)
	{
		this.xstart=x;
		this.ystart=y;
	}
	
	public void DrawSelf(Canvas cc)
	{
		cc.drawBitmap(resource, xstart, ystart,null);
	}
	public void go() {
	}
	

}
