<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>村镇银行网络服务中心-查询余额</title>
        <style type="text/css">
            .sum{border:1px solid #ffffff;height:642px;width: 1200px;margin: 0 auto;background-image: url(C:/Users/Lenovo/Desktop/bank/web/customer/查询余额.png);background-size: 100% 100%;}
            .header{border:1px solid #ffffff;height:200px;width: 1200px;margin: 0 auto;}
        </style>
    </head>
    <body>
        <div class="sum">
        <div class="header"></div>
            <br><br>
        <table align="center" width="80%" border="5" >
            <tr>
                <th>姓名</th>
                <th>银行卡号</th>
                <th>余额</th>
                <th>贷款</th>
                <th>贷款类型</th>
            </tr>
            <tr>
                <td><center><s:property value="#request.name"/></center></td>
                <td><center><s:property value="#request.cardNumber"/></center></td>
                <td><center><s:property value="#request.balance"/></center></td>
                <td><center><s:property value="#request.loan"/></center></td>
                <td><center><s:property value="#request.loanType"/></center></td>
            </tr>
        </table>
        </div>
    </body>
</html>
