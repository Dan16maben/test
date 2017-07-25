package com.dan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.database.DatabaseCon;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger log = Logger.getLogger(Register.class);
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		try {

			DatabaseCon cn = new DatabaseCon();
			Connection con = cn.DConnect();
			/*DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			Date lastaccess = new Date(request.getSession(false).getLastAccessedTime());*/
			 Calendar calendar = Calendar.getInstance();
			    java.sql.Timestamp lastaccess = new java.sql.Timestamp(calendar.getTime().getTime());
			    String query="insert into register values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, cpassword);
			ps.setTimestamp(6, lastaccess);
			int i = ps.executeUpdate();
			if (i > 0) {
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				rd.forward(request, response);
				log.info(query);
			}

		} catch (Exception e) {
			log.error("Error");
		}
	}
}
