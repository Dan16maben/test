package com.dan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.database.DatabaseCon;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger log = Logger.getLogger(Logout.class);
		PrintWriter out = response.getWriter();
		try {

			DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			DatabaseCon cn = new DatabaseCon();
			Connection con = cn.DConnect();
			HttpSession session = request.getSession();
			Calendar calendar = Calendar.getInstance();
			java.sql.Timestamp lastaccess = new java.sql.Timestamp(calendar.getTime().getTime());
			String fname = (String) session.getAttribute("name");
			String query = "update register set lastaccess=? where fname=?";
			PreparedStatement ps1 = con.prepareStatement(query);
			ps1.setTimestamp(1, lastaccess);
			ps1.setString(2, fname);
			int j = ps1.executeUpdate();
			if (j > 0) {
				long logintime = (long) request.getSession(false).getAttribute("time");
				long logouttime = System.currentTimeMillis();
				long totaltime = logouttime - logintime;
				Date lastAccessed = new Date(request.getSession(false).getLastAccessedTime());
				session.setAttribute("time1", formatter.format(lastAccessed));

				out.println("<br>last accessed" + formatter.format(lastAccessed));

				out.println("<br><br>totaltime user spend " + String.format("%d min, %d sec",
						TimeUnit.MILLISECONDS.toMinutes(totaltime), TimeUnit.MILLISECONDS.toSeconds(totaltime)
								- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totaltime))));
				log.info(query);
				String user = (String) request.getSession(false).getAttribute("user");
				String userName = null;
				String sessionID = null;
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("name"))
							userName = cookie.getValue();
						if (cookie.getName().equals("JSESSIONID"))
							sessionID = cookie.getValue();
					}

				}
				log.info("Database Discconnected");
				out.println("<br><br><a href=Login.jsp>Click here to Login!!!</a>");
			}
		} catch (Exception e) {
			out.println(e);
		}
	}
}
