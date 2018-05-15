<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebRailway</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/validate.js/0.12.0/validate.min.js"></script>
        <style>
            body{
                background-image: url('http://2d.by/wallpapers/s/sero-biryuzovyy_fon.jpg');
                /*background-image: url('https://w-dog.net/wallpapers/13/16/454958512120338/england-steam-engine-train-cornwood-viaduc-railroad-nature-forest.jpg');*/
                -moz-background-size: 100%; /* Firefox 3.6+ */
                -webkit-background-size: 100%; /* Safari 3.1+ и Chrome 4.0+ */
                -o-background-size: 100%; /* Opera 9.6+ */
                background-size: 100%; /* Современные браузеры */
            }
            .footer {
                position: fixed;
                left: 0;
                bottom: 0;
                opacity: 0.8;
                width: 100%;
                color: white;
                text-align: center;
                background-color: #333;
                height: 45px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" style="font-style:italic;opacity:0.8">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand">WebRailway</a>
                </div>
            </div>
        </nav>   
        <div class = "container" style="width:550px;font-style:italic;opacity:0.8;margin-top:80px">
            <div style="text-align:center;"><h3>Форма входа в систему:</h3></div>
            <form method="GET" action="/Controller" class="well">
                <div class="form-group">
                    <label>Введите ваш логин:</label>
                    <input type="text" class = "form-control" name="login" placeholder="Четыре и более символов" pattern="[A-Za-z]{4,}" required>
                </div>
                <div class="form-group">
                    <label>Введите ваш пароль:</label>
                    <input type="password" class = "form-control" name="password" placeholder="Четыре и более символов" pattern="[A-Za-z]{4,}" required>
                </div>
                <div class="form-group">
                    <label>user VS admin:</label>
                    <input type="password" class = "form-control" name="role" placeholder="Роль (admin или user)" required>
                </div>
                <input type="submit" class="btn btn-secondary btn-block" name="command" value="Вход в систему">
            </form>
        </div>
        <div class="footer"></div>
    </body>
</html>
