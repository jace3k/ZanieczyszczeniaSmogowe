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

    <g:if test="${data}">
        <h1>Stacje</h1>
        <ul class="list-group">
            <g:each in="${data}" var="station" status="item">
                <li class="list-group-item">
                    <div>
                    <g:link action='show' id="${station.id}" class="btn btn-default">${station.stationName}</g:link>
                    </div>
                </li>
            </g:each>
        </ul>
    </g:if>
</div>
    <br />
    <br />
</body>
</html>