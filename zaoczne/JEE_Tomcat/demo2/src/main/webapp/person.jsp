<%@ page import="applogic.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="co" class="applogic.Company" scope="application"/>
<html>
<%  String name = request.getParameterMap().get("id")[0];
    int id = Integer.parseInt(name);
    Person person = co.findPersonById(id);
    pageContext.setAttribute("person", person);

%>
<head>
    <title>${person.name} ${person.surname}</title>
</head>
<body>

    <table>
        <tr><td>${person.name}</td></tr>
        <tr><td>${person.surname}</td></tr>
        <tr><td>${person.position.name}</td></tr>
        <tr><td>Dep: <a href="department.jsp?id=${person.position.department.id}"> ${person.position.department.name}</a></td></tr>
    </table>
</body>
</html>
