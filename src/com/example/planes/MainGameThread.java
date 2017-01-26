package com.example.planes;




import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import android.graphics.Paint;

import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;

public class MainGameThread extends Thread{
	private MySurfaceView mv;
	
	private SurfaceHolder holder;
	public static int player_steps=0;
	public static  boolean IsPause=false;
	public static  boolean isRunning;
	public static boolean timetips=false;
	
	public Message msg;
    public static int beat_num=0;
    
   

	public Handler handler;
    
	int dy=0;
	
	
	public float []Xpositions={
			MainActivity.screen_width/6,MainActivity.screen_width/3,
			MainActivity.screen_width/2,MainActivity.screen_width*2/3,
			MainActivity.screen_width*5/6
				
		};
		
		public int[][] Combines=
			{
				{3,3,3,3,3},
				{1,1,1,1,1},
				{1,2,2,2,1},
				{3,2,2,2,3},
				{2,0,2,0,2},
				{1,0,1,0,1},
				{2,2,2,2,2},
				{1,1,3,1,1},
				{3,0,3,0,3}		
			};
	
	
	
	
	
	
	
	public MainGameThread(MySurfaceView m,Handler handler)
	{
		
		this.mv=m;
		this.holder=mv.holder;
		this.handler=handler;
		 msg=new Message();
		
	
	}
	
	public void run()
	{
		beat_num=0;
		int dy=0,bg_y;//画背景专用变量
	
		PlayerManager player=new PlayerManager();
		BulletManager bullets=new BulletManager();
		ExplodeManager explodes=new ExplodeManager();
		Title title=new Title();
		EnemyManager enemys=new EnemyManager();		
		 Bitmap bitmap=BitmapFactory.decodeResource(this.mv.getResources(),R.drawable.background2);
		bitmap=Bitmap.createScaledBitmap(bitmap,
					MainActivity.screen_width,MainActivity.screen_height*2,true);
		while(isRunning==true)
		{
			if(IsPause!=true)
			{
			dy+=4;
           synchronized(holder)
           {  
        	   
        	   if(EnemyManager.EnemyList.size()<=2)
        	   {
        		   Random random=new Random();
        		   int seed=random.nextInt(9);
        		   for(int i=0;i<5;i++)
        		   {
        			   EnemyManager.EnemyList.add(new Enemy(Xpositions[i],0,Combines[seed][i]));
        		   }
        	   }
        	   /*
        	    * 画背景
        	    * */
	            bg_y=-MainActivity.screen_height+dy;
	            Canvas canvas = holder.lockCanvas(); 
	            
	         
	            canvas.drawBitmap(bitmap,0,bg_y,null);
	            if(bg_y>0)dy=0;
	            
	            /*
	             * 画标题
	             * 
	             * */
	            Paint paint=new Paint();
	        
	            paint.setAlpha(5);
	            canvas.drawRect(0f, 0f,MainActivity.screen_width*1.0f,MainActivity.screen_height*0.05f, paint);
	          

	        title.draw_starts(canvas);
	        title.draw_titles(canvas);
	        title.draw_lifes(canvas);
	         enemys.EnemyRunTime(canvas);
	         player.Player_Runtime(canvas);
	         bullets.BulletRunTime(canvas);
	         explodes.ExplodeRuntime(canvas);
	         
	         if(PlayerManager.player.lifes<=0)
         	{
         	
         		msg.what=0x001;
         		handler.sendMessage(msg);
         		isRunning=false;
         		
         	}
	        if(PlayerManager.player.lifes<=100)
	        {
	        	title.draw_alerts(canvas);
	        }
	        if(timetips==true)
	        {
	        	title.draw_tips(canvas);
	        }
	           
	            holder.unlockCanvasAndPost(canvas); 
          
	        }  
                try {  
               
                Thread.sleep(1000/60);  
            } 
            catch (InterruptedException e) {  
                
                e.printStackTrace();  
            }
               

           
            
			}
           
            
           
		}
	}
	

}
