<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Фильтр по имени игрока</title>
    <style>
        input[type="text"] {
            border: 2px solid #66fdee; /* Толщина и цвет границы */
            border-radius: 15px; /* Скругленные края */
            font-size: 24px; /* Размер шрифта */
        }
    </style>
</head>
<body>
    <h1>Фильтр по имени игрока</h1>
    <form action="/tennis-scoreboard/matches" method="get">
        <label for="playerName">Имя игрока:</label>
        <input type="text" id="playerName" name="filter_by_player_name" required>
        <input type="hidden" name="page" value="1">
        <input type="hidden" name="size" value="2">
        <button type="submit">Искать</button>
    </form>
</body>
</html>

