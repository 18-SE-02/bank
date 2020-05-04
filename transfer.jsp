<%-- 
    Document   : transfer
    Created on : 2020-5-3, 22:05:16
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function doSubmit(){
                var number1 = form.idNumber1.value;
                var number2 = form.idNumber2.value;
                var money = form.money.value;
                if(number1==""||number1==null){
                    alert("请输入您的身份证号码");
                    form.idNumber1.focus();
                }else{
                    if(number2==""||number2==null){
                        alert("请输入您要转入账户的身份证号码");
                        form.idNumber2.focus();
                    }else{
                        if(number1==number2){
                            alert("两个身份证号码不应相同");
                        }
                        else{
                        if(money==""||money==null||money<=0){
                            alert("请输入正确的存入金额");
                            form.money.focus();
                        }
                        else{
                            if(confirm("您的身份证号码为："+number1+";您要转入的账户为:"+number2+"您要转账的金额为"+money)){
                                form.submit();
                            }
                        } 
                        }
                    }
                }
            }
        </script>
    </head>
    <body style="background:url(F:/SSH/bank/web/customer/bgground.jpg);background-size: 100% 100%;background-attachment: fixed">
        <div id="header">
            <h1>村镇银行网络服务中心-转账服务</h1>
        </div>
        <s:form action="transfer" method="post" name="form">
            <br><br><br>
             <table border="1" align="center">
                  <tr>
                    <s:textfield name="idNumber1" label="请输入您的身份证号码"/>
                </tr>
                <tr>
                    <s:textfield name="idNumber2" label="请输入您要转入账户的身份证号码"/>
                </tr>
                <tr>
                    <s:textfield name="money" label="请输入您要转账的金额"/>
                </tr>
                <tr>
                     <s:password name="password" label="请再次输入密码"/>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" onClick="doSubmit()" value="确定"/>
                        <input type="reset" value="清空"/>
                    </td>
                </tr>
            </table>
        </s:form>
    </body>
</html>
