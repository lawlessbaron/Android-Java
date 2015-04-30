package com.gamerzcolony.essentials;

import com.gamerzcolony.essentials.currency.CurrencyConverterActivity;
import com.gamerzcolony.essentials.notepad.NoteList;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {


	@SuppressLint("CutPasteId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);	

		//diables landscape
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
		getRequestedOrientation();

		Button n = (Button) findViewById(R.id.buttoncomp);
		Button con = (Button) findViewById(R.id.buttonconvert);
		Button wea = (Button) findViewById(R.id.buttonweather);
		Button cur = (Button) findViewById(R.id.buttoncurrency);
		Button note = (Button) findViewById(R.id.buttonnote);

		//Typeface Button Font
		Typeface typeface = Typeface.createFromAsset(getAssets(), "CODEBold.otf");
		wea.setTypeface(typeface);
		n.setTypeface(typeface);
		cur.setTypeface(typeface);
		con.setTypeface(typeface);
		note.setTypeface(typeface);



		/////////////////////////////////
		//  	BUTTON FONT END
		/////////////////////////////////

		//Compass Button
		final Button next1 = (Button) findViewById(R.id.buttoncomp);
		next1.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(), Compass.class); //Open the forums webView class
				startActivityForResult(myIntent, 0);
			}
		});

		//Unit Converter Button
		Button next2 = (Button) findViewById(R.id.buttonconvert);
		next2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(), UnitConverter.class); //Open the forums webView class
				startActivityForResult(myIntent, 0);
			}
		});

		//Currency Converter
		final Button next3 = (Button) findViewById(R.id.buttoncurrency);
		next3.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(), CurrencyConverterActivity.class); //Open the forums webView class
				startActivityForResult(myIntent, 0);
			}
		});

		//Weather App
		final Button next4 = (Button) findViewById(R.id.buttonweather);
		next4.setOnClickListener(new View.OnClickListener() {


			public void onClick(View view) {

				//Intent myIntent = new Intent(view.getContext(), MainWeather.class);
				//Toast.makeText(getApplicationContext(), R.string.notavail, Toast.LENGTH_LONG).show();
				//next4.setEnabled(false);
				//startActivityForResult(myIntent, 0);
			}
		});

		//Notepad
		final Button next5 = (Button) findViewById(R.id.buttonnote);
		next5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(), NoteList.class); //Open the forums webView class
				//Toast.makeText(getApplicationContext(), R.string.notavail, Toast.LENGTH_LONG).show();
				//next4.setEnabled(false);
				startActivityForResult(myIntent, 0);

			}
		});

	}

	private static long back_pressed;

	@Override
	public void onBackPressed()
	{
		if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
		else Toast.makeText(getBaseContext(), "Press Again to Exit!", Toast.LENGTH_SHORT).show();
		back_pressed = System.currentTimeMillis();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
