<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
    <%
        for (int a = 5; a<10; a++){
            out.println("<b>" + a +"</b>");
        }
    %>
</h1>
<br/>
<a href="/hello-servlet">Hello Servlet</a>
</body>
</html>