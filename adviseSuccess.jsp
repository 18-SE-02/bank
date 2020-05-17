<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>村镇银行网络服务中心-留言成功</title>
        <style type="text/css">
        
        .sum{border:1px solid #ffffff;height:600px;width: 600px;margin: 0 auto;background-image: url(C:/Users/Lenovo/Desktop/bank/web/customer/留言成功.png);background-size: 100% 100%;}
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
                        <font color="#7b1e1e" family="楷体">您的建议给了我们很大的帮助与鼓励，感谢您的参与和信任！</font>
                    </ul>                
                </marquee>    
            </div> 
        <s:form action="back" method="post">
            <br><br>
         <table align="center" width="400px" border="5" >
                <tr>
                <td>
                    <s:textfield name="idNumber" value="%{#request.idNumber}" label="您的身份证号为"/>
                </td>
                </tr>
                <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
                <tr>
                    <td>
                        您的留言内容为：
                    </td>
                    <td>${request.text}</td>
                </tr>
                <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
                <td colspan="2" align="center">
                    <input type="submit" value="返回主页面">
                </td>
         </table>
    </s:form>
        </div>
    </body>
</html>
