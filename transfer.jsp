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
        
        <style type="text/css">
        
        .sum{border:1px solid #ffffff;height:650px;width: 800px;margin: 0 auto;background-image: url(C:/Users/Lenovo/Desktop/bank/web/customer/转账.png);background-size: 100% 100%;}
        .sub ul{margin: 7px auto;}
        .blank{border:1px solid #ffffff;height:200px;width: 800px;margin: 0 auto;}
        
        </style>
    </head>
    <body>
        <div class="sum">
            <div class="blank"></div>
        <div class="sub">
            <marquee behavior="scoll" loop="infinite" align="middle" scrooldelay="30px" width="800px" height="30px"  hspace="5px" wspace="5px">
                        <ul>
                            <font color="#7b1e1e" family="楷体">您正在进行转账业务，请认真核对所填信息！</font>
                        </ul>
                </marquee>
        </div>
        <s:form action="transfer" method="post" name="form">
            <br><br>
             <table border="2" align="center">
                  <tr>
                    <s:textfield name="idNumber1" label="请输入您的身份证号码" size="20px" />
                </tr>
                <tr></tr>
                <tr>
                    <s:textfield name="idNumber2" label="请输入您要转入账户的身份证号码" size="20px"/>
                </tr>
                <tr></tr>
                <tr>
                    <s:textfield name="money" label="请输入您要转账的金额" size="20px"/>
                </tr>
                <tr></tr>
                <tr>
                     <s:password name="password" label="请再次输入密码" size="40px"/>
                </tr>
                <tr></tr><tr></tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" onClick="doSubmit()" value="确定"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="清空"/>
                    </td>
                </tr>
            </table>
        </s:form>
        </div>   
    </body>
</html>
