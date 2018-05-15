<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Zanieczyszczenia"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>
    <nav class="navbar navbar-expand-md navbar-dark navbar-static-top bg-dark">
        <g:link controller="main" action="index"><div class="navbar-brand">Zanieczyszczenia</div></g:link>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><g:link class="nav-link" controller="main" action="about">O nas</g:link></li>
                <g:if test="${!session?.user}">
                    <li class="nav-item" ><g:link class="nav-link" controller="user" action="register">Utwórz konto</g:link></li>
                    <li class="nav-item"><g:link class="nav-link" controller="user" action="login">Zaloguj</g:link></li>
                </g:if>
                <g:else>
                    <li class="nav-item"><g:link class="nav-link" controller="user" action="profile">Lista ulubionych</g:link></li>
                    <li class="nav-item"><g:link class="nav-link" controller="station">Wyszukiwarka</g:link></li>
                    <li class="nav-item"><g:link class="nav-link" controller="user" action="logout">Wyloguj</g:link></li>
                </g:else>
            </ul>
        </div>
    </nav>

    <div>
        <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>
</div>

    <g:layoutBody/>

    <footer class="footer" role="contentinfo">
        <div class="container">
            TI! Apka webowa stworzona na potrzeby edukacyjne.
        </div>
    </footer>

    <asset:javascript src="application.js"/>

</body>
</html>
