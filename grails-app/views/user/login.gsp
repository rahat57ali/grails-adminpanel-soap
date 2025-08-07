<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
    <h2>Login</h2>
    <g:form action="authenticate" controller="user" method="post">
        <label>Email:</label>
        <g:textField name="email" /><br/>
        <label>Password:</label>
        <g:passwordField name="password" /><br/>
        <g:submitButton name="Login" value="Login"/>
    </g:form>
    <g:if test="${flash.message}">
        <p style="color:red;">${flash.message}</p>
    </g:if>
</body>
</html>
