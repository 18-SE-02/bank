<%-- 
    Document   : repayment
    Created on : 2020-4-22, 15:45:08
    Author     : Hello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function doSubmit(){
                var number = form.idNumber.value;
                var money = form.repayment.value;
                if(number==""||number==null){
                    alert("请输入身份证号码");
                    form.idNumber.focus();
                }else{
                    if(money==""||money==null||money<=0){
                        alert("请输入正确的还款金额");
                        form.balance.focus();
                    }
                    else{
                        if(confirm("身份证号码为："+number+";还款金额为"+money)){
                            form.submit();
                        }
                        
                    }
                }
            }
        </script>
    </head>
    <body style="background:url(F:/SSH/bank/web/customer/bgground.jpg);background-size: 100% 100%;background-attachment: fixed">
        <s:form action="repayment" method="post" name="form">
            <br><br><br>
            <table border="1" align="center">
                 <tr>
                    <td>
                        <s:textfield name="idNumber" label="请再次输入您要还款账户的身份证号码" size="20"/>
                    </td>
                    <td>
                        <s:textfield name="repayment" label="要还款金额" size="20"/>
                    </td>
                    <td>
                        <input type="button" onClick="doSubmit()" value="确定"/>
                    </td>
                </tr>
            </table>
        </s:form>
    </body>
</html>
