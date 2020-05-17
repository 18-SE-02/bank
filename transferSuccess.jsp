<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>村镇网络银行服务中心-转账成功</title>
        <style type="text/css">
        
        .sum{border:1px solid #ffffff;height:600px;width: 600px;margin: 0 auto;background-image: url(C:/Users/Lenovo/Desktop/bank02/web/customer/转账成功.png);background-size: 100% 100%;}
        .sub ul{margin: 7px auto;}
        .blank{border:1px solid #ffffff;height:220px;width: 600px;margin: 0 auto;}
        
        </style>
    </head>
    <body>
        <div class="sum">
            <div class="blank"></div>
            <div class="sub">
                <marquee behavior="scoll" loop="infinite" align="middle" scrooldelay="30px" width="600px" height="30px"  hspace="5px" wspace="5px">
                    <ul>
                        <font color="#7b1e1e" family="楷体">您已完成了转账业务，请核对转账信息并及时查询卡内余额！</font>
                    </ul>                
                </marquee>    
            </div>
            <br><br>
        <s:form action="back" method="post">
         <table align="center" width="300px" border="2" >
                <tr>
                <td colspan="2" align="center">
                    <s:textfield name="idNumber" value="%{#request.idNumber}" label="您的身份证号为"/>
                </td>
                </tr>
                <tr></tr>
                <tr>
                    <td>
                        转入的账户为：
                    </td>
                    <td>
                        ${request.idNumber1}
                    </td>
                </tr>
                <tr></tr>
                <tr>
                    <td>
                        转账的金额为:
                    </td>
                    <td>
                        ${request.money}元
                    </td>
                </tr>
                <tr></tr><tr></tr>
                <td colspan="2" align="center">
                <input type="submit" value="返回主页面">
                </td>
         </table>
    </s:form>
        </div>
    </body>
</html>
