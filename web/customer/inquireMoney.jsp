<%-- 
    Document   : inquireMoney
    Created on : 2020-4-19, 10:33:13
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>查询余额</title>
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
            <h1>村镇银行网络服务中心-查询余额</h1>
        </div>
        <table align="center" width="80%" border="5" >
            <tr>
                <th>姓名</th>
                <th>银行卡号</th>
                <th>余额</th>
                <th>贷款</th>
            </tr>
            <tr>
                <td><s:property value="#request.name"/></td>
                <td><s:property value="#request.cardNumber"/></td>
                <td><s:property value="#request.balance"/></td>
                <td><s:property value="#request.loan"/></td>
            </tr>
        </table>
</html>
