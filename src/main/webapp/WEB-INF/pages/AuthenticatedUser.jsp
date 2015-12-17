<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>authenticated user</title>
</head>
<body>


<sec:authorize access="hasRole('ROLE_ADMIN')">

THIS TAB IS VISIBLE ONLY TO THE ADMIN
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">

THIS TAB IS VISIBLE ONLY TO THE USER
</sec:authorize>

<h2>Welcome user!!only authenticated user can see this page</h2>
<a href="<c:url value='/j_spring_security_logout'/>">Logout</a>	
</body>
</html>