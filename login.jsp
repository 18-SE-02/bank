<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="村镇银行网络服务中心-登录页"></s:text></title>
        
        <style type="text/css">
         
        a{text-decoration: none;}
        a:link{color: #63a3c8;}
        a:visited{color: #63a3c8;}
        a:hover{color: red;}
        a:active{color: red;}
        .sum{border:1px solid #ffffff;height:600px;width: 600px;margin: 0 auto;background-image: url(C:/Users/Lenovo/Desktop/bank/web/customer/登录页.png);background-size: 100% 100%;}
        .sub ul{margin: 7px auto;}
        .blank{border:1px solid #ffffff;height:200px;width: 600px;margin: 0 auto;}
        
        </style>
        
    </head>
    
    <body>
        <div class="sum">
            <div class="blank"></div>
            <div class="sub">
                <marquee behavior="scoll" loop="infinite" align="middle" scrooldelay="30px" width="600px" height="30px"  hspace="5px" wspace="5px">
                    <ul>
                        <font color="#7b1e1e" family="楷体">欢迎您使用村镇网络银行！我们将为您提供最诚挚的服务！</font>
                    </ul>                
                </marquee>    
            </div>    
            <s:form action="login" method="post">
                <br><br><br>
                <table border="0" align="center">
                    <tr>
                        <td>
                            <s:textfield name="idNumber" label="身份证号" size="30"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <s:password name="password" label="用户密码" size="31"/>
                        </td>
                    </tr>
                    <tr><b>&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;</b></tr>
                    <tr>
                        <td colspan="2" align="center">
                            <b>&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;</b><input type="submit" value="登录"/>
                        </td>
                    </tr>
                    <tr><b>&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;</b></tr>
                    <tr>
                        <td colspan="2" align="center">
                            <s:a href="http://localhost:8080/bank/customer/forgetPassword.jsp"><b>&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;</b>忘记密码?</s:a>
                        </td>
                    </tr>
                </table>   
            </s:form>
        </div>
    </body>
</html>
