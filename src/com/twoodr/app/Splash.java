package com.twoodr.app;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {
	MediaPlayer bgsong;
	@Override
	protected void onCreate(Bundle TwoodrStart) {
		super.onCreate(TwoodrStart);
		
		bgsong = MediaPlayer.create(Splash.this, R.raw.startup);
		bgsong.start();
		setContentView(R.layout.activity_splash);
		Thread timer = new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					sleep(5000);
					
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					
					Intent menu = new Intent("com.twoodr.app.MENU");
					startActivity(menu);
				}
				
			}
			
		};
		timer.start();
			
	}
      
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		bgsong.stop();
		finish();
	}

	

}
