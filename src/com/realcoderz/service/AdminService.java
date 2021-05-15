package com.realcoderz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.realcoderz.dao.AdminDao;
import com.realcoderz.db.DB;

public class AdminService {
	public boolean validate(String email,String password){
		AdminDao ad = new AdminDao();
		boolean status=false;
		status = ad.validate(email, password);
		return status;
	}
}
