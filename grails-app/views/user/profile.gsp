<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main" />
</head>

<body>
    <div class="content">
        <h1>Witaj ${session.user.firstName}, to twój profil. Twoje miasto: ${session.user.getLocalization()}</h1>

        <div class="jumbotron">Witaj na swoim profilu!</div>
        <g:if test="${stations}">
        <div>
            Lista ulubionych stacji:
            <br />
            <div class="list-group">
            <g:each in="${stations}" var="station">
                <div class="list-group-item list-group-item-action">
                    <g:link action='show' controller="station" id="${station.stationId}">${station.stationName}</g:link>
                    <g:link controller="user" action="remFavorites" id="${station.stationId}"><button class="btn btn-outline-secondary">-</button></g:link>
                </div>
            </g:each>
            </div>
        </div>
        </g:if>
    </div>
</body>
</html>