<%-- 
    Document   : success
    Created on : 2020-4-1, 16:13:59
    Author     : 180409-常颖-20182931
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="村镇银行网络服务中心"></s:text></title>
        
        <style type="text/css">
            
        #header {
            background-color:transparent;
            color:black;
            text-align:center;
            padding:5px;
        }

            /*公共css样式*/
            *{margin:0;padding:0;}
            body{border:1px solid purple;font-size:12px;color: #333;}
            ul{list-style: none;}
            .clear{display:block;overflow: hidden; }
            /**/
            .head{border: 1px solid blue;}
            .top{border: 1px solid yellow;}
            .top div{float:left;}
            .top ul{float:right;}
            .top ul li{float:left;}
        
        </style>
        
    </head>
        <div id="header">
            <br>
            <h1>欢迎您来！</h1>
            <br>
        </div>
     <body style="background:url(F:/SSH/bank/web/customer/bgground.jpg);background-size: 100% 100%;background-attachment: fixed">
        <div class="body">
            <div class="head">
                <div class="top clear">
                    <div><span>请选择您需要办理的业务：</span>
                        <s:a href="http://localhost:8080/bank/customer/addMoney.jsp">存款</s:a>
                        <s:a href="http://localhost:8080/bank/customer/loanMoney.jsp">贷款</s:a>
                        <s:a href="http://localhost:8080/bank/customer/withdrawMoney.jsp">取款</s:a>
                        <s:a href="http://localhost:8080/bank/customer/repaymentMoney.jsp">还款</s:a>
                        <s:a href="http://localhost:8080/bank/customer/changePwd.jsp">修改密码</s:a>
                    </div>
                    <ul class="clear">
                        <li><a href="#">网站首页</a></li>
                        <li><a href="#"> 网站导航</a></li>
                        <li><a href="#"> 我的服务</a></li>
                        <li><a href="#"> 意见箱</a></li>
                    </ul>
                </div>
                <div class="head_img"></div>
                <div class="nav"></div>
            </div>
        </div>
                    <br><br>
    <s:form action="inquire" method="post">
         <table align="center" width="30%" border="5" >
                <tr>
                <td>
                    <s:textfield name="idNumber" value="%{#request.idNumber}" label="身份证号码"/>
                </td>
                <td>
                    <input type="submit" value="查询余额">
                </td>
                </tr>
         </table>
    </s:form>
                    <br><br>
    </body>
</html>
