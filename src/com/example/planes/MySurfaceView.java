



package com.example.planes;






import android.content.Context;


import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;


public class MySurfaceView extends SurfaceView implements Callback{

	
	public SurfaceHolder holder;
	public Context context;
	public Handler handler;
	public MainGameThread MygameThread;
	public GameTimer timeThread;
    public GameAI manage;
	int dy=0;
	
	public MySurfaceView(Context context,Handler handler) {
		super(context);
		// TODO Auto-generated constructor stub
		this.handler=handler;
		this.context=context;
		holder=this.getHolder();
		holder.addCallback(this);
		this.setFocusable(true);
		this.setFocusableInTouchMode(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int width, int height, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		//new GameAI(this).decodeAllResources();
		manage=new GameAI(this);
		manage.decodeAllResources();
		MygameThread=new MainGameThread(this,handler);
		timeThread=new GameTimer(180,handler);
		MygameThread.isRunning=true;
		MygameThread.start();
		timeThread.start();
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) 
	{
		// TODO Auto-generated method stub	
		MygameThread.isRunning=false;
		try
		{
			MygameThread.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
}
