package com.example.planes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.Canvas;



public class EnemyManager {
	
	public static List<Enemy> EnemyList=new ArrayList<Enemy>();
	public int vx_of_enemy2=2;
	public float[] Points=new float[5];
	public EnemyManager()
	{
		
	}
	
	public void UpdataAllCoords()
	{
		
		for(int i=0;i<EnemyList.size();i++)
		{
			Enemy tempEnemy=EnemyList.get(i);
			switch(tempEnemy.type)
			{
			case 0:
			{				
				
			if(tempEnemy.ystart<=MainActivity.screen_height/3&&tempEnemy.Run_In_Circle==false)tempEnemy.set_speed(0,5);
			else
			{
				tempEnemy.Run_In_Circle=true;
				if(tempEnemy.radis==-1)
				{
				tempEnemy.radis=(float) Math.sqrt((tempEnemy.xstart-MainActivity.screen_width/2)*(tempEnemy.xstart-MainActivity.screen_width/2)
						+(tempEnemy.ystart-MainActivity.screen_height/3)*(tempEnemy.ystart-MainActivity.screen_height/3));
				tempEnemy.LineSpeed=(float) ((Math.PI/32)*tempEnemy.radis);
				}
				if(tempEnemy.Alpha<=10*Math.PI)//ת5Ȧ
				{
					
					tempEnemy.set_speed(tempEnemy.LineSpeed*(float)Math.sin(tempEnemy.Alpha),tempEnemy.LineSpeed*(float)Math.cos(tempEnemy.Alpha));
					tempEnemy.Alpha+=Math.PI/32;
				}
				else
				{
					tempEnemy.set_speed(0,5);
				}
				
				
			}
				
			}break;
			case 1:
			{
				tempEnemy.set_speed(0,4);
				
			}break;
			case 2:
			{
				if(tempEnemy.ystart<MainActivity.screen_height/2)tempEnemy.set_speed(0,5);
				if(tempEnemy.ystart>=MainActivity.screen_height/2)
				{
					
					if((tempEnemy.xstart+tempEnemy.picwidth<=MainActivity.screen_width)&&(tempEnemy.xstart>=0))
					{
					  tempEnemy.set_speed(vx_of_enemy2,0);	
					}
					else
					{
						vx_of_enemy2=-1*vx_of_enemy2;
						tempEnemy.set_speed(vx_of_enemy2,0);
					
						
					}
					
					
				}
			}break;
			case 3:
			{
				float X_chaser=tempEnemy.xstart;
				float Y_chaser=tempEnemy.ystart;
				float X=PlayerManager.player.xstart;
				float Y=PlayerManager.player.ystart;
				float vx=X-X_chaser;
				float vy=Y-Y_chaser;
				float vlen=(float) Math.sqrt((X-X_chaser)*(X-X_chaser)+(Y-Y_chaser)*(Y-Y_chaser));
				
				tempEnemy.set_speed(vx/vlen*10, vy/vlen*10);
				
				
				
				
			}break;			
			}
			tempEnemy.go();
		}
	}
	
	public void DrawAllEnemys(Canvas cc)
	{
		for(int i=0;i<EnemyList.size();i++)
		{
			EnemyList.get(i).DrawSelf(cc);
		}
		
	}
	
	public void ISCollision()
	{
		Enemy tempenemy;
		for(int i=0;i<EnemyList.size();i++)
		{
			tempenemy=EnemyList.get(i);
			float Enemy_CenterX=tempenemy.xstart+tempenemy.picwidth/2;
			float Enemy_CenterY=tempenemy.ystart+tempenemy.picheight/2;
			float Player_CenterX=PlayerManager.player.xstart+PlayerManager.player.picwidth/2;
			float Player_CenterY=PlayerManager.player.ystart+PlayerManager.player.picheight/2;
			float vx=Enemy_CenterX-Player_CenterX;
			float vy=Enemy_CenterY-Player_CenterY;
			float dis1=vx*vx+vy*vy;
			float dis2=PlayerManager.player.picwidth/2*PlayerManager.player.picwidth/2+PlayerManager.player.picheight/2*PlayerManager.player.picheight/2;
			if(dis1<dis2)
			{
				EnemyList.remove(i);
				PlayerManager.player.lifes--;
				ExplodeEffect effect=new ExplodeEffect(Enemy_CenterX,Enemy_CenterY);
				ExplodeManager.explodeList.add(effect);
			}
		}
	}
	
	public void fireControl()
	{
		for(int i=0;i<EnemyList.size();i++)
		{
			EnemyList.get(i).fire();
		}
	}
	
	public void ISOverBundary()
	{
		for(int i=0;i<EnemyList.size();i++)
		{
			if(EnemyList.get(i).ystart>=MainActivity.screen_height)
			{
				EnemyList.remove(i);
			}
		}
	}
	public void EnemyRunTime(Canvas cc)
	{
		
		ISOverBundary();
		ISCollision();
		UpdataAllCoords();
		
		DrawAllEnemys(cc);		
		fireControl();
		
	}

	
		
	
	

}
