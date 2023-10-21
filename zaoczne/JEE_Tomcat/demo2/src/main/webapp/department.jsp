<%@ page import="applogic.Person" %>
<%@ page import="applogic.Department" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21.10.2023
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="co" class="applogic.Company" scope="application"/>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<%  String sid = request.getParameterMap().get("id")[0];
    int id = Integer.parseInt(sid);
    Department department = co.findDepartmentById(id);
    pageContext.setAttribute("department", department);
%>
<head>
    <title>${department.name}</title>
</head>
<body>
${department.name}<br/>
Pracownicy:<br/>
<c:forEach var="person" items="${co.getPersonsInDepartment(department)}">
    <a href="person.jsp?id=${person.id}">${person.name} ${person.surname}</a><br/>
</c:forEach>

</body>
</html>
