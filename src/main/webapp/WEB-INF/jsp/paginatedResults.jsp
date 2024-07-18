<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Результаты поиска матчей</title>
    <style>
        h1 {
            font-family: 'Arial', sans-serif;
            font-size: 50px;
            color: #66fdee;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #202833;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #202833;
        }
        th, td {
            border: 1px solid #66fdee;
            padding: 8px;
            text-align: center;
            font-size: 24px;
            font-family: 'Arial', sans-serif;
            color: #66fdee;
        }
        th {
            background-color: #334052;
        }
        button {
            padding: 10px 25px;
            background-color: transparent;
            border: 2px solid #66fdee;
            color: #66fdee;
            cursor: pointer;
            border-radius: 10px;
            font-size: 1.7em;
        }
        button:hover {
            background-color: #45a29f;
        }
        /* Стили для ссылок Предыдущая и Следующая */
        .pagination-link {
            color: #c5c6c8; /* Цвет ссылки */
            font-size: 20px; /* Размер текста ссылки */
            text-decoration: none; /* Убираем подчеркивание */
            margin: 0 10px; /* Отступы справа и слева */
        }
        .pagination-link:hover {
            color: #66fcf1; /* Цвет при наведении */
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
            <a href="/tennis-scoreboard/matches?filter_by_player_name=${param.filter_by_player_name}&page=${currentPage - 1}&size=${pageSize}" class="pagination-link">Предыдущая страница</a>
        </c:if>
        <c:if test="${matches.size() == pageSize}">
            <a href="/tennis-scoreboard/matches?filter_by_player_name=${param.filter_by_player_name}&page=${currentPage + 1}&size=${pageSize}" class="pagination-link">Следующая страница</a>
        </c:if>
    </div>
    <div>
        <form action="/tennis-scoreboard/" method="get">
            <button type="submit">Вернуться на главную страницу</button>
        </form>
    </div>
</body>
</html>
