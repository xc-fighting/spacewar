package com.example.planes;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service{

	private MediaPlayer player;
	@Override
	public IBinder onBind(Intent arg0) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate()
	{
		super.onCreate();
		player=MediaPlayer.create(this,R.raw.menumusic);
		player.setLooping(true);
		player.start();
		
	}
	@Override
	public int onStartCommand(Intent intent,int flags,int startId)
	{
		return START_STICKY;
	}
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		player.stop();
		player.release();
	}
	
	

}
