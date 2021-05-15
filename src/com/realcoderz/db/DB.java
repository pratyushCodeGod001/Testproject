package com.realcoderz.db;
import java.sql.Connection;
import java.sql.DriverManager;
public class DB {
public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Result","root","system");
	  System.out.println("Connection Created");
	}catch(Exception ex){System.out.println(ex);}
	return con;
}
 public static void main(String[] args) {
	getCon();
}
}
