<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Новая игра</title>
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
        form {
            background-color: #48B169;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label, input, button {
            display: block;
            margin: 10px 0;
            font-size: 1.2em; /* Увеличенный размер шрифта */
        }
        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
        }
        button {
            padding: 15px 30px;
            background-color: #34DC6A; /* Зеленый цвет кнопки */
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
    <form action="/tennis-scoreboard/new-match" method="POST" onsubmit="return validateForm()">
        <label for="player1">Player 1:</label>
        <input type="text" id="player1" name="player1" required>
        <br>
        <label for="player2">Player 2:</label>
        <input type="text" id="player2" name="player2" required>
        <br>
        <button type="submit">Start match</button>
    </form>

    <script>
        function validateForm() {
            var player1 = document.getElementById("player1").value;
            var player2 = document.getElementById("player2").value;
            if (player1 === player2) {
                alert("Игрок не может играть сам с собой. Пожалуйста, введите разные имена.");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
