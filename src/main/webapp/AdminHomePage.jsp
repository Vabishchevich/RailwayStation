<%@page contentType="text/html" pageEncoding="windows-1251"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>WebRailway</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            body{
                /*background-image: url('http://2d.by/wallpapers/s/sero-biryuzovyy_fon.jpg');*/
                background-image: url('https://w-dog.net/wallpapers/13/16/454958512120338/england-steam-engine-train-cornwood-viaduc-railroad-nature-forest.jpg');
                -moz-background-size: 100%; /* Firefox 3.6+ */
                -webkit-background-size: 100%; /* Safari 3.1+ � Chrome 4.0+ */
                -o-background-size: 100%; /* Opera 9.6+ */
                background-size: 100%; /* ����������� �������� */
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
                    <li><a onclick="WorkWithUsers()">������ � ��������������</a></li>
                    <li><a onclick="ViewTrains()">�������� ���� �������</a></li>
                    <li><a onclick="AddingANewTrain()">���������� ������ ������</a></li>
                    <li><a onclick="Exit()">�����</a></li>
                    </li>
                </ul>
            </div>
        </nav>  
        <div class="footer">
            <h4 style="font-style:italic;opacity:0.8">�������������</h4>
        </div>
    </body>
    <script type= "text/javascript">
        function WorkWithUsers() {
            window.location = "/RequestWorkWithUsers.jsp";
        }
        function ViewTrains() {
            window.location = "/RequestViewAllTrainsAdmin.jsp";
        }
        function AddingANewTrain() {
            window.location = "/RequestAddNewTrainAdmin.jsp";
        }
        function Exit() {
            window.location = "/index.jsp";
        }
    </script>
</html>
