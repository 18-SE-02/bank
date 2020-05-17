<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="欢迎登录村镇银行网络服务中心"/></title>
    </head>
    
    <style type="text/css">
        a{text-decoration: none;}
        a:link{color: #FF8C00;}
        a:visited{color:#FF8C00;}
        a:hover{color:yellow;}
    </style>
    
    <body  background="index.png" style="background-size: 100% 100%;background-attachment: fixed">
        <%response.setCharacterEncoding("UTF-8");%>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <table align="center">
                    <p><center><s:a href="http://localhost:8080/bank/customer/login.jsp"><font size="6" face="楷体">·点击进入正常界面·</font></s:a></center></p>
                    <p><center><s:a href="http://localhost:8080/bank/oldCustomer/oldLogin.jsp"><font size="6" face="楷体">·点击进入老年人界面·</font></s:a></center></p>
            </table>
    </body>
</html>