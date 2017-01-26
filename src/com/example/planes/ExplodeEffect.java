package com.example.planes;

import android.graphics.Canvas;

public class ExplodeEffect {
	
	public float x;
	public float y;
	public int index=0;
	public boolean IsExist=true;
	
	public ExplodeEffect(float ex,float ey)
	{
		this.x=ex;
		this.y=ey;
	}
	
	public void DrawSelf(Canvas cc)
	{
		if(index<16)
		{
		cc.drawBitmap(ConstantUtil.explode_pic[index],x,y,null);
		index++;
		this.IsExist=true;
		}
		else
		{
			this.IsExist=false;
			
		}
	}

}
