<%-- 
    Document   : changePassword
    Created on : 2020-4-22, 23:28:16
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
    <body style="background:url(F:/SSH/bank/web/customer/bgground.jpg);background-size: 100% 100%;background-attachment: fixed">
        <div id="header">
            <h1>村镇银行网络服务中心-修改密码</h1>
        </div>
        <s:form action="changepwd" method="post" >
            <br><br><br>
             <table class="lamp" border="1" align="center" >
                  <td>
                    <s:textfield name="idNumber" value="%{#request.idNumber}" label="身份证号码"/>
                </td>
                <tr>
                    <s:password name="password" label="原用户密码" size="20"/>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="清空"/>
                    </td>
                </tr>
            </table>
        </s:form>
    </body>
</html>

