package br.com.fiap.finance.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.fiap.finance.dao.CategoryDAO;
import br.com.fiap.finance.dao.PaymentMethodDAO;

import android.util.Log;

public class TransactionVO {

	private int id;
	
	private String description;
	
	private int type;
	private CategoryVO typeObj;
	
	private double amount;
	
	private Date tranDate;
	
	private String tranTime;
	
	private String gpsCoordinations;
	
	private int paymentMethod;
	private PaymentMethodVO paymentObj;
	
	private String store;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
		this.typeObj = new CategoryDAO(null).getById(type);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTranDate() {
		return tranDate;
	}
	
	public String getTranDateFormatted( )
	{
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" ) ;
		return sdf.format( tranDate ) ;
	}	
		
	public void setTranDate(String tranDate) {
		
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" ) ;
		try
		{
			this.tranDate = sdf.parse( tranDate ) ;
		}
		catch (Exception e)
		{
			Log.e( "erro", e.getMessage( ) ) ;
		}
		
		
	}

	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}

	public String getGpsCoordinations() {
		return gpsCoordinations;
	}

	public void setGpsCoordinations(String gpsCoordinations) {
		this.gpsCoordinations = gpsCoordinations;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
		this.paymentObj = new PaymentMethodDAO(null).getById(paymentMethod);
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public CategoryVO getTypeObj() {
		return typeObj;
	}

	public void setTypeObj(CategoryVO typeObj) {
		this.typeObj = typeObj;
	}

	public PaymentMethodVO getPaymentObj() {
		return paymentObj;
	}

	public void setPaymentObj(PaymentMethodVO paymentObj) {
		this.paymentObj = paymentObj;
	}
	
}
