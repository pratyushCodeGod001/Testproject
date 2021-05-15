package com.realcoderz.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.realcoderz.beans.AccountantBean;
import com.realcoderz.dao.AccountantDao;
import com.realcoderz.db.DB;

public class AccountantService {
	private static AccountantDao ad = new AccountantDao();
public int save(AccountantBean bean){
	int status=0;
	
	status = ad.save(bean);
		
	return status;
}

public boolean Check(String email){
	boolean status=false;
	status = ad.Check(email);
	return status;
}
public boolean validate(String email,String password){
	boolean status=false;
	status = ad.validate(email,password);
	return status;
}
public int update(AccountantBean bean){
	int status=0;
	status = ad.update(bean);
	return status;
}	

public int delete(int id){
	int status=0;
	status = ad.delete(id);
	return status;
}

public List<AccountantBean> getAllRecords(){
	List<AccountantBean> list=new ArrayList<AccountantBean>();
	list =ad.getAllRecords();
	return list;
}

public AccountantBean getRecordById(int id){
	AccountantBean bean=new AccountantBean();
	bean=ad.getRecordById(id);
	
	return bean;
}
public int getId(String email,String password) {
	int id=0;
	id =ad.getId(email, password);
		return id;
}
}
