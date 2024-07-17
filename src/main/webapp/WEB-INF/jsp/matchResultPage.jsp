<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Таблица результатов</title>
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
    <h1>Таблица результатов</h1>
    <table>
        <tr>
            <th colspan="3">Сыгранные сеты</th>
            <th>Имена игроков</th>
            <th>Сеты</th>
            <th>Геймы</th>
        </tr>
        <tr>
            <td><%= request.getAttribute("firstPlayerFirstSet") %></td>
            <td><%= request.getAttribute("firstPlayerSecondSet") %></td>
            <td><%= request.getAttribute("firstPlayerThirdSet") %></td>
            <td><%= request.getAttribute("firstPlayerName") %></td>
            <td><%= request.getAttribute("firstPlayerSets") %></td>
            <td><%= request.getAttribute("firstPlayerWinSets") %></td>
        </tr>
        <tr>
            <td><%= request.getAttribute("secondPlayerFirstSet") %></td>
            <td><%= request.getAttribute("secondPlayerSecondSet") %></td>
            <td><%= request.getAttribute("secondPlayerThirdSet") %></td>
            <td><%= request.getAttribute("secondPlayerName") %></td>
            <td><%= request.getAttribute("secondPlayerSets") %></td>
            <td><%= request.getAttribute("secondPlayerWinSets") %></td>
        </tr>
    </table>
</body>
</html>

