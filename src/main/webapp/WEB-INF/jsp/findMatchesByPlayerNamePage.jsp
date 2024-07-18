<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Фильтр по имени игрока</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #202833;
            display: flex; /* Используем Flexbox */
            justify-content: center; /* Выравнивание по горизонтали */
            align-items: center; /* Выравнивание по вертикали */
            height: 100vh; /* Занимаемая высота страницы */
            margin: 0; /* Убираем стандартные отступы */
        }
        .form-container { /* Контейнер для формы */
            text-align: center; /* Выравнивание текста по центру */
            width: 100%; /* Занимает всю ширину контейнера */
        }
        input[type="text"] {
            border: 2px solid #66fdee;
            border-radius: 15px;
            font-size: 30px;
            padding: 10px; /* Добавляем немного отступа внутри поля ввода */
            margin-bottom: 20px; /* Отступ снизу для поля ввода */
        }
        button {
            padding: 15px 30px;
            background-color: transparent;
            border: 3px solid #66fdee;
            color: #66fdee;
            cursor: pointer;
            border-radius: 10px;
            font-size: 1.7em;
        }
        button:hover {
            background-color: #45a29f;
        }
        h1 {
            color: #66fdee;
            text-align: center; /* Выравнивание текста по центру */
            font-size: 50px;
        }
        p {
            color: #66fdee;
            text-align: center; /* Выравнивание текста по центру */
            font-size: 15px;
        }
    </style>
</head>
<body>
    <div class="form-container"> <!-- Контейнер для формы -->
        <h1>Фильтр по имени игрока</h1>
        <p>Введите имя игрока, матчи которого хотите найти:</p>

        <form action="/tennis-scoreboard/matches" method="get">
            <input type="text" id="playerName" name="filter_by_player_name" required>
            <input type="hidden" name="page" value="1">
            <input type="hidden" name="size" value="10">
            <button type="submit">Искать</button>
        </form>
    </div>
</body>
</html>
