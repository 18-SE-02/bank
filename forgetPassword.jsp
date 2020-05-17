<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>村镇银行网络服务中心-忘记密码</title>
        <style type="text/css">
        
        .sum{border:1px solid #ffffff;height:650px;width: 800px;margin: 0 auto;background-image: url(C:/Users/Lenovo/Desktop/bank/web/customer/忘记密码.png);background-size: 100% 100%;}
        .sub ul{margin: 7px auto;}
        .blank{border:1px solid #ffffff;height:190px;width: 800px;margin: 0 auto;}
        
        table.lamp th, td { 
            padding:10px;
        }
        table.lamp th {
            height: 20px;
            width:60px;
        }
        
        
        </style>
    </head>
    
    <body>
        <div class="sum">
            <div class="blank"></div>
            <div class="sub">
                <marquee behavior="scoll" loop="infinite" align="middle" scrooldelay="30px" width="800px" height="30px"  hspace="5px" wspace="5px">
                        <ul>
                            <font color="#7b1e1e" family="楷体">您正在填写个人信息，请认真对照信息，确认无误后点击“确定”，我们将为您提供修改密码服务。</font>
                        </ul>
                </marquee>
            </div>
            <div>
        <s:form action="forget" method="post" >
            <br><br><br>
             <table class="lamp" border="0" align="center">
                <tr>
                    <s:textfield name="idNumber" label="请输入您的身份证号" size="30"/>
                </tr>
                <tr>
                    <s:textfield name="cardNumber" label="请输入您的银行卡号" size="30"/>
                </tr>
                <tr>
                    <s:textfield name="name" label="请输入您的姓名" size="30"/>
                </tr>
                <tr>
                    <s:textfield name="telephone" label="请输入您的电话号码" size="30"/>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="确定"/>
                    </td>
                </tr>
            </table>
        </s:form>
            </div>
        </div>
    </body>
</html>
