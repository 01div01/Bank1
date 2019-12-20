<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<form action="http://localhost:5001/BANKAPP/CheckBalance">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<header>
<h1 style="background-color:#37F5A1;">Login Successful</h1>
</header>

<% 
HttpSession hs=request.getSession();
String accountno=(String)hs.getAttribute("accountno");
out.println("Your Account number is" +" "+ accountno);
%>


<table>
<tr>
<td><input type="submit" value="Check Balance"></td>

</tr>
</table>

<a href="ChangePassword.jsp" role="button">Click Here To Change Password</a>


</body>
</html>