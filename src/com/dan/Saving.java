package com.dan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.database.DatabaseCon;

public class Saving extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Logger log = Logger.getLogger(Saving.class);
		String name = request.getParameter("name");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String accountype = request.getParameter("accountype");

		try {

			DatabaseCon cn = new DatabaseCon();
			Connection con = cn.DConnect();
			 Calendar calendar = Calendar.getInstance();
			    java.sql.Timestamp time = new java.sql.Timestamp(calendar.getTime().getTime());
			    String query="insert into saving values(?,?,?,accountno.nextval,?)";
			PreparedStatement ps = con.prepareStatement(query);
			String query1="select accountno from saving where name=?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps.setString(1, name);
			ps.setInt(2, amount);
			ps.setString(3, accountype);
			ps.setTimestamp(4, time);
			int i = ps.executeUpdate();
			ps1.setString(1, name);
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				int accountno = rs.getInt("accountno");
				request.setAttribute("accountno", accountno);
				request.setAttribute("amount", amount);
				String query2="insert into transaction values(?,?,?,?,?,?)";
				PreparedStatement ps2 = con.prepareStatement(query2);
				ps2.setInt(1, accountno);
				ps2.setString(2, name);
				ps2.setInt(3, 0);
				ps2.setInt(4, 0);
				ps2.setInt(5, amount);
				ps2.setTimestamp(6, time);
				int j = ps2.executeUpdate();
				if (i > 0) {
					if (j > 0) {
						RequestDispatcher rd = request.getRequestDispatcher("DisplaySav.jsp");
						rd.forward(request, response);
						log.info(query);
						log.info(query1);
						log.info(query2);
					}
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
					log.error("Error..");
				}
			}
		} catch (Exception e) {
		}
	}
}