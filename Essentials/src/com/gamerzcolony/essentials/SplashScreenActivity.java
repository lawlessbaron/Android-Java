package com.gamerzcolony.essentials;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends Activity {

    private int mSplashTime = 4000;
	private Timer mTimer;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        
        mTimer = new Timer();
        mTimer.schedule(
            new TimerTask() {
            	public void run() {
    			    finish();
    	            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    	            startActivity(intent);
    			}
            },
        mSplashTime);
    }
}