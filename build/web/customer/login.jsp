
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="村镇银行网络服务中心-登录页"></s:text></title>
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
             <h1>村镇银行网络服务中心-登录页</h1>
        </div>
        <s:form action="login" method="post">
            <br><br><br>
            <table border="1" align="center">
                <tr>
                    <td>
                        <s:textfield name="idNumber" label="身份证号码" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <s:password name="password" label="用户密码" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <s:submit value="登录"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <s:a href="http://localhost:8080/bank/customer/register.jsp">注册</s:a>
                        <s:a href="http://localhost:8080/bank/customer/forgetPassword.jsp">忘记密码</s:a>
                    </td>
                </tr>
            </table>
        </s:form>
    </body>
</html>
