<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="content">
<g:if test="${stationProperties}">
    <h1>${stationName}
        <g:if test="${!session?.user?.stations?.find {it.stationId == stationId}}">
            <g:link controller="user" action="addFavorites" id="${stationId}"><button class="btn btn-outline-primary">+</button></g:link>
        </g:if>
        <g:else>
            <g:link controller="user" action="remFavorites" id="${stationId}"><button class="btn btn-outline-secondary">-</button></g:link>
        </g:else>
    </h1>

    <g:each in="${stationProperties}" var="sensor">
        <div class="jumbotron">Czujnik: ${sensor.id} - ${sensor.param.paramName} - ${sensor.param.paramCode} </div>
    </g:each>
</g:if>
    <g:link url="${request.getHeader('referer')}" ><button type="button" class="btn btn-outline-dark">Back</button></g:link>
</div>
</body>
</html>