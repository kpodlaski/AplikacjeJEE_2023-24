<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dao" class="applogic.jpa.dao.DAOImpl" scope ="application"/>

<jsp:useBean id="dao" class="applogic.jdbc.dao.DAOImpl" scope="application">
    <jsp:setProperty name="dao" property="connectionString"
                     value="jdbc:postgresql://172.17.0.2/postgres" />
    <jsp:setProperty name="dao" property="user"
                     value="postgres" />
    <jsp:setProperty name="dao" property="passwd"
                     value="postgres" />
</jsp:useBean>

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
<c:set var="position" value="${dao.getPositionById(1)}" />
${position.id} ${position.name}

</body>
</html>