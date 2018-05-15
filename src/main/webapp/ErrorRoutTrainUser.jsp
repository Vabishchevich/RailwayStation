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
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" style="font-style:italic;opacity:0.8">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand">WebRailway</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a>Главная страница</a></li>
                    <li><a>Просмотр всех поездов</a></li>
                    <li><a>Личный кабинет</a></li>
                    <li><a>Выйти</a></li>
                </ul>
            </div>
        </nav>   
        <div class="container" style="font-style:italic;opacity:0.8;margin-top:80px">
            <div class="alert alert-danger" role="alert">
                <h3 style="text-align:center">Предупреждение</h3>
                <hr>
                <div style="text-align:center">По данному запросу поезда не ходят</div>
            </div>  
        </div>
        <div class="footer"></div>
    </body>
    <script>
        setTimeout(function () {
            document.location.replace("/HomePageUser.jsp");
        }, 5000);
    </script>
</html>