package com.example.planes;

import android.graphics.Bitmap;

/*
 * 
 * 常量类保存所有图片资源的索引
 * 
 * */

public class ConstantUtil {
    public static int[] id_bullet={R.drawable.bullet1,R.drawable.bullet2,R.drawable.bullet3,R.drawable.bullet4};
    public static int[] id_background={R.drawable.background1,R.drawable.background2,R.drawable.background3,R.drawable.background4};
    public static int[] id_explode={R.drawable.explode1,R.drawable.explode2,R.drawable.explode3,R.drawable.explode4,R.drawable.explode5
    	,R.drawable.explode6,R.drawable.explode7,R.drawable.explode8,R.drawable.explode9,R.drawable.explode10,R.drawable.explode11,
    	R.drawable.explode12,R.drawable.explode13,R.drawable.explode14,R.drawable.explode15,R.drawable.explode16};
    public static int[] id_player={R.drawable.player,R.drawable.player2};
    public static int[] id_enemy={R.drawable.enemy1,R.drawable.enemy2,R.drawable.enemy3,R.drawable.enemy4};
    
    public static Bitmap[] bullet_pic=new Bitmap[4];
    public static Bitmap[] background_pic=new Bitmap[4];
    public static Bitmap[] explode_pic=new Bitmap[16];
    public static Bitmap[] player_pic=new Bitmap[2];
    public static Bitmap[] enemy_pic=new Bitmap[4];
    
    
    public static int hurt_bullet=1;//子弹伤害
    public static int hurt_collision=1;//碰撞伤害
    public static int speed_bullet=10;//子弹速度为10
    
    public static int NumOfBullet=4;
    public static int NumOfPlayer=2;
    public static int NumOfBackground=4;
    public static int NumOfExplode=16;
    public static int NumOfEnemy=4;
    
    
}
