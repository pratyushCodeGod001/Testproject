package com.realcoderz.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.realcoderz.beans.AccountantBean;
import com.realcoderz.db.DB;

public class AccountantDao {
	
public int save(AccountantBean bean){
	int status=0;//error dopost & get

		Connection con=DB.getCon();
		PreparedStatement ps;
		try {
			
	        ps = con.prepareStatement("insert into fee_accountant(name,email,password,address,contact) values(?,?,?,?,?)");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPassword());
			ps.setString(4,bean.getAddress());
			ps.setString(5,bean.getContact());
			status=ps.executeUpdate();
			con.close();
		
		} catch (SQLException e) {
			System.out.println("Your Query Is invalid");
			e.printStackTrace();
		}
		
	return status;
}
public boolean Check(String email){
	boolean status=false;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_accountant where email=?");
		ps.setString(1,email);
		
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(SQLException ex){System.out.println(ex);
	System.out.println("Your password Is invalid");
	}
	
	return status;
}
public boolean validate(String email,String password){
	boolean status=false;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_accountant where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(SQLException ex){System.out.println(ex);
	System.out.println("Your password Is invalid");
	}
	
	return status;
}
public static int update(AccountantBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("update fee_accountant set name=?,email=?,password=?,address=?,contact=? where id=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setString(4,bean.getAddress());
		ps.setString(5,bean.getContact());
		ps.setInt(6,bean.getId());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);System.out.println("Account Updated");}
	return status;
}	

public int delete(int id){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("delete from fee_accountant where id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		
		ps=con.prepareStatement("delete from fee_student where ref_id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		con.close();
	}catch(SQLException ex){System.out.println(ex);System.out.println("Account Deleted");}
	return status;
}

public List<AccountantBean> getAllRecords(){
	List<AccountantBean> list=new ArrayList<AccountantBean>();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_accountant");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			AccountantBean bean=new AccountantBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setAddress(rs.getString(5));
			bean.setContact(rs.getString(6));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}

public AccountantBean getRecordById(int id){
	AccountantBean bean=new AccountantBean();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_accountant where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setAddress(rs.getString(5));
			bean.setContact(rs.getString(6));
		}
		con.close();
	}catch(SQLException ex){System.out.println(ex);System.out.println("sql exception Get recored");}
	
	return bean;
}
public int getId(String email,String password) {
	int id=0;
	Connection con=DB.getCon();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("select id from fee_accountant where email=? and password=?");
		ps.setString(1, email);
		ps.setString(2,password);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			id = rs.getInt(1);
	} catch (SQLException e) {System.out.println("Get id successfull");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

		return id;
}
}
