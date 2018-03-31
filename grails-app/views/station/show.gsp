<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>

<body>
<g:if test="${station_properties}">
    ${station_properties}
    <br/>
    <g:link class="btn btn-block bg-info" action="index">Back</g:link>
</g:if>
</body>
</html>