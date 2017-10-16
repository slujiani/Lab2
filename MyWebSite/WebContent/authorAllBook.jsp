<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>The Results:</title>
</head>
<body>
<h1>All we can find:<br></h1>
<c:forEach items="${allBook}" var="s">
${s.title}
</c:forEach>
</body>
</html>