package com.example.planes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FailActivity extends Activity{
	
	private static final String TAG="my activity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fail);
		Button btn=(Button)this.findViewById(R.id.back);
		btn.setOnClickListener(new pressbtn());
		MusicEffects musics=new MusicEffects(this);
		musics.init_sounds();
		Toast.makeText(FailActivity.this,"”Œœ∑Ω· ¯" ,Toast.LENGTH_SHORT).show();
		Log.v(TAG, "oncreate");
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
	}
	@Override
	protected void onPause()
	{
		super.onPause();
	}
	@Override
	protected void onResume()
	{
		super.onResume();
	}
	@Override
	protected void onStart()
	{
		super.onStart();
	}
	
	
	
	private class pressbtn implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MusicEffects.shots.play(MusicEffects.soundMap.get(1),1,1,0,0,1);
			Intent intent=new Intent(FailActivity.this,MenuActivity.class);
			FailActivity.this.startActivity(intent);
			FailActivity.this.finish();
			
		}
		
	}
	
}
