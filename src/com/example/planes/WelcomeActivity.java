package com.example.planes;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class WelcomeActivity extends Activity{
	
	ImageView welcome1=null;
	MediaPlayer music=null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.welcome);
    	welcome1=(ImageView)this.findViewById(R.id.welcomeani);
    	AlphaAnimation anima=new AlphaAnimation(0.05f,1f);
    	anima.setDuration(6000);
    	welcome1.startAnimation(anima);
    	anima.setAnimationListener(new AniListener());
    	music=MediaPlayer.create(this,R.raw.bg_logobg);
    	music.start();
    	
    	
    }
    
    @Override
    public void onDestroy()
    {
    	super.onDestroy();
    	music.release();
    }
    
    private class AniListener implements AnimationListener
    {

		@Override
		public void onAnimationEnd(Animation arg0) {
			// TODO Auto-generated method stub
		    skip();
			
		}

		@Override
		public void onAnimationRepeat(Animation arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAnimationStart(Animation arg0) {
			// TODO Auto-generated method stub
			welcome1.setBackgroundResource(R.drawable.phoenix);
			
			
		}
    	
    }
    
    public void skip()
    {
    	music.stop();
    	Intent intent=new Intent(WelcomeActivity.this,MenuActivity.class);
    	WelcomeActivity.this.startActivity(intent);
    	WelcomeActivity.this.finish();
    }
    
    
    
}
