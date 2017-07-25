package com.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DatabaseCon {
public  Connection DConnect()
 {
	 Logger log = Logger.getLogger(DatabaseCon.class);
  Connection con=null;
  try{
 Class.forName("oracle.jdbc.driver.OracleDriver");
  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
  log.info("Database logged in..");
  }
  catch(ClassNotFoundException | SQLException e)
  {
	  log.error("No connection..");
   e.printStackTrace();
  }
  return con;
 }
 
}