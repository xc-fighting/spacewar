package com.example.planes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends Activity{
	
	TextView jisha,shengming;
	Button backs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.win);
		jisha=(TextView)this.findViewById(R.id.jisha);
		shengming=(TextView)this.findViewById(R.id.shengyu);
		this.setParamaters();
		 MusicEffects musics=new MusicEffects(this);
		 musics.init_sounds();
		backs=(Button)this.findViewById(R.id.backto);
		backs.setOnClickListener(new press());
		
	}
	
	private class press implements OnClickListener
	{

		@Override
		public void onClick(View arg0) {
			MusicEffects.shots.play(MusicEffects.soundMap.get(2),1,1,0,0,1);
			Intent intent =new Intent();
			intent.setClass(WinActivity.this,MenuActivity.class);
			WinActivity.this.startActivity(intent);
			WinActivity.this.finish();
			
		}
		
	}
	public void setParamaters()
	{
		jisha.setText(MainGameThread.beat_num+"");
		shengming.setText(PlayerManager.player.lifes+"");
	}


}
