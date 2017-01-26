package com.example.planes;

import android.graphics.Canvas;


public class PlayerManager {
	public static Player player;
	
	
	public PlayerManager()
	{
		player=new Player(MainActivity.screen_width/2, MainActivity.screen_height/2,ConstantUtil.player_pic[1]);
		player.set_infos(0,200,10);
		
	}
	
	public static void draw_player(Canvas c)
	{
		player.DrawSelf(c);
	}
	public static void fire_control()
	{
		if(MainGameThread.player_steps<player.steps)
		{
		  MainGameThread.player_steps++;
		}
		else
		{
			player.fire();
			MainGameThread.player_steps=0;
		}
	}
	
	public void Player_Runtime(Canvas c)
	{
		draw_player(c);
		fire_control();
	}
	
	public static boolean IsContain()
	{
		for(int i=0;i<BulletManager.enemyBulletList.size();i++)
		{
			
			//if(BulletManager.enemyBulletList.get(i).)
		}
		return true;
	}
	
	public boolean is_alive()
	{
		return true;
	}
	
	

}
