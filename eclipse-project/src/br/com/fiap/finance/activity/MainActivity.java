package br.com.fiap.finance.activity;

import com.example.financeproj.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button btnCalendar;
	private Button btnBackup;
	private Button btnCategories;
	private Button btnFinances;
	private Button btnGraphics;
	private Button btnDeleteData;
	private Button btnInformations;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		btnCalendar = (Button) findViewById(R.id.btnCalendar);
		btnBackup = (Button) findViewById(R.id.btnBackup);
		btnCategories = (Button) findViewById(R.id.btnCategories);
		btnFinances = (Button) findViewById(R.id.btnFinances);
		btnGraphics = (Button) findViewById(R.id.btnGraphics);
		btnDeleteData = (Button) findViewById(R.id.btnDeleteData);
		btnInformations = (Button) findViewById(R.id.btnInformations);
		
		btnCalendar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent i = new Intent(MainActivity.this, CalendarActivity.class);
				 startActivity(i);
			}
		});
		
		btnBackup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Intent i = new Intent(MainActivity.this, BackupActivity.class);
				//startActivity(i);
			}
		});
		
		btnCategories.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Intent i = new Intent(MainActivity.this, CategoriesActivity.class);
				//startActivity(i);
			}
		});
		
		btnFinances.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Intent i = new Intent(MainActivity.this, FinancesActivity.class);
				//startActivity(i);
			}
		});
		
		btnGraphics.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Intent i = new Intent(MainActivity.this, GraphicsActivity.class);
				//startActivity(i);
			}
		});
		
		btnDeleteData.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//DO STUFF
			}
		});
		
		btnInformations.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//DO STUFF 2
			}
		});
		
	}

}
