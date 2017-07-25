package com.dan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.database.DatabaseCon;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 Logger log = Logger.getLogger(Login.class);
		String fname = request.getParameter("fname");
		String password = request.getParameter("password");

		try {
			
			DatabaseCon cn = new DatabaseCon();
			Connection con = cn.DConnect();
			HttpSession session = request.getSession();
			PreparedStatement ps = con.prepareStatement("select fname,password,lastaccess from register where fname=? and password=?");
			ps.setString(1, fname);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				java.sql.Timestamp lastaccess = rs.getTimestamp("lastaccess");
				session.setAttribute("lastaccess", lastaccess);
				Cookie ck = new Cookie("<br>danson", fname);
				response.addCookie(ck);
				session.setAttribute("name", fname);
				long logintime = System.currentTimeMillis();
				session.setAttribute("time", logintime);
				response.setHeader("Refresh", "120;url=Expire.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
				rd.forward(request, response);
				log.info("Successfully logged in..");
			} else {
				log.error("Error..");
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {

		}
	}
}