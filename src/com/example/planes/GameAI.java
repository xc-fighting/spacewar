package com.example.planes;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class GameAI {
	

	public MySurfaceView mv;

	


	
	
	public GameAI(MySurfaceView m)
	{
		this.mv=m;
		
	
		
		
	}
	
	
	
	
	//加载所有图片资源
	public void decodeAllResources()
	{
		int i;
		for(i=0;i<ConstantUtil.NumOfExplode;i++)
		{
		 ConstantUtil.explode_pic[i]=BitmapFactory.decodeResource(mv.getResources(),ConstantUtil.id_explode[i]);
		 ConstantUtil.explode_pic[i]=Bitmap.createScaledBitmap(ConstantUtil.explode_pic[i], 40, 40,true);
		}
		for(i=0;i<ConstantUtil.NumOfBullet;i++)
		{
			ConstantUtil.bullet_pic[i]=BitmapFactory.decodeResource(mv.getResources(),ConstantUtil.id_bullet[i]);
			
		}
		for(i=0;i<ConstantUtil.NumOfBackground;i++)
		{
			ConstantUtil.background_pic[i]=BitmapFactory.decodeResource(mv.getResources(),ConstantUtil.id_background[i]);
			ConstantUtil.background_pic[i]=Bitmap.createScaledBitmap(ConstantUtil.background_pic[i],
					MainActivity.screen_width,MainActivity.screen_height*2,true);
		}
		for(i=0;i<ConstantUtil.NumOfPlayer;i++)
		{
			ConstantUtil.player_pic[i]=BitmapFactory.decodeResource(mv.getResources(),ConstantUtil.id_player[i]);
			ConstantUtil.player_pic[i]=Bitmap.createScaledBitmap(ConstantUtil.player_pic[i], 80,80,true);
		}
		for(i=0;i<ConstantUtil.NumOfEnemy;i++)
		{
			ConstantUtil.enemy_pic[i]=BitmapFactory.decodeResource(mv.getResources(),ConstantUtil.id_enemy[i]);
			ConstantUtil.enemy_pic[i]=Bitmap.createScaledBitmap(ConstantUtil.enemy_pic[i],60,60,true);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
