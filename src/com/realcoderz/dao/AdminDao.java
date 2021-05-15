package com.realcoderz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.realcoderz.db.DB;

public class AdminDao {

	public boolean validate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from  Adminlogin where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(SQLException ex){System.out.println(ex);System.out.println("user name password wrong exception");}
		return status;
	}
}
