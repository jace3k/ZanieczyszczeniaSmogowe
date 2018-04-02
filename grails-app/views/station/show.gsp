<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="content">
<g:if test="${stationProperties}">
    <h1>${stationName}</h1>
    <g:each in="${stationProperties}" var="sensor">
        <div class="jumbotron">Czujnik: ${sensor.id} - ${sensor.param.paramName} - ${sensor.param.paramCode} </div>
    </g:each>
</g:if>
    <g:link action="index" ><button type="button" class="btn btn-outline-dark">Back</button></g:link>
</div>
</body>
</html>