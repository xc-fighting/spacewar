package com.example.planes;

import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class MusicEffects {
	
    private Context context;
	public static SoundPool shots=new SoundPool(10,AudioManager.STREAM_SYSTEM,5);
	
	@SuppressLint("UseSparseArrays")
	public static HashMap<Integer,Integer> soundMap=new HashMap<Integer,Integer>();
	
	public MusicEffects(Context c)
	{
		this.context=c;
	}
	public  void init_sounds()
	{
		soundMap.put(1, shots.load(context,R.raw.button_press,1));
		soundMap.put(2, shots.load(context,R.raw.button_press2,1));
		soundMap.put(3,shots.load(context, R.raw.pengzhuang,1));
		soundMap.put(4,shots.load(context,R.raw.explode,1));
		
	}

}
