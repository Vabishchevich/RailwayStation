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
            .content{
                position: relative;
                display: inline-block;
                width: 30%;
                height: 300px;
                background-color: white;
                float: left;
                border-radius: 10px;
            }   
            .content:nth-child(odd) {
                margin-left: 5%;
                margin-right: 5%;
            }
            #image{
                background-image: url('https://travel.rambler.ru/media/attachments/depositphotos_169411746_m-2015.jpg');
                -webkit-transition: all 1s ease;
                -o-transition: all 1s ease;
                -moz-transition: all 1s ease;
                transition: all 1s ease;
            }
            #image:hover{
                opacity:0.7;
            }
            #image2{
                background-image: url('https://travel.rambler.ru/media/attachments/depositphotos_73405399_m-2015.jpg');
                -webkit-transition: all 1s ease;
                -o-transition: all 1s ease;
                -moz-transition: all 1s ease;
                transition: all 1s ease;
            }
            #image2:hover{opacity:0.7;}
            #image3{
                background-image: url('https://travel.rambler.ru/media/attachments/5073a2ac3a5d2.jpg');
                -webkit-transition: all 1s ease;
                -o-transition: all 1s ease;
                -moz-transition: all 1s ease;
                transition: all 1s ease;
            }
            #image3:hover{opacity:0.7;}
            a{
                color: black;
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
                    <li><a onclick="ChoiceOfTrain()">Забронировать билет</a></li>
                    <li><a onclick="ViewTrains()">Просмотр всех поездов</a></li>
                    <li><a onclick="PrivateOffice()">Личный кабинет</a></li>
                    <li><a onclick="Exit()">Выйти</a></li>
                    </li>
                </ul>
            </div>
        </nav>   
        <div class="container" style="font-style:italic;margin-top:80px">
            <form class="well" style="text-align:center;opacity:0.8">
                <h3><p>Бронируйте быстрее. Бронируйте разумнее. Бронируйте на WebRailway.</p>
                    <h4></h4>Мы в WebRailway обожаем путешествия! И с удовольствием работаем над тем, чтобы найти для вас самые 
                    оптимальные маршруты для передвижения по железной дороге. Огромный выбор вариантов для бронирования на 
                    WebRailway позволит вам спланировать идеальный отдых: от экстремального туризма и поездки налегке до 
                    медового месяца и отпуска с семьей.</h4></h3>
            </form>
            <div class="content" id="image" style="text-align:center" >
                <a href="https://travel.rambler.ru/article/3447/">
                    <h4></h4>Самые лучшие маршруты для путешествия с палаткой</h4></h3>
                </a>
            </div>
            <div class="content" id="image2" style="text-align:center">
                <a href="https://travel.rambler.ru/article/3446/">   
                    <h4></h4>5 стран, в которых сказочно красивая весна</h4></h3>
                </a>
            </div>
            <div class="content" id="image3" style="text-align:center">
                <a href="https://travel.rambler.ru/article/588/">   
                    <h4></h4>10 способов избавиться от осенней хандры</h4></h3>
                </a>
            </div>
        </div>
        <div class="footer"></div>
    </body>
    <script type= "text/javascript">
        function ViewTrains() {
            window.location = "/RequestViewAllTrainsUser.jsp";
        }
        function PrivateOffice() {
            window.location = "/RequestPrivateOfficeUser.jsp";
        }
        function Exit() {
            window.location = "/index.jsp";
        }
        function ChoiceOfTrain() {
            window.location = "/RequestToBookATicketUser .jsp";
        }
    </script>
</html>

