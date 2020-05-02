<%-- 
    Document   : forgetPassword
    Created on : 2020-4-22, 23:02:00
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
        <style>
        table.lamp {
            width:30%;
            border:1px solid #d4d4d4;
        }
        table.lamp th, td { 
            padding:10px;
        }
        table.lamp th {
            width:40px;
        }
        </style>
    </head>
    <body style="background:url(F:/SSH/bank/web/customer/bgground.jpg);background-size: 100% 100%;background-attachment: fixed">
        <div id="header">
            <h1>村镇银行网络服务中心-忘记密码</h1>
        </div>
        <s:form action="forget" method="post" >
            <br><br><br>
             <table class="lamp" border="1" align="center">
                <tr>
                        <s:textfield name="idNumber" label="请输入您的身份证号码" size="20"/>
                </tr>
                <tr>
                        <s:textfield name="cardNumber" label="卡号" size="20"/>
                </tr>
                <tr>
                        <s:textfield name="name" label="姓名" size="20"/>
                </tr>
                <tr>
                        <s:textfield name="telephone" label="电话号码" size="20"/>
                </tr>
                <tr>
                       <s:submit value="确定"/>
                </tr>
            </table>
        </s:form>
    </body>
</html>
