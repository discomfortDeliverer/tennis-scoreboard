<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
    <style>
        body {
            background-color: #4D865F; /* Голубой цвет фона */
            font-family: 'Arial', sans-serif; /* Красивый шрифт */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
        }
        button {
            padding: 15px 30px;
            margin: 10px;
            background-color: #4CAF50; /* Зеленый цвет кнопки */
            color: white;
            border: none;
            cursor: pointer;
            font-size: 1.2em; /* Увеличенный размер шрифта */
        }
        button:hover {
            background-color: #45a049; /* Темно-зеленый цвет кнопки при наведении */
        }
    </style>
</head>
<body>
    <div class="container">
            <form action="/tennis-scoreboard/new-match" method="GET" style="display: inline;">
                <button type="submit">New match</button>
            </form>
            <form action="/tennis-scoreboard/matches" method="GET" style="display: inline;">
                <button type="submit">Played matches</button>
            </form>
        </div>
</body>
</html>
