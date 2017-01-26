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
			//Ĭ����û����ͣ��û���������������µĹ����Լ�һЩ����
			if((MainGameThread.IsPause==false)&&(MainGameThread.isRunning==true))
			{
				if(this.sec>0)
				{
					if(this.sec==10)
					{
						msg.what=0x003;
						handler.sendMessage(msg);
						//�������ʣ��10s��Ϣ
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
					//����ʤ����Ϣ,��ʾ��Ϸ����������Ҵ���������������߳�
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
