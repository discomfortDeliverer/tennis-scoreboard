<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Теннисный счет</title>
    <style>
        h1 {
            font-family: 'Arial', sans-serif; /* Изменение шрифта */
            font-size: 100px; /* Изменение размера текста */
            color: #66fdee; /* Изменение цвета текста */
            text-align: center; /* Выравнивание текста по центру */
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #202833;
        }
        table {
            width: 100%;
            border-collapse: collapse;
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
        .button-container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 20px; /* Отступ сверху */
        }
        form {
            display: inline;
        }
        button {
            padding: 15px 30px;
            background-color: transparent;
            border: 5px solid #66fdee;
            color: #66fdee; /* Цвет текста */
            cursor: pointer;
            border-radius: 15px;
            font-size: 1.7em;
        }
        button:hover {
            background-color: #45a29f;
        }
    </style>
</head>
<body>
    <h1>Теннисный счет</h1>
    <table>
        <thead>
            <tr>
                <th>Имена игроков</th>
                <th>Поинты</th>
                <th>Геймы</th>
                <th>Сеты</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><%= request.getAttribute("player1Name") %></td>
                <td><%= request.getAttribute("firstPlayerPoint") %></td>
                <td><%= request.getAttribute("firstPlayerGame") %></td>
                <td><%= request.getAttribute("firstPlayerSet") %></td>
            </tr>
            <tr>
                <td><%= request.getAttribute("player2Name") %></td>
                <td><%= request.getAttribute("secondPlayerPoint") %></td>
                <td><%= request.getAttribute("secondPlayerGame") %></td>
                <td><%= request.getAttribute("secondPlayerSet") %></td>
            </tr>
        </tbody>
    </table>
    <div class="button-container">
        <form action="/tennis-scoreboard/match-score?uuid=<%= request.getAttribute("matchId") %>" method="post">
                <input type="hidden" name="player_id" value="<%= request.getAttribute("firstPlayerId") %>">
                <button type="submit">Игрок 1 выиграл текущее очко</button>
            </form>
            <form action="/tennis-scoreboard/match-score?uuid=<%= request.getAttribute("matchId") %>" method="post">
                <input type="hidden" name="player_id" value="<%= request.getAttribute("secondPlayerId") %>">
                <button type="submit">Игрок 2 выиграл текущее очко</button>
            </form>
    </div
</body>
</html>
