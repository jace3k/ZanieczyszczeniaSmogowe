<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title></title>
</head>

<body>
<div class="content">
    <g:form controller="user" action="register" method="post" name="register">
        <fieldset>
            <legend>Zarejestruj się</legend>

            <label>Imię</label><br />
            <g:textField name="firstName" /><br />

            <label>Login</label><br />
            <g:textField name="username" /><br />

            <label>Hasło</label><br />
            <g:passwordField name="password" /><br /><br />

            <g:submitButton name="submit" value="Utwórz konto" />
        </fieldset>
    </g:form>
</div>

</body>
</html>