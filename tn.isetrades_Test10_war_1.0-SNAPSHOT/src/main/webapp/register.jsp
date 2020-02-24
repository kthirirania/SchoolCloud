<%-- 
    Document   : login
    Created on : Jun 4, 2018, 2:57:04 PM
    Author     : Rania
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Register</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="login/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="login/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="login/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/css/util.css">
        <link href="css/lib/toastr/toastr.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="login/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <form class="login100-form validate-form p-l-55 p-r-55 p-t-178" name="registerForm" method="post" action="RegisterServlet">
                        <span class="login100-form-title">Sign Up</span>
                        <div class="wrap-input100 validate-input m-b-16" data-validate="First Name">
                            <input class="input100" type="text" name="firstname" placeholder="firstname">
                            <span class="focus-input100"></span>
                        </div>
                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Last Name">
                            <input class="input100" type="text" name="lastname" placeholder="lastname">
                            <span class="focus-input100"></span>
                        </div>
                        <div class="wrap-input100 validate-input m-b-16" data-validate="Email">
                            <input class="input100" type="email" name="email" placeholder="email">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-16" data-validate="Username">
                            <input class="input100" type="text" name="username" placeholder="Username">
                            <span class="focus-input100"></span>
                        </div>
                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Password">
                            <input class="input100" type="password" name="password" placeholder="Password" >
                            <span class="focus-input100"></span>
                        </div>
                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Role">
                            <select name = "role" class="input100">
                                <option class="input100" value = "administrator">Administrator</option>
                                <option class="input100" value = "teacher">Teacher</option>    
                            </select>
                            <span class="focus-input100"></span>
                        </div>

                        <div class="container-login100-form-btn">
                            <button type="submit" id="toastr-info-top-right" class="login100-form-btn">Sign Up</button>
                        </div>
                        <div class="flex-col-c m-b-16">
                            <span class="txt1 p-b-9">
                                Already have an account?
                            </span>
                            <a href="login.jsp" class="txt3">
                                Sign In now
                            </a>

                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--===============================================================================================-->
        <script src="login/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="login/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="login/vendor/bootstrap/js/popper.js"></script>
        <script src="login/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="login/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="login/vendor/daterangepicker/moment.min.js"></script>
        <script src="login/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="login/vendor/countdowntime/countdowntime.js"></script>
        <script src="js/lib/toastr/toastr.min.js"></script>
        <!-- scripit init-->
        <script src="js/lib/toastr/toastr.init.js"></script>
        <!--===============================================================================================-->
        <script src="login/js/main.js"></script>
        <script>
            $('#toastr-info-top-right').on("click", function () {
                toastr.info('We will send you confirmation within 24h', 'Your Registration Succeded', {
                    "positionClass": "toast-top-right",
                    timeOut: 5000,
                    "closeButton": true,
                    "debug": false,
                    "newestOnTop": true,
                    "progressBar": true,
                    "preventDuplicates": true,
                    "onclick": null,
                    "showDuration": "300",
                    "hideDuration": "1000",
                    "extendedTimeOut": "1000",
                    "showEasing": "swing",
                    "hideEasing": "linear",
                    "showMethod": "fadeIn",
                    "hideMethod": "fadeOut",
                    "tapToDismiss": false

                })
            });
        </script>
    </body>
</html>