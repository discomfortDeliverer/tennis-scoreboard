<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
    <style>
        h1 {
            font-family: 'Arial', sans-serif; /* Изменение шрифта */
            font-size: 100px; /* Изменение размера текста */
            color: #66fdee; /* Изменение цвета текста */
            text-align: center; /* Выравнивание текста по центру */
        }
        body {
            background-color: #202833; /* Голубой цвет фона */
            font-family: 'Arial', sans-serif; /* Красивый шрифт */
            margin: 0;
        }
        .top-strip {
            height: 80px; /* Высота полосы */
            width: 100%; /* Ширина полосы */
            background-color: #45a29f; /* Цвет полосы */
        }
        .container {
            text-align: center;
            display: flex;
            flex-direction: column; /* Вертикальное расположение элементов */
            justify-content: center;
            align-items: center;
            height: calc(100vh - 80px); /* Высота контейнера с учетом полосы */
        }
        .button-container {
            display: flex; /* Горизонтальное расположение кнопок */
            justify-content: center;
        }
        button {
            width: 250px; /* Фиксированная ширина кнопок */
            height: 70px; /* Фиксированная высота кнопок */
            margin: 10px;
            background-color: transparent;
            border: 5px solid #66fdee;
            color: #66fdee; /* Цвет текста */
            cursor: pointer;
            border-radius: 15px;
            font-size: 1.5em; /* Увеличенный размер шрифта */
        }
        button:hover {
            background-color: #45a29f;
        }
    </style>
</head>
<body>
    <div class="top-strip"></div>
    <div class="container">
        <h1>Tennis Scoreboard</h1>
        <div class="button-container">
            <form action="/tennis-scoreboard/new-match" method="GET" style="display: inline;">
                <button type="submit">New match</button>
            </form>
            <form action="/tennis-scoreboard/matches" method="GET" style="display: inline;">
                <button type="submit">Played matches</button>
            </form>
        </div>
    </div>
</body>
</html>
