
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="基于SH的应用"></s:text></title>
        <style>
        #header {
            background-color:transparent;
            color:black;
            text-align:center;
            padding:5px;
        }       
        </style>
    </head>
    <div id="header">
            <h1>村镇银行网络服务中心-注册页</h1>
    </div>
    <body style="background:url(F:/SSH/bank/web/customer/bgground.jpg);background-size: 100% 100%;background-attachment: fixed">
        <s:form action="register" method="post">
            <br><br><br>
            <table border="1" align="center">
                <tr>
                    <td>
                        <s:textfield name="name" label="用户名字" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <s:textfield name="telephone" label="电话号码" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <s:textfield name="idNumber" label="身份证号码" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <s:password name="password1" label="用户密码" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <s:password name="password2" label="再次输入密码" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="清空"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <s:a href="http://localhost:8080/bank/customer/login.jsp">返回</s:a>
                    </td>
                </tr>
            </table>
        </s:form>
    </body>
</html>
