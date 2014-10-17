package br.com.fiap.finance.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//import br.com.fiap.finance.model.TransactionVO;

import android.content.Context;
import android.util.Log;

public class Utility {
	public static ArrayList<String> nameOfEvent = new ArrayList<String>();
	public static ArrayList<String> startDates = new ArrayList<String>();
	public static ArrayList<String> descriptions = new ArrayList<String>();

	public static ArrayList<String> readCalendarEvent(Context context) {
		
		//TransactionVO transactionVO = new TransactionVO();
		
		nameOfEvent.clear();
		startDates.clear();
		descriptions.clear();

			nameOfEvent.add("Teste1");
			startDates.add(getDate(1413343207264l));
			descriptions.add("teste");

		
		return nameOfEvent;
	}

	public static String getDate(long milliSeconds) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		Log.d("Data: ", formatter.format(calendar.getTime()));
		return formatter.format(calendar.getTime());
	}
}
