<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>村镇银行网络服务中心-查看历史留言</title>
        <style type="text/css">
            .sum{border:1px solid #ffffff;height:642px;width: 1200px;margin: 0 auto;background-image: url(C:/Users/Lenovo/Desktop/bank/web/customer/历史意见.png);background-size: 100% 100%;}
            .header{border:1px solid #ffffff;height:200px;width: 1200px;margin: 0 auto;}
        </style>
    </head>
    <body>
        <div class="sum">
        <div class="header">
        </div>
            <br><br>
        <table align="center" width="80%" border="5" >
            <tr>
                <th>身份证号码</th>
                <th>历史留言日期</th>
                <th>历史留言</th>
                <th>客服是否查看</th>
                <th>客服回复</th>
            </tr>
            <tr>
                <td><s:property value="#request.idNumber"/></td>
                <td><s:property value="#request.date"/></td>
                <td><s:property value="#request.message"/></td>
                <td><s:property value="#request.look"/></td>
                <td><s:property value="#request.reply"/></td>
            </tr>
        </table>
        </div>
    </body>
</html>
