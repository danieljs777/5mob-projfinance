package br.com.fiap.finance.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.fiap.finance.model.TransactionVO;

//import br.com.fiap.finance.model.TransactionVO;

import android.content.Context;
import android.util.Log;

public class Utility {
	public static ArrayList<TransactionVO> transactions = new ArrayList<>();

	public static ArrayList<TransactionVO> readCalendarEvent(Context context) {

		TransactionVO transactionVO = new TransactionVO();

		transactionVO.setDescription("Compra no Walmart");
		transactionVO.setTranDate("02/11/2014");
		
		transactions.clear();

		transactions.add(transactionVO);

		return transactions;
	}

	public static String getDate(long milliSeconds) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		Log.d("Data: ", formatter.format(calendar.getTime()));
		return formatter.format(calendar.getTime());
	}
}
