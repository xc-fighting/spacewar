package com.example.planes;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends Activity{
	
	Button button_start,button_about,button_exit,button_paihang;
	Intent intent=null;
	 @Override
	    protected void onCreate(Bundle savedInstanceState)
	 {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.menus);
		 MusicEffects musics=new MusicEffects(this);
		 musics.init_sounds();
		 intent=new Intent();
		 intent.setAction("com.example.planes.musicservice");
		 this.startService(intent);
		 button_start=(Button)this.findViewById(R.id.startgame);button_start.setOnClickListener(new ClickListener());
		 button_about=(Button)this.findViewById(R.id.aboutgame);button_about.setOnClickListener(new ClickListener());
		 button_exit=(Button)this.findViewById(R.id.exitgame);button_exit.setOnClickListener(new ClickListener());
		 button_paihang=(Button)this.findViewById(R.id.paimingbang);button_paihang.setOnClickListener(new ClickListener());
	 }
	 
	 
	 public void Dialog1()
		{
		 final Dialog dlg=new Dialog(this);
		 dlg.show();
		 Window window=dlg.getWindow();
		 window.setContentView(R.layout.aboutgame);
		 Button back=(Button)window.findViewById(R.id.tuichu);
		 back.setOnClickListener(new OnClickListener()
		 {

			@Override
			public void onClick(View v) {
				dlg.dismiss();
				
				
			}
			 
		 });
			
		}
	 
	 
	 
	 
	 
	 private class ClickListener implements OnClickListener
	 {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MusicEffects.shots.play(MusicEffects.soundMap.get(2),1,1,0,0,1);
			switch(v.getId())
			{
				case R.id.startgame:
				{
					MenuActivity.this.stopService(intent);
					Intent intent=new Intent(MenuActivity.this,MainActivity.class);
					MenuActivity.this.startActivity(intent);
					MenuActivity.this.finish();
					
					
				}break;
				case R.id.aboutgame:
				{
					Dialog1();
				}break;
				case R.id.paimingbang:
				{
					
					Toast.makeText(MenuActivity.this,"ÉÐÎ´¿ª·¢£¬¾´ÇëÆÚ´ý",Toast.LENGTH_SHORT).show();
				}break;
				case R.id.exitgame:
				{
					MenuActivity.this.stopService(intent);
					MenuActivity.this.finish();
				}break;
			}
			
		}
		 
	 }
	 

}
