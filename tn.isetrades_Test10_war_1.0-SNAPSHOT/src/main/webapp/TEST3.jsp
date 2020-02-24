<%-- 
    Document   : TEST3
    Created on : Jun 13, 2018, 3:07:52 AM
    Author     : Rania
--%>

<%@page import="tn.isetrades.test10.entity.service.RoleService"%>
<%@page import="tn.isetrades.test10.entity.model.Role"%>
<%@page import="tn.isetrades.test10.entity.service.CourseService"%>
<%@page import="tn.isetrades.test10.entity.model.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="test" method="post" action="TEST3">
            <input name="fname" type="text">
            <input name="lname" type="text">
            <input name="email" type="text">
            <input name="username" type="text">
            <input name="password" type="text">
            <% for (Course course : new CourseService().getCourseList()) {
                    out.println("<input type='checkbox' name='courses' value='" + course.getIdCourse() + "'>" + course.getName() + "<br/>");
                }%>
            <select name = "role">
                <% for (Role role : new RoleService().getRoleList()) {
                        out.println("<option value = " + role.getIdRole() + ">" + role.getName() + "</option>");
                    }%>
            </select>
            <input type="radio" name="en" value="enabled">Enabled<br/><br/>
            <input type="radio" name="en" value="disabled">Disabled<br>
            <input type="submit" value="ADD"/>
        </form>
    </body>
</html>
