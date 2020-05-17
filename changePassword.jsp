<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>村镇银行网络服务中心-修改密码</title>
        <style type="text/css">
        
        .sum{border:1px solid #ffffff;height:600px;width: 600px;margin: 0 auto;background-image: url(C:/Users/Lenovo/Desktop/bank/web/customer/修改密码.png);background-size: 100% 100%;}
        .sub ul{margin: 7px auto;}
        .blank{border:1px solid #ffffff;height:200px;width: 600px;margin: 0 auto;}
        
        </style>
    </head>
    <body>
        <div class="sum">
            <div class="blank"></div>
            <div class="sub">
                <marquee behavior="scoll" loop="infinite" align="middle" scrooldelay="30px" width="600px" height="30px"  hspace="5px" wspace="5px">
                    <ul>
                        <font color="#7b1e1e" family="楷体">您正在修改密码，请妥善保管好您修改后的密码，防止二次丢失！</font>
                    </ul>                
                </marquee>    
            </div>
            <s:form action="change" method="post" >
                <br><br><br>
                 <table class="lamp" border="0" align="center" >
                      <td>
                        <s:textfield name="idNumber" value="%{#request.idNumber}" label="身份证号码"/>
                    </td>
                    <tr>
                        <s:password name="password1" label="输入用户密码" size="21"/>
                    </tr>
                    <tr>
                        <s:password name="password2" label="再次输入密码" size="21"/>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="reset" value="清空"/>
                        </td>
                    </tr>
                </table>
            </s:form>
        </div>
    </body>
</html>
