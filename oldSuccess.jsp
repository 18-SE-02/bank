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
                padding:10px;
            }
            
            /*公共css样式*/
            *{margin:0;padding:0;}
            .body{border:0px solid #ffffff;height:900px;width: 1360px;margin: 0 auto;}
            ul{list-style: none;}
            .clear{display:block;overflow: hidden; }
            a{text-decoration: none;}
            /*公共css样式*/
            .head{border: 0px solid #ffffff;}
            .top{border: 0px solid #ffffff;line-height: 35px;}
            .top div{float:left;}
            .top ul{float:right;}
            .top ul li{float:left;}
            .nav{background-color: #a47748;line-height:  70px;}
            .nav ul li{float:left;padding: 0 16px 0 16px;font-size: 45px;font-family: "黑体";}
            .nav a:link{color: #ffffff;}
            .nav a:visited{color:#ffffff;}
            .nav a:hover{font-size: 55px;}
            .nav a:active{color:yellow;}
            .sub ul{margin: 8px auto;}
            .main{border: 0px solid black;}
            .work{float: left;}
            .news{float: right;}            
        
        </style>        
    </head>
    <div id="header">
        <br>
        <h1 style="font-family:'黑体'; font-size:60px;">村镇银行储蓄网络服务中心</h1>
        <br>
    </div>
       
    <body style="font-family:'黑体'; font-size:50px;background:url(oldBgground.jpg);background-size: 100% 100%">        
        <div class="body">            
            <!--head区域开始-->
            <div class="head">                
                <!--top区域开始-->
                <div class="top clear">
                    <div>
                        <ul class="clear">
                            <li></li>
                            <li></li>
                        </ul> 
                    </div>
                    <ul class="clear">                        
                    </ul>                    
                </div><!--top区域结束-->                
                <!--导航区域开始-->
                <div class="nav clear">
                    <ul class="clear" style="font-family:'黑体'; font-size:45px;">
                        <li><s:a href="http://localhost:8080/bank/oldCustomer/oldTransfer.jsp">转账</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/oldCustomer/oldLoantypes.jsp">贷款须知</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/oldCustomer/oldPay.jsp">生活缴费</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/oldCustomer/oldCommonProblem.jsp">常见问题</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/oldCustomer/oldInstructions.jsp">用户须知</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/oldCustomer/oldAdvise.jsp">意见箱</s:a></li>
                        <a class=" btn btn-default" href="oldCustomerHistoryAdvise?idNumber=<s:property value='#request.idNumber'/>">历史建议</i></a>
                    </ul>                
                </div>
                    
                <!--导航区域结束-->
                <!--滚动栏-->
                <div class="sub">
                    <marquee behavior="scoll" loop="infinite" align="middle" scrooldelay="30px" width="1358px" height="60px" bgcolor="#cccccc" hspace="5px" wspace="5px">
                        <ul style="font-family:'黑体'; font-size:45px;">
                            <font color="#7b1e1e" family="楷体">谨防诈骗信息。及时关注网上银行公告信息；不要相信任何套取网上银行用户名和密码的行为，如通过电子邮件、信函、电话等方式索要卡号及密码等。
                        </ul>
                    </marquee>
                </div><!--滚动栏结束-->
            </div><!--head区域结束-->            
            <!--main区域开始-->
            <div class="main clear">                
                <div class="work clear">
                    <ul>                  
                        <li>
                            <s:form action="oldinquire" method="post">
                                <table align="center" width="1358px" height="480px" border="0" style="font-family:'黑体'; font-size:50px;">
                                    <tr align="center" >
                                        <td></td>                                       
                                        <td><b>&thinsp;</b>身份证号码</td>
                                        <td><s:textfield name="idNumber" value="%{#request.idNumber}" style="font-family:'黑体'; font-size:50px;"/></td>
                                    </tr>
                                    <tr colspan="2" align="center">
                                        <td></td>
                                        <td width="200px"><input type="submit" value="查询余额" style="font-family:'黑体'; font-size:50px;"></td>
                                    </tr>
                                </table>
                           </s:form>
                        </li>
                    </ul>    
                </div>                
            </div><!--main区域结束-->                                 
    </body>    
</html>

<html>
    <head>
        <meta charset="utf-8" />
        <style type="text/css">
            #ad{
                width:335px;
                height: 290px;
                background:url(广告.png);
                /*绝对定位放置到浏览器右下角，即使有下拉条时广告弹窗也不会改变位置*/
                position: fixed;
                bottom:0px;
                right: 0px;
                display: none;
            }
        </style>
        <script type="text/javascript">
            
            function init(){
                setTimeout(showAd,2000)
            }
            
            function showAd(){
                var ad = document.getElementById("ad");
                ad.style.display ="block";
            }

            function closeAd(){
                var ad = document.getElementById("ad");
                ad.style.display ="none";
            }
            
        </script>
        
    </head>
    
    <body onload="init()">
            <div id="ad">
                <button onclick="closeAd()">关闭</button>
            </div>
    </body>
</html>