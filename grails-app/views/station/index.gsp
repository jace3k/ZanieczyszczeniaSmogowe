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
                <div class="list-group-item list-group-item-action">
                    <g:link action='show'  id="${station.stationId}">${station.stationName}</g:link>
                    <g:if test="${session?.user}">
                        <g:if test="${!session?.user?.stations?.find {it.stationId == station.stationId}}">
                            <g:link controller="user" action="addFavorites" id="${station.stationId}"><button class="btn btn-outline-primary">+</button></g:link>
                        </g:if>
                        <g:else>
                            <g:link controller="user" action="remFavorites" id="${station.stationId}"><button class="btn btn-outline-secondary">-</button></g:link>
                        </g:else>
                    </g:if>
                </div>
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