<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>

</head>

<body>
<div class="content">
    <div class="jumbotron">
        <p>Witaj na portalu do sprawdzania zanieczyszczeń powietrza i smogu!</p>
    </div>

    <div class="jumbotron">
        <g:if test="${session?.user}">
            <p>Możesz przeglądać wszystkie dostępne stacje w polsce!</p>
            <p>Zacznij od pełnego wyświetlenia listy stacji i zobacz szczegóły wybranej</p>
        </g:if>
        <g:else>
            <p>Zaloguj się do portalu aby korzystać z niego w pełni!</p>
        </g:else>
    </div>

    <div class="jumbotron">
        <p>Utwórz sobie listę ulubionych stacji w profilu!</p>
    </div>

    <div class="jumbotron">
        Pozdro!
    </div>
</div>
</body>
</html>