<%-- 
    Document   : index
    Created on : 2020-4-21, 21:48:15
    Author     : Administrator
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="欢迎登录村镇银行网络服务中心"/></title>
    </head>
    <body style="background:url(F:/SSH/bank/web/customer/index.png);background-size: 100% 100%;background-attachment: fixed">
        <%response.setCharacterEncoding("UTF-8");%>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <div align="center">
            <table>
                <tr>
                    <td><s:a href="http://localhost:8080/bank/customer/login.jsp"><font color="#FF8C00" size="6" face="仿宋">点击进入</font></s:a></td>
                </tr>
            </table>
            
        <div>
    </body>
</html>