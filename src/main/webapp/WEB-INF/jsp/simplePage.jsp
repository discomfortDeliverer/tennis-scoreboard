<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Новая игра</title>
    <style>
        input[type="text"] {
            border: 2px solid #66fdee; /* Толщина и цвет границы */
            border-radius: 15px; /* Скругленные края */
            font-size: 24px; /* Размер шрифта */
        }
        body {
            background-color: #202833;
            font-family: 'Arial', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        form {
            background-color: #334052;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        label, input, button {
            display: block;
            margin: 10px 0;
            font-size: 2em;
        }
        #player1-label {
            color: #66fdee;
            font-family: 'Arial', sans-serif;
            font-weight: bold;
            font-size: 2em;
        }
        #player2-label {
            color: #66fdee;
            font-family: 'Arial', sans-serif;
            font-weight: bold;
            font-size: 1.9em;
        }
        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
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
    <form action="/tennis-scoreboard/new-match" method="POST" onsubmit="return validateForm()">
        <label for="player1" id="player1-label">Player 1:</label>
        <input type="text" id="player1" name="player1" required>
        <br>
        <label for="player2" id="player1-label">Player 2:</label>
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
