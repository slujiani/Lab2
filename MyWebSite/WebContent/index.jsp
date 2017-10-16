<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>"图书管理系统"</title>
</head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
    <form action="searchAction" method="get">
         <input type="text" name="name" placeholder="Please enter the author's name" size=30 required/>
         <input type="submit" name="searchSubmit" value="srearch">   
    </form>
   
    <sql:setDataSource 
    var="BookDB" 
    driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/BookDB?useSSL=false"
    user="root"  
    password="123456"/>
    <sql:query dataSource="${BookDB}" var="result">
        select * from book;
    </sql:query>
    
    <table border="1" >
    <tr>
    <th>isbn</th>
    <th>title</th>
    <th>authorId</th>
    <th>publisher</th>
    <th>publishTime</th>
    <th>Price</th>
    </tr>
    <c:forEach var="row" items="${result.rows }">
      <tr>
        <td><c:out value="${row.isbn}"/></td>
        <td><c:out value="${row.title}"/></td>
        <td><c:out value="${row.authorId}"/></td>
        <td><c:out value="${row.publisher }"/></td>
        <td><c:out value="${row.publishDate }"/></td>
        <td><c:out value="${row.price }"/></td>
    </c:forEach>
    </table>
</body>
</html>