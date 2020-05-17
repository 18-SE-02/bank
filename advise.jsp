<%@page import="java.util.ArrayList"%>
<%@page import="PO.UserInfoPO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户意见箱</title>
    <style type="text/css">
        .sum{border:1px solid #ffffff;height:650px;width: 800px;margin: 0 auto;background-image: url(C:/Users/Lenovo/Desktop/bank/web/customer/意见箱页面.png);background-size: 100% 100%;}
        .sub ul{margin: 7px auto;}
        .blank{border:1px solid #ffffff;height:190px;width: 800px;margin: 0 auto;}
    </style>
</head>
<body>
    <div class="sum">
    <div class="blank"></div>
            <div class="sub">
                <marquee behavior="scoll" loop="infinite" align="middle" scrooldelay="30px" width="800px" height="30px"  hspace="5px" wspace="5px">
                        <ul>
                            <font color="#7b1e1e" family="楷体">您的每一条建议都将成为我们的目标与动力。</font>
                        </ul>
                </marquee>
            </div>
    <br><br>
    <s:form action="advise" method="post" >
        <table border="0" align="center" >
             <tr>
                    <s:textfield name="idNumber" label="请输入您的身份证号" size="66"/>
                </tr>
                <tr></tr><tr></tr>
            <tr>
                <td>
                    <s:textarea name="content" label="请提出您宝贵的意见" cols ="50" rows = "5"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" name="reset" value="清除" />
                </td>
            </tr>
        </table>
    </s:form>
    <h2 align=center>感谢您的建议，我们会尽快为您解决！！！</h2>
    <h2 align=center>请您耐心等待❤</h2>
    </div>
    
</body>
</html>
