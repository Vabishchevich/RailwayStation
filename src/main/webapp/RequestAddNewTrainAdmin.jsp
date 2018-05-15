<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>WebRailway</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                <ul class="nav navbar-nav">
                    <li><a onclick="ViewHomePage()">Главная страница</a></li>
                    <li><a onclick="WorkWithUsers()">Работа с пользователями</a></li>
                    <li><a onclick="ViewTrains()">Просмотр всех поездов</a></li>
                    <li><a onclick="Exit()">Выйти</a></li>
                </ul>
            </div>
        </nav>   
        <div class = "container" style="width:550px;font-style:italic;opacity:0.8;margin-top:80px">
            <div style="text-align:center;"><h3>Добавление нового поезда:</h3></div>
            <form method="post" action="/Controller" class="well">
                <div class = "form-group">
                    <label> Введите номер поезда:  </label>
                    <input type="text" class = "form-control" name="numberTrain" placeholder="Номер поезда"required>
                </div>
                <div class = "form-group">
                    <label> Введите станцию отправления:  </label>
                    <input type="text" class = "form-control" name="startStation" pattern="[А-Я][а-я]{1,20}" placeholder="Станция отправления" required>
                </div>
                <div class = "form-group">
                    <label> Введите станцию прибытия:  </label>
                    <input type="text" class = "form-control" name="endStation" pattern="[А-Я][а-я]{1,20}" placeholder="Станция прибытия" required>
                </div>  
                <input type = "submit" class="btn btn-secondary btn-block" name = "command" value="Добавить данные">
            </form>
        </div>
        <div class="footer">
            <h4 style="font-style:italic;opacity:0.8">Администратор</h4>
        </div>
    </body>
    <script type= "text/javascript">
        function WorkWithUsers() {
            window.location = "/RequestWorkWithUsers.jsp";
        }
        function ViewTrains() {
            window.location = "/RequestViewAllTrainsAdmin.jsp";
        }
        function ViewHomePage() {
            window.location = "/AdminHomePage.jsp";
        }
        function Exit() {
            window.location = "/index.jsp";
        }
    </script>
</html>