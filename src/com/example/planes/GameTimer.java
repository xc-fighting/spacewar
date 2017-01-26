package com.example.planes;

import android.os.Handler;
import android.os.Message;

public class GameTimer extends Thread{
	
	private int sec;
	private Handler handler;
	private Message msg;
	
	public GameTimer(int seconds,Handler handler)
	{
		this.sec=seconds;
		this.handler=handler;
		msg=new Message();
	}
	
	public void run()
	{
		while(true)
		{
			//默认在没有暂停，没有玩家死掉的情况下的过程以及一些操作
			if((MainGameThread.IsPause==false)&&(MainGameThread.isRunning==true))
			{
				if(this.sec>0)
				{
					if(this.sec==10)
					{
						msg.what=0x003;
						handler.sendMessage(msg);
						//发送最后剩余10s消息
					}
					
					try {
						this.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sec--;
				}
				else
				{
					//传递胜利信息,表示游戏结束并且玩家存活下来并且跳出线程
					msg.what=0x004;
					handler.sendMessage(msg);
					break;
				}
				
			}
			else
			{
				if(MainGameThread.isRunning==false)break;
			}
		}
	}

}
