package com.realcoderz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.realcoderz.beans.StudentBean;
import com.realcoderz.dao.StudentDao;
import com.realcoderz.db.DB;

public class StudentService {
	private static StudentDao sd = new StudentDao();
public int save(StudentBean bean){
	
	int status=0;
	status = sd.save(bean);
			
	return status;
}
public int update(StudentBean bean){
	int status=0;
	status = sd.update(bean);
	return status;
}	
public int delete(int rollno){
	int status=0;
	status = sd.delete(rollno);
	return status;
}
public int deleteByName(String name){
	int status=0;
	status = sd.deleteByName(name);
	return status;
}

public List<StudentBean> getAllRecords(){
	List<StudentBean> list=new ArrayList<StudentBean>();
	list =sd.getAllRecords();
	
	return list;
}
public List<StudentBean> getDues(){
	List<StudentBean> list=new ArrayList<StudentBean>();
	list=sd.getDues();
	
	return list;
}

public StudentBean getRecordByRollno(int rollno){
	StudentBean bean=new StudentBean();
	bean = sd.getRecordByRollno(rollno);
	
	return bean;
}
}