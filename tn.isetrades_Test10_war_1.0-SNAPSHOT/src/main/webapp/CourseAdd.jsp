<%-- 
    Document   : FlavorAdd
    Created on : May 26, 2018, 12:45:05 PM
    Author     : Rania
--%>

<%@page import="tn.isetrades.test10.entity.service.MemberService"%>
<%@page import="tn.isetrades.test10.entity.model.Member"%>
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
            String userName = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("name")) {
                        userName = cookie.getValue();
                    }
                }
            }
            if (userName == null) {
                response.sendRedirect("login.jsp");
            }
        %>
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
            <div class="page-wrapper">
                <!-- Bread crumb -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-primary">ISET Rades Cloud Dashboard</h3> </div>
                    <div class="col-md-7 align-self-center">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="welcome.jsp">Home</a></li>
                            <li class="breadcrumb-item"><a href="">Flavors</a></li>
                            <li class="breadcrumb-item active">Add</li>
                        </ol>
                    </div>
                </div>
                <!-- End Bread crumb -->
                <!-- Container fluid  -->
                <div class="container-fluid">
                    <!-- Start Page Content -->
                    <div class="row justify-content-center">
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-body">
                                    <div class="form-validation">
                                        <form class="form-valide" action="ServletCourseAdd" method="POST">    
                                            <div class="col-md-8  justify-content-center">
                                                <div class="form-group">
                                                    <label class="control-label">Name</label>
                                                    <input name="name" type="text" id="name" class="form-control">
                                                </div>
                                            </div> 
                                            <div class="col-md-8  justify-content-center">
                                                <div class="form-group">
                                                    <label class="control-label">Description</label>
                                                    <input name="description" type="text" id="name" class="form-control">
                                                </div>
                                            </div> 

                                            <div class="form-group">
                                                <label>Teacher</label>
                                                <select name = "memberid" class="form-control">
                                                    <% for (Member member : new MemberService().getMemberList()) {
                                                            out.println("<option value = " + member.getIdMember() + ">" + member.getFirstname()+" "+ member.getLastname() + "</option>");
                                                        }%>
                                                </select>
                                            </div>

                                            <div class="form-group row">
                                                <div class="col-lg-8 ml-auto">
                                                    <button name="addCourse" type="submit" class="btn btn-primary">Add</button>
                                                </div>
                                            </div>                                    
                                        </form>
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
            <footer class="footer"> © 2018 All rights reserved. ISET Rades 2018
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


    <!-- Form validation -->
    <script src="js/lib/form-validation/jquery.validate.min.js"></script>
    <script src="js/lib/form-validation/jquery.validate-init.js"></script>
    <!--Custom JavaScript -->
    <script src="js/scripts.js"></script>

</body>

</html>