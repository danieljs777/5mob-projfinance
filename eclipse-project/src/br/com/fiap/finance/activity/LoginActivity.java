package br.com.fiap.finance.activity;

import com.example.financeproj.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity {

	private Button btnLogin;
	private Button btnSignUpForward;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnSignUpForward = (Button) findViewById(R.id.btnSignUpForward);
		
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				attemptLogin();
			}
		});
		
		btnSignUpForward.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
				startActivity(i);
			}
		});
	}
	
	private void attemptLogin(){
		
		//Codigo para realização do login
		
		Intent i =  new Intent(LoginActivity.this, MainActivity.class);
		startActivity(i);
	}

}
