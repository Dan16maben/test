package com.dan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.database.DatabaseCon;

public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger log = Logger.getLogger(Balance.class);
		PrintWriter out = response.getWriter();
		int accountno = Integer.parseInt(request.getParameter("accountno"));
		try {

			DatabaseCon cn = new DatabaseCon();
			Connection con = cn.DConnect();
			String query="select * from saving where accountno=?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, accountno);
			ResultSet rs1 = ps.executeQuery();

			if (rs1.next()) {	
				int i = ps.executeUpdate();
				if (i != 0) {
					request.setAttribute("accountno", accountno);
					
					RequestDispatcher rd = request.getRequestDispatcher("DisplayBal.jsp");
					rd.forward(request, response);
				} else {
					
					out.println("wrong");
					log.info("Error");
				}

			}

		} catch (Exception e) {
			log.warn("Exception");
		}
	}
}
