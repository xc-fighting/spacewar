package com.example.planes;



import android.graphics.Bitmap;

public class Player extends MovingObj{
	
	public int level;//玩家的等级
	public Bullet bombs;//发射的子弹
	public float[] fire_point=new float[2];//子弹发射点坐标
    public int lifes;
    public int steps=20;//发射子弹经过的步长数量
	
	public Player(float x, float y,Bitmap bitmaps) {
		super(x, y,bitmaps);
		// TODO Auto-generated constructor stub
	}
	public void set_infos(int level,int life,int step)
	{
		this.level=level;
		this.lifes=life;
		this.steps=step;
	}

	public void fire()//产生子弹的方法
	{
		this.fire_point[0]=this.picwidth/2+this.xstart;
		this.fire_point[1]=this.ystart;
		bombs=new Bullet(fire_point[0],fire_point[1],0,-10,ConstantUtil.bullet_pic[0]);
		BulletManager.playerBulletList.add(bombs);
		
	}
	
}
