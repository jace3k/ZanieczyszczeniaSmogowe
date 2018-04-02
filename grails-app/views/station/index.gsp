<%--
  Created by IntelliJ IDEA.
  User: Jacek
  Date: 21.03.2018
  Time: 18:51
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>

<body>

<div class="content">
    <h1>Stacje</h1>
    <g:if test="${stationList}">

        <div class="list-group">
            <g:each in="${stationList}" var="station" status="item">

                    <g:link action='show' class="list-group-item list-group-item-action" id="${station.stationId}">${station.stationName}</g:link>

            </g:each>
        </div>
    </g:if>
    <g:else>
        <p></p>
    </g:else>
</div>
    <br />
    <br />
</body>
</html>