<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>村镇银行网络服务中心-生活缴费</title>
        
        <style type="text/css">
        
        .sum{border:1px solid #ffffff;height:650px;width: 800px;margin: 0 auto;background-image: url(C:/Users/Lenovo/Desktop/bank/web/customer/生活缴费.png);background-size: 100% 100%;}
        .sub ul{margin: 7px auto;}
        .blank{border:1px solid #ffffff;height:200px;width: 800px;margin: 0 auto;}
        
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
    
   <body>
        <div class="sum">
            <div class="blank"></div>
        <div class="sub">
            <marquee behavior="scoll" loop="infinite" align="middle" scrooldelay="30px" width="800px" height="30px"  hspace="5px" wspace="5px">
                        <ul>
                            <font color="#7b1e1e" family="楷体">村镇银行网络服务中心为您服务！您好，您正在进行生活缴费业务，缴费之前请认真查看个人信息及上缴金额。祝您生活愉快！</font>
                        </ul>
                </marquee>
        </div>
        <s:form action="pay" method="post" name="form">
            <br><br><br>
            
             <table class="lamp" border="2" align="center" >
                 <tr>
                     <td>
                         请选择缴费类型：
                     </td>
                     <td>
                     <s:select list="{'水费','电费','天然气费','话费'}" theme="simple" headerKey="水费" headerValue="水费"></s:select>
                     </td>
                 </tr>
                 <tr></tr>
                <tr>
                        <s:textfield name="idNumber" label="请再次输入您要缴费账户的身份证号码" size="20"/>
                </tr>
                <tr></tr>
                <tr>
                        <s:textfield name="money" label="请输入交的费用" size="20"/>
                   
                </tr>
                <tr></tr><tr></tr><tr></tr>
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
