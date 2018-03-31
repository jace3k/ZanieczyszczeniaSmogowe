<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title></title>
</head>

<body>
<div class="content centered">
    <g:form action="login">
        <fieldset>
            <legend>Zaloguj się</legend>

            <label>Login</label><br />
            <g:textField name="username" /><br />

            <label>Hasło</label><br />
            <g:passwordField name="password" /><br /><br />

            <g:submitButton name="submit" value="Zaloguj" />
        </fieldset>

    </g:form>
</div>
</body>
</html>