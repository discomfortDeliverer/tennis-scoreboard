<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Результаты поиска матчей</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Результаты поиска матчей</h1>
    <table>
        <tr>
            <th>Матч id</th>
            <th>Первый игрок</th>
            <th>Второй игрок</th>
            <th>Победитель</th>
        </tr>
        <c:forEach var="match" items="${matches}">
            <tr>
                <td>${match.id}</td>
                <td>${match.firstPlayer.name}</td>
                <td>${match.secondPlayer.name}</td>
                <td>${match.winner.name}</td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <c:if test="${currentPage > 1}">
            <a href="/tennis-scoreboard/matches?filter_by_player_name=${param.filter_by_player_name}&page=${currentPage - 1}&size=${pageSize}">Предыдущая</a>
        </c:if>
        <c:if test="${matches.size() == pageSize}">
            <a href="/tennis-scoreboard/matches?filter_by_player_name=${param.filter_by_player_name}&page=${currentPage + 1}&size=${pageSize}">Следующая</a>
        </c:if>
    </div>
    <div>
        <form action="/tennis-scoreboard/" method="get">
            <button type="submit">Вернуться на главную страницу</button>
        </form>
    </div>
</body>
</html>