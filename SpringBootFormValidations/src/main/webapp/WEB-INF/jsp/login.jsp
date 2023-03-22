<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <style type="text/css">
        .error{
            color: red;
        }
    </style>
</head>
<body>
<form:form action="usersubmit" method="post" modelAttribute="user">
    <%--    <h1>LOGIN PAGE</h1>--%>
    <%--    Enter Username: <input type="text" name="username">--%>
    <%--    Enter Password:<input type="password" name="password">--%>
    <%--    <input type="submit" value="login">--%>
    <div>
        Enter Username: <form:input type="text" path="userName"/>
        <form:errors path="userName" cssClass="error">
        </form:errors>
    </div>
    Enter Password:<form:input type="password" path="password"/>
    <form:errors path="password" cssClass="error"></form:errors>
    <br>
    <input type="submit" value="Login">
</form:form>

<a href="error.jsp">click here go to error</a>
</body>
</html>