<%-- 
    Document   : addMoney
    Created on : 2020-4-19, 10:23:54
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>存款</title>
        <style>
        #header {
            background-color:transparent;
            color:black;
            text-align:center;
            padding:5px;
        }       
        </style>
        <style>
        table.lamp {
            width:30%;
            border:1px solid #d4d4d4;
        }
        table.lamp th, td { 
            padding:10px;
        }
        table.lamp th {
            width:40px;
        }
        </style>
        <script type="text/javascript">
            function doSubmit(){
                var number = form.idNumber.value;
                var money = form.balance1.value;
                if(number==""||number==null){
                    alert("请输入身份证号码");
                    form.idNumber.focus();
                }else{
                    if(money==""||money==null||money<=0){
                        alert("请输入正确的存入金额");
                        form.balance.focus();
                    }
                    else{
                        if(confirm("身份证号码为："+number+";存入金额为"+money)){
                            form.submit();
                        }
                        
                    }
                }
            }
        </script>
    </head>
    <body style="background:url(F:/SSH/bank/web/customer/bgground.jpg);background-size: 100% 100%;background-attachment: fixed">
        <div id="header">
            <h1>村镇银行网络服务中心-存款</h1>
        </div>
        <s:form action="add" method="post" name="form">
            <br><br><br>
             <table class="lamp" border="1" align="center">
                <tr>
                        <s:textfield name="idNumber" label="请再次输入您要存款账户的身份证号码" size="20"/>
                   
                </tr>
                <tr>
                        <s:textfield name="balance1" label="金额" size="20"/>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" onClick="doSubmit()" value="确定"/>
                    </td>
                </tr>
                <tr>
                        <s:a href="http://localhost:8080/bank/customer/success.jsp">返回</s:a>
                </tr>
            </table>
        </s:form>
    </body>
</html>
