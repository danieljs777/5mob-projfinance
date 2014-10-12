package br.com.fiap.finance.activity;

import br.com.fiap.controledefinancas.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity implements Runnable {
	
	private final int SPLASH_TIME = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		Handler handler = new Handler();
		handler.postDelayed(this, SPLASH_TIME);
	}

	@Override
	public void run() {
		Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
		startActivity(i);
		finish();
	}


}
