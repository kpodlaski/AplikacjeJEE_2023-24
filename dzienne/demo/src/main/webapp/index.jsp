<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dom" class="com.example.demo.House" scope="request" ></jsp:useBean>
<jsp:useBean id="company" class="applogic.model.Company" scope="application"/>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%
    String s = "AL ma kota ";
    for (int i=0; i<3; i++){
        out.write(s + i);
        out.write("<br/>");
    }
%>
${dom.address = "pomorska 15"}
<br/><b> ${dom} </b>
<c:forEach var = "i" begin = "1" end = "5">
Item <c:out value = "${i} ${dom.address}"/><p>
    </c:forEach>
    <br/>

<c:forEach var="dep" items="${company.departments}">
    <h2>${dep.name}</h2> <br/>
    <c:forEach var="per" items="${dep.personel}">
        <h3> ${per.name} ${per.surname} ${per.position.name}</h3>
    </c:forEach>
</c:forEach>
</body>
</html>