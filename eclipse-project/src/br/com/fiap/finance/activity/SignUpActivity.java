package br.com.fiap.finance.activity;

import br.com.fiap.finance.exception.UserSCNException;
import br.com.fiap.finance.model.UserVO;
import br.com.fiap.finance.services.SCN.UserSCN;

import com.example.financeproj.R;
import com.example.financeproj.R.id;
import com.example.financeproj.R.layout;
import com.example.financeproj.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends ActionBarActivity {

	
	private Button btnSignUp;
	private Button btnCancelSignUp;
	
	private EditText etUserName;
	private EditText etLogin;
	private EditText etPassword;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		
		btnSignUp = (Button) findViewById(R.id.btnSignUp);
		btnCancelSignUp = (Button) findViewById(R.id.btnCancelSignUp);
		
		etUserName = (EditText) findViewById(R.id.etSignUpUserName);
		etLogin = (EditText) findViewById(R.id.etSignUpLogin);
		etPassword = (EditText) findViewById(R.id.etSignUpPassword);
		
		btnSignUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Chama responsavel por validação
				
				
				UserVO vo = new UserVO();
				vo.setUserName(etUserName.getText().toString());
				vo.setLogin(etLogin.getText().toString());
				vo.setPassword(etPassword.getText().toString());
				
				UserSCN scn = new UserSCN(getApplicationContext());
				try {	
					scn.saveUser(vo);
				} catch (UserSCNException e) {
					showToast("Cadastro não efetuado");
				}
				
				Intent i = new Intent(SignUpActivity.this, MainActivity.class);
				startActivity(i);
			}
		});
		
		btnCancelSignUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	protected void showToast(String string) {
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

	}

}
