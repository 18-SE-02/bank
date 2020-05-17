<%-- 
    Document   : historyAdvise
    Created on : 2020-5-14, 15:33:04
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        #header {
            background-color:transparent;
            color:black;
            text-align:center;
            padding:5px;
        }       
        </style>
    </head>
    <body style="background:url(F:/SSH/bank/web/customer/bgground.jpg);background-size: 100% 100%;background-attachment: fixed">
        <div id="header">
            <h1 align=center style="font-family:'黑体'; font-size:45px;">村镇银行网络服务中心-查看历史留言</h1>
        </div>
        <marquee direction="left" align="bottom" style="font-family:'黑体'; font-size:35px;" onmouseout="this.start()" onmouseover="this.stop()" scrollamount="3" scrolldelay="1">温馨提示：请保护好您的个人信息，谨防诈骗</marquee>
        <table border="5" align="center" height="200" width="80%" style="font-family:'黑体'; font-size:35px;">
            <tr>
                <th>身份证号码</th>
                <th>历史留言日期</th>
                <th>历史留言</th>
                <th>客服是否查看</th>
                <th>客服回复</th>
            </tr>
            <tr>
                <td align=center><s:property value="#request.idNumber"/></td>
                <td align=center><s:property value="#request.date"/></td>
                <td align=center><s:property value="#request.message"/></td>
                <td align=center><s:property value="#request.look"/></td>
                <td align=center><s:property value="#request.reply"/></td>
            </tr>
        </table>
    </body>
</html>
