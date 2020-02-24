<%-- 
    Document   : index
    Created on : Jun 4, 2018, 3:52:19 PM
    Author     : Rania
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
        <title>Ela - Bootstrap Admin Dashboard Template</title>
        <!-- Bootstrap Core CSS -->
        <link href="css/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/helper.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/cloud.css" rel="stylesheet">
        <link href="css/rania.css" rel="stylesheet">
        <link href="css/rania1.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <div class="weather-widget">
                        <div id="weather-one" class="weather-one"></div>
                    </div>
                </div>
            </div>
        </div>
        <div id="clouds">
            <div class="cloud x1"></div>
            <!-- Time for multiple clouds to dance around -->
            <div class="cloud x2"></div>
            <div class="cloud x3"></div>
            <center>
                <button onclick="location.href='login.jsp'" type="button" class="button button2">Sign In</button>
                <button onclick="location.href='register.jsp'" type="button" class="button button2">Sign Up</button>
            </center>
            <div class="cloud x4"></div>
            <div class="cloud x5"></div>

        </div>

        <!-- End Wrapper -->
        <!-- All Jquery -->
        <script src="js/lib/jquery/jquery.min.js"></script>
        <!-- Bootstrap tether Core JavaScript -->
        <script src="js/lib/bootstrap/js/popper.min.js"></script>
        <script src="js/lib/bootstrap/js/bootstrap.min.js"></script>
        <!-- slimscrollbar scrollbar JavaScript -->
        <script src="js/jquery.slimscroll.js"></script>
        <!--Menu sidebar -->
        <script src="js/sidebarmenu.js"></script>
        <!--stickey kit -->
        <script src="js/lib/sticky-kit-master/dist/sticky-kit.min.js"></script>


        <script src="js/lib/weather/jquery.simpleWeather.min.js"></script>
        <script src="js/lib/weather/weather-init.js"></script>
        <!--Custom JavaScript -->
        <script src="js/scripts.js"></script>
    </body>
</html>
