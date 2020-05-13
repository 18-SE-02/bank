<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="村镇银行网络服务中心"></s:text></title>
        
        <style type="text/css">
            
            /*公共css样式*/
            *{margin:0;padding:0;}
            .body{border:1px solid #ffffff;height:900px;width: 1360px;margin: 0 auto;}
            ul{list-style: none;}
            .clear{display:block;overflow: hidden; }
            a{text-decoration: none;}
            /*公共css样式*/
            .head{border: 1px solid #ffffff;}
            .top{border: 1px solid #ffffff;line-height: 35px;}
            .top div{float:left;}
            .top ul{float:right;}
            .top ul li{float:left;}
            .nav{background-color: #a47748;line-height:  60px;}
            .nav ul li{float:left;padding: 0 115px 0 115px;font-size: 24px;font-family: "黑体";}
            .nav a:link{color: #ffffff;}
            .nav a:visited{color:#ffffff;}
            .nav a:hover{font-size: 30px;}
            .nav a:active{color:yellow;}
            .sub ul{margin: 7px auto;}
            .main{border: 1px solid #ffffff;}
            .work{float: left;}
            .news{float: right;}
            .foot{border: 1px solid #ffffff; width: 1358px;}
            .link{background-color: #cccccc;height: 53px;}
            .link a:link{color: #63a3c8;}
            .link a:visited{color: #63a3c8;}
            .link a:hover{color: yellow;}
            .link a:active{color: yellow;}
            .book{background-color: #ffffff; width: 1358px; height: 100px;}
        
        </style>
        
    </head>  
    
    <body>
        
        <div class="body">
            
            <!--head区域开始-->
            <div class="head">
                
                <!--top区域开始-->
                <div class="top clear">
                    <div>
                        <ul class="clear">
                            <li><img src="空.png" width="20" height="100"/></li>
                            <li><img src="logo.png"  width="650px" height="100"/></li>
                        </ul> 
                    </div>
                    <ul class="clear">
                        <li><s:a href="http://localhost:8080/bank/customer/instructions.jsp"><img src="问题查询.png" width="130" height="100" alt="用户须知" title="用户须知"/></s:a></li>
                        <li><img src="空.png" width="25" height="100"/></li>
                        <li><s:a href="http://localhost:8080/bank/customer/advise.jsp"><img src="意见.png" width="130" height="100" alt="意见箱" title="意见箱"/></s:a></li>
                        <li><img src="空.png" width="130" height="100"/></li>
                    </ul>
                </div><!--top区域结束-->
                
                <!--导航区域开始-->
                <div class="nav clear">
                    <ul class="clear">
                        <li><s:a href="http://localhost:8080/bank/customer/transfer.jsp">转账</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/customer/Loantypes.jsp">贷款办理</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/customer/pay.jsp">生活缴费</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/customer/commonProblem.jsp">常见问题查询</s:a></li>
                    </ul>                
                </div><!--导航区域结束-->  
                
                <!--滚动栏-->
                <div class="sub">
                    <marquee behavior="scoll" loop="infinite" align="middle" scrooldelay="30px" width="1358px" height="30px" bgcolor="#cccccc" hspace="5px" wspace="5px">
                        <ul>
                            <font color="#7b1e1e" family="楷体">谨防诈骗信息。及时关注网上银行公告信息；不要相信任何套取网上银行用户名和密码的行为，如通过电子邮件、信函、电话等方式索要卡号及密码等。
                        </ul>
                    </marquee>
                </div><!--滚动栏结束-->
                
            </div><!--head区域结束-->
            
            <!--main区域开始-->
            <div class="main clear">
                
                <div class="work clear">
                    <ul>
                        <li><img src="余额查询窗口.png" width="470" height="199"/></li>
                        <li>
                            <s:form action="inquire" method="post">
                                <table align="center" width="470px" height="298px" border="0" background="表格背景图.png" style="font-size:28px" style="text-align:center;">
                                    <tr align="left" >
                                        <td></td>
                                        <td><b>&thinsp;</b>身份证号码</td>
                                        <td><s:textfield name="idNumber" value="%{#request.idNumber}"/></td>
                                    </tr>
                                    <tr align="left">
                                        <td></td>
                                        <td width="200px"><b>&thinsp;&thinsp;&thinsp;</b><input type="submit" value="查询余额" style="height:50px;width: 125px"></td>
                                    </tr>
                                </table>
                           </s:form>
                        </li>
                    </ul>    
                </div>
                
                <div class="news">
                    <a href="https://www.chinanews.com/"><img src="新闻网黑.png" width="876" height="500" alt="点击进入新文网" title="点击进入新文网"/></a>
                </div>
                
            </div><!--main区域结束-->
            
            <!--foot区域开始-->
            <div class="foot">
                
                <div class="link">
                    <li><center>
                        <br>
                        点击文字进入链接：<font color="black">
                        <a href="http://www.icbc.com.cn/icbc/">中国工商银行</a><b>&ensp;</b>|<b>&ensp;</b>
                        <a href="http://www.ccb.com/cn/home/indexv3.html">中国建设银行</a><b>&ensp;</b>|<b>&ensp;</b>
                        <a href="http://www.pbc.gov.cn/">中国人民银行</a><b>&ensp;</b>|<b>&ensp;</b>
                        <a href="http://www.psbc.com/cn/">中国邮政储蓄银行</a><b>&ensp;</b>|<b>&ensp;</b>
                        <a href="http://www.abchina.com/cn/">中国农业银行</a><b>&ensp;</b>|<b>&ensp;</b>
                        <a href="https://www.boc.cn/">中国银行</a>
                        </font></center></li>
                </div>
                
                <div class="book"><font color="grey" size="1px" family="黑体">
                    <br>
                    <li><center>请扫描下方二维码联系我们</center></li><br>
                    <li><center><img src="联系我们.jpg" width="50" height="50"/></center></li><br>
                    <li><center>网管信箱：ccut@163.com　投稿信箱：ccut@163.com </center></li><br>
                    <li><center>地址：长春市宽城区奋进乡长春工业大学　版权所有：村镇银行存储　网络实名：村镇银行网络服务中心 </center></li><br>
                    <li><center>京ICP备10052455号 京公网安备110102002036号 </center></li>
                    <li><center></center></li></font>
                </div>
                
            </div><!--foot区域结束-->
            
        </div>
                    
    </body>
    
</html>
