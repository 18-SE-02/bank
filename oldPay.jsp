<%-- 
    Document   : oldPay
    Created on : 2020-5-11, 16:42:22
    Author     : 26363
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>生活缴费</title>
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
                var money = form.money.value;
                if(number==""||number==null){
                    alert("请输入身份证号码");
                    form.idNumber.focus();
                }else{
                    if(money==""||money==null||money<=0){
                        alert("请输入正确的缴费金额");
                        form.money.focus();
                    }
                    else{
                        if(confirm("身份证号码为："+number+";缴费金额为"+money)){
                            form.submit();
                        }
                        
                    }
                }
            }
        </script>
    </head>
   <body style="background:url(F:/SSH/bank/web/oldCustomer/oldBgground.jpg);background-size: 100% 100%;background-attachment: fixed">
        <div id="header">
            <h1 style="font-family:'黑体'; font-size:45px;">村镇银行网络服务中心-生活缴费</h1>
        </div>
        <marquee direction="left" align="bottom" style="font-family:'黑体'; font-size:35px;" onmouseout="this.start()" onmouseover="this.stop()" scrollamount="3" scrolldelay="1">温馨提示：请保护好您的个人信息，紧防诈骗</marquee>
        <s:form action="oldPay" method="post" name="form">
            <br><br><br>
            
             <table border="0" align="center" height="400" width="80%" style="font-family:'黑体'; font-size:35px;">
                 <tr>
                     <td>
                         请选择缴费类型：
                     </td>
                     <td>
                     <s:select style="font-family:'黑体'; font-size:35px;" list="{'水费','电费','天然气费','话费'}" theme="simple" headerKey="水费" headerValue="水费"></s:select>
                     </td>
                 </tr>
                <tr>
                        <s:textfield name="idNumber" label="请再次输入您要取款账户的身份证号码" style="font-family:'黑体'; font-size:50px;" size="30"/>
                </tr>
                <tr>
                        <s:textfield name="money" label="请输入交的费用" style="font-family:'黑体'; font-size:50px;" size="30"/>
                   
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" onClick="doSubmit()" value="确定" style="font-family:'黑体'; font-size:35px;"/>
                        <input type="reset" value="清空" style="font-family:'黑体'; font-size:35px;"/>
                    </td>
                </tr>
            </table>
        </s:form>
    </body>
</html>

