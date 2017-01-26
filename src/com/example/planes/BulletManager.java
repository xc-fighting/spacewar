package com.example.planes;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;




public class BulletManager {
	

	
	public static List<Bullet> enemyBulletList=new ArrayList<Bullet>();
	public static List<Bullet> playerBulletList=new ArrayList<Bullet>();
	private Enemy tempEnemy;
	
	public BulletManager()
	{
		
	}
	public void updateALL()
	{
		for(int i=0;i<playerBulletList.size();i++)
		{
			playerBulletList.get(i).go();
		}
		for(int i=0;i<enemyBulletList.size();i++)
		{
			enemyBulletList.get(i).go();
		}
	}
	public void DrawAllBullet(Canvas canvas)
	{
		for(int i=0;i<playerBulletList.size();i++)
		{
			playerBulletList.get(i).DrawSelf(canvas);
		}
		for(int i=0;i<enemyBulletList.size();i++)
		{
			enemyBulletList.get(i).DrawSelf(canvas);
		}
	}
	
	public void isDestroyed()
	{
		
	
		for(int i=0;i<playerBulletList.size();i++)
		{
			Bullet playerbullet=playerBulletList.get(i);
			if(playerbullet.ystart<MainActivity.screen_height*0.05)
			{
				/*
				 * 这块有事儿可以琢磨关于remove方法的index问题和remove(object)
				 * 
				 * */
				playerBulletList.remove(playerbullet);	
				if(i>0)
				i-=1;
				else i=0;
			}
			else
			{
				for(int j=0;j<EnemyManager.EnemyList.size();j++)
				{
					this.tempEnemy=EnemyManager.EnemyList.get(j);
					float centerX=tempEnemy.xstart+tempEnemy.picwidth/2;
					float centerY=tempEnemy.ystart+tempEnemy.picheight/2;
					
					float dis1=(centerX-playerbullet.xstart)*(centerX-playerbullet.xstart)+
							(centerY-playerbullet.ystart)*(centerY-playerbullet.ystart);
					float dis2=(tempEnemy.picheight/2)*(tempEnemy.picheight/2)+(tempEnemy.picwidth/2)*(tempEnemy.picwidth/2);
					if(dis1<=dis2)
					{
						int explodeX=(int)centerX;
						int explodeY=(int)centerY;
						ExplodeManager.explodeList.add(new ExplodeEffect(explodeX,explodeY));
						MusicEffects.shots.play(MusicEffects.soundMap.get(3),0.1f,0.1f,0,0,1);
						tempEnemy.life--;
						playerBulletList.remove(playerbullet);//这句会出错
						if(i>0)
							i-=1;
							else i=0;
						if(tempEnemy.life<=0)
						{
						EnemyManager.EnemyList.remove(j);
						j-=1;//new add
						MainGameThread.beat_num++;
						MusicEffects.shots.play(MusicEffects.soundMap.get(4),0.1f,0.1f,0,0,1);
					    }
						
					}
				}
			}
		//	if(playerbullet.ystart<MainActivity.screen_height*0.05)
		//	{
		//		playerBulletList.remove(i);	
		//		i-=1;
		//	}
		}
		
		/*
		 * 
		 * 这里我采用这个就没有问题
		 * */
		for(int i=0;i<enemyBulletList.size();i++)
		{
			if(enemyBulletList.get(i).ystart>=MainActivity.screen_height||enemyBulletList.get(i).xstart<=0||enemyBulletList.get(i).xstart>=MainActivity.screen_width)
			{
				enemyBulletList.remove(i);
				i-=1;
			}
			else//判断是否和玩家战机发生了碰撞
			{
				float centerX=PlayerManager.player.xstart+PlayerManager.player.picwidth/2;
				float centerY=PlayerManager.player.ystart+PlayerManager.player.picheight/2;
				float coorX=enemyBulletList.get(i).xstart;
				float coorY=enemyBulletList.get(i).ystart+enemyBulletList.get(i).picheight;
				float dis1=(coorX-centerX)*(coorX-centerX)+(coorY-centerY)*(coorY-centerY);
				float dis2=(PlayerManager.player.picwidth/2)*(PlayerManager.player.picwidth/2)
						+(PlayerManager.player.picheight/2)*(PlayerManager.player.picheight/2);
				if(dis1<dis2)
				{
					--PlayerManager.player.lifes;
					enemyBulletList.remove(i);
					i-=1;
					if(PlayerManager.player.lifes<=0)
					{
						
						ExplodeManager.explodeList.add(new ExplodeEffect((int)centerX,(int)centerY));
					}
				
				
				}
				
			}
		}
		
		
	}
	
	public void BulletRunTime(Canvas canvas)
	{ 
	   isDestroyed();
	   updateALL();
	  
	   DrawAllBullet(canvas);
	   
	}

}
