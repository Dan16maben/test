<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body{
text-align:center;
}
p{
width:300;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>BALANCE IN YOUR ACCOUNT!!!</h1>
	<%@ page import="java.sql.*"%>

	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");
	%>
	<H1>your details are :</H1>
	<%
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system",
				"system");

		Statement statement = connection.createStatement();
		int accountno = (int) request.getAttribute("accountno");
		out.print("accnnumber is" + accountno);

		ResultSet resultset = statement.executeQuery("select * from saving where accountno=" + accountno);
	%>
	<center>
	<TABLE BORDER="1">
	
		<TR>
			<TH>name</TH>
			<TH>amount</TH>
			<TH>accountype</TH>
			<TH>accountno</TH>
		</TR>
		<%
			if (resultset.next()) {
		%>
		<TR>
			<TD><%=resultset.getString(1)%></td>
			<TD><%=resultset.getString(2)%></TD>
			<TD><%=resultset.getString(3)%></TD>
			<TD><%=resultset.getString(4)%></TD>
		</TR>
		<%
			}
		%>
	</TABLE>
	</center>
	<br><br>
	<center>
			<a href="Welcome.jsp">Click Here for Further Transaction!!!</a></center>
</body>
</html>