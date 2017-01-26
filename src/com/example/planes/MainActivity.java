package com.example.planes;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import android.os.Handler;
//import android.os.Message;
import android.app.Activity;
import android.app.Dialog;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
//import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public  class MainActivity extends Activity {
	
	public static int screen_width;
	public static int screen_height;
	public MySurfaceView myview;
	public static MusicEffects music;
	public Handler handler;
	private float mPreviousY,mPreviousX ;
	private MediaPlayer player=new MediaPlayer();;
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		
		
		handler=new Handler()
		{     
			  @Override
			   public void handleMessage(Message msg)
			   {
				   super.handleMessage(msg);
				   switch(msg.what)
				   {
				   case 0x001:
					   Intent intent=new Intent(MainActivity.this,FailActivity.class);					   
					   MainActivity.this.startActivity(intent);
					  MainActivity.this.finish();
					  break;
				   case 0x003:
					     MainGameThread.timetips=true;
					   break;
				   case 0x004:
					   MainGameThread.isRunning=false;
					   Intent intent1=new Intent(MainActivity.this,WinActivity.class);					   
					   MainActivity.this.startActivity(intent1);
					  MainActivity.this.finish();
					   break;
					  
					  
				   }
				
				  
				   
			   }
			};
		myview=new MySurfaceView(this,this.handler);
		myview.setOnTouchListener(new touchlistener());
		setContentView(myview);
		this.getScreenInfo();
		music=new MusicEffects(this);
		music.init_sounds();
		player=MediaPlayer.create(this,R.raw.bgm_zhandou2);
		player.setLooping(true);
		player.start();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public  void getScreenInfo()
	{
		WindowManager manager=getWindowManager();
		Display display=manager.getDefaultDisplay();
		DisplayMetrics metrics=new DisplayMetrics();
		display.getMetrics(metrics);
		screen_width=metrics.widthPixels;
		screen_height=metrics.heightPixels;
	}
	
	class touchlistener implements OnTouchListener
	{

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
		
		//	PlayerManager.player.xstart=(int)event.getX();
			
		//	PlayerManager.player.ystart=(int)event.getY();
		
			 float y = event.getY();
		        float x = event.getX();
		        switch (event.getAction()) {
		        case MotionEvent.ACTION_MOVE:
		            float dy = y - mPreviousY;//¼ÆËã´¥¿Ø±ÊYÎ»ÒÆ
		            float dx = x - mPreviousX;//¼ÆËã´¥¿Ø±ÊXÎ»ÒÆ
		            PlayerManager.player.xstart+=dx;
		            PlayerManager.player.ystart+=dy;
		           
		        }
		        mPreviousY = y;//¼ÇÂ¼´¥¿Ø±ÊÎ»ÖÃ
		        mPreviousX = x;//¼ÇÂ¼´¥¿Ø±ÊÎ»ÖÃ
		        return true;
			
			
		}
		
	}
	public void Dialog()
	{
		MainGameThread.IsPause=true;
		AlertDialog.Builder builder=new Builder(MainActivity.this);
		builder.setMessage("ÔÝÍ£ÓÎÏ·");
		builder.setPositiveButton("¼ÌÐøÓÎÏ·", new android.content.DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				MainGameThread.IsPause=false;
				dialog.dismiss();
				
			}
		} );
		builder.create().show();
	}
	
	
	
	
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		player.stop();
		player.release();
	}
	
	
	
	public boolean onKeyDown(int KeyCode, KeyEvent event)
	{
		if(KeyCode==KeyEvent.KEYCODE_BACK&&event.getRepeatCount()==0)
		{
		
			MusicEffects.shots.play(MusicEffects.soundMap.get(1),1,1,0,0,1);
			Dialog();
			
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
