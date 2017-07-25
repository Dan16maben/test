package com.dan;

import java.io.IOException;
import java.io.PrintWriter;
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

public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger log = Logger.getLogger(Withdraw.class);
		PrintWriter out = response.getWriter();
		int accountno = Integer.parseInt(request.getParameter("accountno"));
		int amount1 = Integer.parseInt(request.getParameter("amount1"));
		try {

			DatabaseCon cn = new DatabaseCon();
			Connection con = cn.DConnect();
			String query = "select amount,name from saving where accountno=?";
			PreparedStatement ps1 = con.prepareStatement(query);

			ps1.setInt(1, accountno);
			ResultSet rs1 = ps1.executeQuery();

			if (rs1.next()) {
				Calendar calendar = Calendar.getInstance();
				java.sql.Timestamp time = new java.sql.Timestamp(calendar.getTime().getTime());
				int amount = rs1.getInt("amount");
				amount = amount - amount1;
				String query1 = "update saving set amount=? where accountno=?";
				PreparedStatement ps = con.prepareStatement(query1);
				String query2 = "insert into transaction values(?,?,?,?,?,?)";
				PreparedStatement pstran = con.prepareStatement(query2);

				ps.setInt(1, amount);
				ps.setInt(2, accountno);
				int i = ps.executeUpdate();
				pstran.setInt(1, accountno);
				pstran.setString(2, rs1.getString("name"));
				pstran.setInt(3, 0);
				pstran.setInt(4, amount1);
				pstran.setInt(5, amount);
				pstran.setTimestamp(6, time);
				int k = pstran.executeUpdate();
				if (k > 0) {
					request.getSession(false).setAttribute("transucc", "Transacation is done successfully");
				}
				if (i != 0) {
					request.setAttribute("accountno", accountno);
					RequestDispatcher rd = request.getRequestDispatcher("DisplayWit.jsp");
					rd.forward(request, response);
					log.info(query);
					log.info(query1);
					log.info(query2);
				} else {

					out.println("wrong");
				}

			}

		} catch (Exception e) {

		}
	}
}
