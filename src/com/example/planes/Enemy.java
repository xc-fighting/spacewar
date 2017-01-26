package com.example.planes;




public class Enemy extends MovingObj {

	
	public int type;
	public int life;
	public int hurt_value=1;//��ײ��Ҷ������ɵ��˺�
	public int steps;//�ܵĲ���
	public int cur_steps=0;//���õ�ǰ�Ĳ���
	public Bullet BOMBS;
	public boolean Run_In_Circle=false;
	public float Alpha=0;
	public float radis=-1;
	public float LineSpeed;
	
	public Enemy(float x, float y,int type) {
		super(x, y);
		this.type=type;
		this.resource=ConstantUtil.enemy_pic[type];
		this.picwidth=this.resource.getWidth();
		this.picheight=this.resource.getHeight();
		this.life=type+1;//����ֵΪ����ֵ��1
		
		this.set_steps();
		
	}
	public void set_speed(float vx,float vy)//���õл����ٶ�
	{
	  this.xspeed=vx;
	  this.yspeed=vy;
	}
	public void go()//�ж�����
	{
	  this.xstart+=this.xspeed;
	  this.ystart+=this.yspeed;
	}
    public void set_steps()//���ÿ���Ĳ���
    {
    	if(type==0)this.steps=20;
    	if(type==1)this.steps=30;
    	if(type==2)this.steps=30;
    }
    public void fire()
    {
    	if(type!=3)
    	{
    		if(this.cur_steps<this.steps)
    		{
    			this.cur_steps++;
    		}
    		else
    		{
    			if(this.type==2)
    			{
    			BOMBS=new Bullet(this.xstart+this.picwidth/2,this.ystart+this.picheight,0f,10f,ConstantUtil.bullet_pic[type+1]);
    			BulletManager.enemyBulletList.add(BOMBS);
    			}
    			else if(this.type==0)
    			{
    				BOMBS=new Bullet(this.xstart+this.picwidth/2,this.ystart+this.picheight,0f,10f,ConstantUtil.bullet_pic[type+1]);
    				
        			BulletManager.enemyBulletList.add(BOMBS);
        			BOMBS=new Bullet(this.xstart+this.picwidth/2,this.ystart+this.picheight,10f,10f,ConstantUtil.bullet_pic[type+1]);
        			BulletManager.enemyBulletList.add(BOMBS);
        			BOMBS=new Bullet(this.xstart+this.picwidth/2,this.ystart+this.picheight,-10f,10f,ConstantUtil.bullet_pic[type+1]);
        			BulletManager.enemyBulletList.add(BOMBS);
    			}
    			else if(this.type==1)
    			{
                  
         			 BOMBS=new Bullet(this.xstart+this.picwidth/2,this.ystart+this.picheight,14.4f,14.4f,ConstantUtil.bullet_pic[type+1]);    				
         			BulletManager.enemyBulletList.add(BOMBS);
         			 BOMBS=new Bullet(this.xstart+this.picwidth/2,this.ystart+this.picheight,14.4f,-14.4f,ConstantUtil.bullet_pic[type+1]);    				
         			BulletManager.enemyBulletList.add(BOMBS);
         			 BOMBS=new Bullet(this.xstart+this.picwidth/2,this.ystart+this.picheight,-14.4f,14.4f,ConstantUtil.bullet_pic[type+1]);    				
         			BulletManager.enemyBulletList.add(BOMBS);
         			 BOMBS=new Bullet(this.xstart+this.picwidth/2,this.ystart+this.picheight,-14.4f,-14.4f,ConstantUtil.bullet_pic[type+1]);    				
         			BulletManager.enemyBulletList.add(BOMBS);
    			}
    			
    			this.cur_steps=0;
    			
    		}
    	}
    }
    
    
    
    
}
