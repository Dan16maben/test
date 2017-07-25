package com.dan;

import java.io.IOException;
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

public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger log = Logger.getLogger(Transaction.class);
		int accountno = Integer.parseInt(request.getParameter("accountno"));
		try {
			DatabaseCon cn = new DatabaseCon();
			Connection con = cn.DConnect();
			String query = "select * from transaction where accountno=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, accountno);
			ResultSet rs1 = ps.executeQuery();
			if (rs1.next()) {
				request.getSession().setAttribute("accountno", rs1.getInt("accountno"));
				RequestDispatcher rd = request.getRequestDispatcher("DisplayTran.jsp");
				rd.forward(request, response);
				log.info(query);
			}
		} catch (Exception e) {

		}
	}
}
