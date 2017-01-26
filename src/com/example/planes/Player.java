package com.example.planes;



import android.graphics.Bitmap;

public class Player extends MovingObj{
	
	public int level;//��ҵĵȼ�
	public Bullet bombs;//������ӵ�
	public float[] fire_point=new float[2];//�ӵ����������
    public int lifes;
    public int steps=20;//�����ӵ������Ĳ�������
	
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

	public void fire()//�����ӵ��ķ���
	{
		this.fire_point[0]=this.picwidth/2+this.xstart;
		this.fire_point[1]=this.ystart;
		bombs=new Bullet(fire_point[0],fire_point[1],0,-10,ConstantUtil.bullet_pic[0]);
		BulletManager.playerBulletList.add(bombs);
		
	}
	
}
