package br.com.fiap.finance.services.SCN;

import android.content.Context;
import br.com.fiap.finance.dao.UserDAO;
import br.com.fiap.finance.exception.UserSCNException;
import br.com.fiap.finance.model.UserVO;

public class UserSCN {
	
	private Context context;
	
	public UserSCN (){
		
	}
	
	public UserSCN(Context context){
		this.context = context;
	}
	
	public void saveUser(UserVO vo) throws UserSCNException{
		try{
			UserDAO dao = new UserDAO(context);
			long insert = dao.insert(vo);
		}catch(Exception e){
			throw new UserSCNException( );
		}
	}

}
