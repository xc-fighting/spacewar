package com.example.planes;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

public class ExplodeManager {
	
	
	
	public static List<ExplodeEffect> explodeList=new ArrayList<ExplodeEffect>();
	
	public ExplodeManager()
	{
		
	}
	
	public void DrawAllExplodes(Canvas cc)
	{
		for(int i=0;i<explodeList.size();i++)
		{
			explodeList.get(i).DrawSelf(cc);
		}
	}
	
	public void IsDestroyed()
	{
		for(int i=0;i<explodeList.size();i++)
		{
			if(explodeList.get(i).IsExist=false)
			{
				explodeList.remove(i);
			}
		}
	}
	
	public void ExplodeRuntime(Canvas cc)
	{
		this.IsDestroyed();
		this.DrawAllExplodes(cc);
	}
	
	
	

}
