package com.example.planes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Title {
	
	private Canvas cc;
	private Paint paint;
	private float xstart;
	private float dx;
	private float Xpos;
	private int cur_steps;
	private int steps;
	private int steps1;
	private float percent=1f;
	
	public Title()
	{
		paint=new Paint();
		paint.setTextSize(15);
		paint.setColor(Color.WHITE);
	
		this.xstart=0;
		this.dx=5;
		this.Xpos=this.xstart;
		this.cur_steps=0;
		this.steps=0;
		this.steps1=0;
	}
	public void draw_starts(Canvas c)
	{
		this.cc=c;
		Paint paint1=new Paint();
		paint1.setARGB(130,0,255,0);
		Paint paint2=new Paint();
		paint2.setTextSize(25);
		paint2.setColor(Color.YELLOW);
		if(this.steps1<=120)
		{
			cc.drawRect(0,MainActivity.screen_height/6,MainActivity.screen_width,MainActivity.screen_width/2, paint1);
			cc.drawText("战斗开始，活下来，在3分钟内尽可能消灭敌人",0,MainActivity.screen_width/3 , paint2);
			steps1++;
		}
	}
	
	
	public void draw_lifes(Canvas c)
	{
		this.cc=c;
		Paint paint=new Paint();
		paint.setColor(Color.RED);
		percent=PlayerManager.player.lifes/200f;
		float rec_width=percent*MainActivity.screen_width;
		cc.drawRect(0,0,rec_width,25, paint);
		
	}
	
	
	
	
	public void draw_alerts(Canvas c)
	{
		this.cc=c;
		Paint paint=new Paint();
		paint.setARGB(130,255,0,0);
		Paint paint1=new Paint();
		paint1.setColor(Color.YELLOW);
		paint1.setTextSize(25);
		if(this.cur_steps<=120)
		{
		cc.drawRect(0,MainActivity.screen_height/6,MainActivity.screen_width,MainActivity.screen_width/2, paint);
		cc.drawText("你的战机受损已经达到50%",MainActivity.screen_width/3,MainActivity.screen_width/3 , paint1);
		cur_steps++;
		}
		
	}
	public void draw_tips(Canvas c)
	{
		this.cc=c;
		Paint paint=new Paint();
		paint.setARGB(130,0,0,255);
		Paint paint1=new Paint();
		paint1.setColor(Color.YELLOW);
		paint1.setTextSize(25);
		if(steps<120)
		{
			cc.drawRect(0,MainActivity.screen_height/6,MainActivity.screen_width,MainActivity.screen_width/2, paint);
			cc.drawText("你真棒，还有10秒战役就结束了",MainActivity.screen_width/3,MainActivity.screen_width/3 , paint1);
			steps++;
		}
		
		
	}
	
	public  void draw_titles(Canvas c)
	{
		this.cc=c;
		this.Xpos=this.Xpos+this.dx;
		if(this.Xpos>MainActivity.screen_width)this.Xpos=this.xstart;
		cc.drawText("您的生命值为"+PlayerManager.player.lifes+",你击落的敌机数量"+MainGameThread.beat_num,Xpos,50, paint);
	}

}
