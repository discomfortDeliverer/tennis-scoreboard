<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Таблица результатов</title>
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
    <br>
    <form action="/tennis-scoreboard/" method="get">
        <button type="submit">Вернуться на главную страницу</button>
    </form>
</body>
</html>
