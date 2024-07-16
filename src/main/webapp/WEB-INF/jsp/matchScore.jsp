<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Теннисный счет</title>
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
        form {
            display: inline;
        }
        button {
            margin: 5px;
        }
    </style>
</head>
<body>
    <h1>Теннисный счет</h1>
    <table>
        <thead>
            <tr>
                <th>Имена игроков</th>
                <th>Сеты</th>
                <th>Геймы</th>
                <th>Поинты</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><%= request.getAttribute("player1Name") %></td>
                <td>2</td>
                <td>6</td>
                <td>15</td>
            </tr>
            <tr>
                <td><%= request.getAttribute("player2Name") %></td>
                <td>1</td>
                <td>4</td>
                <td>30</td>
            </tr>
        </tbody>
    </table>
    <form action="/match-score?uuid=$match_id" method="post">
        <input type="hidden" name="player_id" value="1">
        <button type="submit">Игрок 1 выиграл текущее очко</button>
    </form>
    <form action="/match-score?uuid=$match_id" method="post">
        <input type="hidden" name="player_id" value="2">
        <button type="submit">Игрок 2 выиграл текущее очко</button>
    </form>
</body>
</html>
