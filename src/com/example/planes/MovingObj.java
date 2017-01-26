package com.example.planes;
/*****
 * ���ел����ӵ�����ҵĻ���
 * 
 * 
 * 
 * ******/
import android.graphics.Bitmap;
import android.graphics.Canvas;


public   class MovingObj {
	
	/*
	 * ��Ա����
	 * */
	
	public float xstart;//��ʼ��x
	public float ystart;//��ʼ��y
	public float xspeed;//x�ٶ�
	public float yspeed;//y�ٶ�
	
	public Bitmap resource;//�زı���ͼ
	
	public int picwidth;
	public int picheight;
	
	/*
	 * ��Ա����
	 * */
	public MovingObj(float x,float y,float vx,float vy,Bitmap bitmaps)
	{
		this.xstart=x;
		this.ystart=y;
		this.xspeed=vx;
		this.yspeed=vy;
		
		/*
		 * ͨ��ͼƬ��ȡͼƬ�Ŀ�͸�
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
