<%-- 
    Document   : adviseSuccess
    Created on : 2020-5-13, 14:33:45
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background:url(F:/SSH/bank/web/oldCustomer/oldBgground.jpg);background-size: 100% 100%;background-attachment: fixed">
        <h1 align=center style="font-family:'黑体'; font-size:45px;">恭喜你，留言成功！</h1>
        <s:form action="oldback" method="post">
            <marquee direction="left" align="bottom" style="font-family:'黑体'; font-size:35px;" onmouseout="this.start()" onmouseover="this.stop()" scrollamount="3" scrolldelay="1">温馨提示：请保护好您的个人信息，谨防诈骗</marquee>
         <table border="1" align="center" height="250" width="80%" style="font-family:'黑体'; font-size:35px;">
                <tr>
                <td>
                    <s:textfield name="idNumber" value="%{#request.idNumber}" label="您的身份证号码为" style="font-family:'黑体'; font-size:30px;" size="40"/>
                </td>
                </tr>
                <tr>
                    <td>
                        留言内容为：${request.text}
                    </td>
                </tr>
                <td colspan="2" align="center">
                    <input type="submit" value="返回主页面" style="font-family:'黑体'; font-size:35px;">
                </td>
         </table>
    </s:form>
    </body>
</html>
