<%-- 
    Document   : index
    Created on : May 25, 2018, 11:17:19 AM
    Author     : Rania
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
        <title></title>
        <!-- Bootstrap Core CSS -->
        <link href="css/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->

        <link href="css/lib/calendar2/semantic.ui.min.css" rel="stylesheet">
        <link href="css/lib/calendar2/pignose.calendar.min.css" rel="stylesheet">
        <link href="css/lib/owl.carousel.min.css" rel="stylesheet" />
        <link href="css/lib/owl.theme.default.min.css" rel="stylesheet" />
        <link href="css/helper.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/rania.css" rel="stylesheet">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:** -->
        <!--[if lt IE 9]>
        <script src="https:**oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https:**oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>
    <body class="fix-header fix-sidebar">
        <%
            //allow access only if session exists
            String user = null;
            if (session.getAttribute("sname") == null) {
                response.sendRedirect("login.jsp");
            } else {
                user = (String) session.getAttribute("sname");
            }

            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("name")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }

        %>
        <!--<h3>Hi <%=userName%>, Login successful.</h3>-->
        <!-- Preloader - style you can find in spinners.css -->
        <div class="preloader">
            <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
        </div>
        <!-- Main wrapper  -->
        <div id="main-wrapper">
            <!-- header header  -->
            <div class="header">
                <nav class="navbar top-navbar navbar-expand-md navbar-light">
                    <!-- Logo -->
                    <div class="navbar-header">
                        <a class="navbar-brand" href="welcome.jsp">
                            <!-- Logo icon -->
                            <b><img src="images/cloud.ico" alt="homepage" class="dark-logo1" /><span><img src="images/isetclogo.png" alt="homepage" class="dark-logo2" /></span></b>
                            <!--End Logo icon -->
                        </a>
                    </div>
                    <!-- End Logo -->
                    <div class="navbar-collapse">
                        <!-- toggle and nav items -->
                        <ul class="navbar-nav mr-auto mt-md-0">
                            <!-- This is  -->
                            <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up text-muted  " href="javascript:void(0)"><i class="mdi mdi-menu"></i></a> </li>
                            <li class="nav-item m-l-10"> <a class="nav-link sidebartoggler hidden-sm-down text-muted  " href="javascript:void(0)"><i class="ti-menu"></i></a> </li>
                            <!-- Language -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-muted  " href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="flag-icon flag-icon-us"></i></a>
                                <div class="dropdown-menu animated zoomIn">
                                    <a class="dropdown-item" href="#"><i class="flag-icon flag-icon-fr"></i> French</a>  
                                </div>
                            </li>
                            <!-- Course -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-muted  " href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">L3 DSI 2</a>
                                <div class="dropdown-menu animated zoomIn">
                                    <a class="dropdown-item" href="#">L3 DSI 1</a> 
                                    <a class="dropdown-item" href="#">L3 RSI 1</a> 
                                </div>
                            </li>
                        </ul>

                        <!-- User profile and search -->
                        <ul class="navbar-nav my-lg-0">
                            <!-- Comment -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-muted text-muted  " href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="fa fa-bell"></i>
                                    <div class="notify"> <span class="heartbit"></span> <span class="point"></span> </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right mailbox animated zoomIn">
                                    <ul>
                                        <li>
                                            <div class="drop-title">Notifications</div>
                                        </li>
                                        <li>
                                            <div class="message-center">
                                            </div>
                                        </li>
                                        <li>
                                            <a class="nav-link text-center" href="javascript:void(0);"> <strong>Check all notifications</strong> <i class="fa fa-angle-right"></i> </a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <!-- End Comment -->
                            <!-- Messages -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-muted  " href="#" id="2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="fa fa-envelope"></i>
                                    <div class="notify"> <span class="heartbit"></span> <span class="point"></span> </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right mailbox animated zoomIn" aria-labelledby="2">
                                    <ul>
                                        <li>
                                            <div class="drop-title">You have new messages</div>
                                        </li>
                                        <li>
                                            <a class="nav-link text-center" href="javascript:void(0);"> <strong>See all e-Mails</strong> <i class="fa fa-angle-right"></i> </a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <!-- End Messages -->
                            <!-- Profile -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-muted  " href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="images/users/5.jpg" alt="user" class="profile-pic" /></a>
                                <div class="dropdown-menu dropdown-menu-right animated zoomIn">
                                    <ul class="dropdown-user">
                                        <li><a href="#"><i class="ti-user"></i> Profile</a></li>
                                        <li><a href="#"><i class="ti-email"></i> Inbox</a></li>
                                        <li><a href="#"><i class="ti-settings"></i> Setting</a></li>
                                        <li><a href="#"><i class="fa fa-power-off"></i> Logout</a></li>
                                        <form action="Logoutservlet" method="post">
                                            <input type="submit" value="Logout" >
                                        </form>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
            <!-- End header header -->
            <!-- Left Sidebar  -->
            <div class="left-sidebar">
                <!-- Sidebar scroll-->
                <div class="scroll-sidebar">
                    <!-- Sidebar navigation-->
                    <nav class="sidebar-nav">
                        <ul id="sidebarnav">
                            <li class="nav-devider"></li>
                            <li class="nav-label">Home</li>
                            <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-tachometer"></i><span class="hide-menu">Dashboard <span class="label label-rouded label-primary pull-right">2</span></span></a>
                                <ul aria-expanded="false" class="collapse">
                                    <li><a href="welcome.jsp">Overview </a></li>
                        
                                </ul>
                            </li>
                            <li class="nav-label"></li>
                            <a href=""></a>
                            <a href=""></a> 
                            <li class="nav-label">My Course's Ressources</li>
                            <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-envelope"></i><span class="hide-menu">Virtual Machines</span></a>
                                <ul aria-expanded="false" class="collapse">
                                    <li><a href="ServerView.jsp">View</a></li>
                                    <li><a href="ServerAdd.jsp">Add</a></li>
                                </ul>
                            </li>
                            <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-bar-chart"></i><span class="hide-menu">OS Images</span></a>
                                <ul aria-expanded="false" class="collapse">
                                    <li><a href="ImageView.jsp">View</a></li>
                                    <li><a href="ImageAdd.jsp">Add</a></li>
                                </ul>
                            </li>
                            <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-bar-chart"></i><span class="hide-menu">Hardware</span></a>
                                <ul aria-expanded="false" class="collapse">
                                    <li><a href="FlavorView.jsp">View</a></li>
                                    <li><a href="FlavorAdd.jsp">Add</a></li>
                                </ul>
                            </li>
                            <li class="nav-label"></li>
                            <a href=""></a>
                            <a href=""></a> 
                            <li class="nav-label">My Course's Management</li>

                            <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-suitcase"></i><span class="hide-menu">Courses<span class="label label-rouded label-warning pull-right">2</span></span></a>
                                <ul aria-expanded="false" class="collapse">
                                    <li><a href="CourseView.jsp">View</a></li>
                                    <li><a href="CourseAdd.jsp">Add</a></li>
                                </ul>
                            </li>

                            <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-suitcase"></i><span class="hide-menu">Members<span class="label label-rouded label-warning pull-right">2</span></span></a>

                                <ul aria-expanded="false" class="collapse">
                                    <li><a href="StudentView.jsp">View</a></li>
                                    <li><a href="StudentAdd.jsp">Add</a></li>
                                </ul>
                            </li>
                            <li> <a class="has-arrow  " href="#" aria-expanded="false"><i class="fa fa-bar-chart"></i><span class="hide-menu">Roles</span></a>
                                <ul aria-expanded="false" class="collapse">
                                    <li><a href="RoleView.jsp">View</a></li>
                                    <li><a href="RoleAdd.jsp">Add</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                    <!-- End Sidebar navigation -->
                </div>
                <!-- End Sidebar scroll-->
            </div>
            <!-- End Left Sidebar  -->
            <!-- Page wrapper  -->
            <div class="page-wrapper">
                <!-- Bread crumb -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-primary">ISET Rades Cloud Dashboard</h3> </div>
                    <div class="col-md-7 align-self-center">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                    </div>
                </div>
                <!-- End Bread crumb -->
                <!-- Container fluid  -->
                <div class="container-fluid">
                    <!-- Start Page Content -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-title">
                                    <h4>Overview</h4>
                                    <div class="card-title-right-icon">
                                        <ul>

                                        </ul>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-lg-3">
                                            <span class="pie" data-peity='{ "fill": ["#FFCA4A", "#f2f2f2"]}'>226,222</span>
                                        </div>
                                        <div class="col-lg-3">
                                            <span class="pie" data-peity='{ "fill": ["#FFCA4A", "#f2f2f2"]}'>226,134</span>
                                        </div>
                                        <div class="col-lg-3">
                                            <span class="pie" data-peity='{ "fill": ["#FFCA4A", "#f2f2f2"]}'>226,134</span>
                                        </div>
                                        <div class="col-lg-3">
                                            <span class="pie" data-peity='{ "fill": ["#FFCA4A", "#f2f2f2"]}'>226,134</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /# card -->
                        </div>
                        <!-- /# column -->
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-title">
                                    <h4>Recent Virtual Machines</h4>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Name</th>
                                                    <th>Student</th>
                                                    <th>Flavor</th>
                                                    <th>Image</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>
                                                        <div class="round-img">
                                                            <a href=""><img src="images/avatar/4.jpg" alt=""></a>
                                                        </div>
                                                    </td>
                                                    <td>JEE</td>
                                                    <td><span>Rania KTHIRI</span></td>
                                                    <td><span>4Win10</span></td>
                                                    <td><span class="badge badge-success">Win10</span></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="card">
                                        <div class="card-title">
                                            <h4>Message </h4>
                                        </div>
                                        <div class="recent-comment">
                                            <div class="media">
                                                <div class="media-left">
                                                    <a href="#"><img alt="..." src="images/avatar/1.jpg" class="media-object"></a>
                                                </div>
                                                <div class="media-body">
                                                    <h4 class="media-heading">john doe</h4>
                                                    <p>Cras sit amet nibh libero, in gravida nulla. </p>
                                                    <p class="comment-date">October 21, 2018</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /# card -->
                                </div>
                                <!-- /# column -->
                                <div class="col-lg-6">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="year-calendar"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">Todo</h4>
                                    <div class="card-content">
                                        <div class="todo-list">
                                            <div class="tdl-holder">
                                                <div class="tdl-content">
                                                    <ul>
                                                        <li>
                                                            <label>
                                                                <input type="checkbox"><i class="bg-primary"></i><span>Build an angular app</span>
                                                                <a href='#' class="ti-close"></a>
                                                            </label>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <input type="text" class="tdl-new form-control" placeholder="Type here">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End PAge Content -->
                </div>
                <!-- End Container fluid  -->
                <!-- footer -->
                <footer class="footer"> © 2018 All rights reserved. Template designed by <a href="https://colorlib.com">Colorlib</a></footer>
                <!-- End footer -->
            </div>
            <!-- End Page wrapper  -->
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
        <!--Custom JavaScript -->


        <!-- Amchart -->
        <script src="js/lib/morris-chart/raphael-min.js"></script>
        <script src="js/lib/morris-chart/morris.js"></script>
        <script src="js/lib/morris-chart/dashboard1-init.js"></script>


        <script src="js/lib/calendar-2/moment.latest.min.js"></script>
        <!-- scripit init-->
        <script src="js/lib/calendar-2/semantic.ui.min.js"></script>
        <!-- scripit init-->
        <script src="js/lib/calendar-2/prism.min.js"></script>
        <!-- scripit init-->
        <script src="js/lib/calendar-2/pignose.calendar.min.js"></script>
        <!-- scripit init-->
        <script src="js/lib/calendar-2/pignose.init.js"></script>

        <script src="js/lib/owl-carousel/owl.carousel.min.js"></script>
        <script src="js/lib/owl-carousel/owl.carousel-init.js"></script>
        <script src="js/scripts.js"></script>
        <!-- scripit init-->
        <script src="js/lib/peitychart/jquery.peity.min.js"></script>
        <!-- scripit init-->
        <script src="js/lib/peitychart/peitychart.init.js"></script>
        <script src="js/scripts.js"></script>

    </body>

</html>