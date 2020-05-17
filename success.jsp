<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>村镇银行网络服务中心</title>
        
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
            .top1{border: 1px solid #ffffff;height:100px;width: 20px;background-image: url(F:/SSH/bank/web/customer/空.png);background-size: 20px 100px;}
            .top2{border: 1px solid #ffffff;height:100px;width: 650px;background-image: url(F:/SSH/bank/web/customer/logo.png);background-size: 650px 100px;}
            .top3{border: 1px solid #ffffff;height:100px;width: 130px;background-image: url(F:/SSH/bank/web/customer/问题查询.png);background-size: 130px 100px;title:用户须知;}
            .top4{border: 1px solid #ffffff;height:100px;width: 25px;background-image: url(F:/SSH/bank/web/customer/空 .png);background-size: 25px 100px;}
            .top5{border: 1px solid #ffffff;height:100px;width: 130px;background-image: url(F:/SSH/bank/web/customer/意见.png);background-size: 130px 100px;}
            .top6{border: 1px solid #ffffff;height:100px;width: 130px;background-image: url(F:/SSH/bank/web/customer/空.png);background-size: 130px 100px;}
            .nav{background-color: #a47748;line-height:  60px;}
            .nav ul li{float:left;padding: 0 85px 0 85px;font-size: 24px;font-family: "黑体";}
            .nav a:link{color: #ffffff;}
            .nav a:visited{color:#ffffff;}
            .nav a:hover{font-size: 30px;}
            .nav a:active{color:yellow;}
            .sub ul{margin: 7px auto;}
            .main{border: 1px solid #ffffff;}
            .main2{position: absolute;bottom: -85px;left: 1px;border: 1px solid #ffffff;height:298px;width: 470px;background-image: url(F:/SSH/bank/web/customer/表格背景图.png);background-size: 470px 298px;}
            .main1{border: 1px solid #ffffff;height:199px;width: 470px;background-image: url(F:/SSH/bank/web/customer/余额查询窗口.png);background-size: 470px 199px;}
            .work{float: left;}
            .news{float: right;}
            .news{height:500px;width: 876px;background-image: url(F:/SSH/bank/web/customer/新闻网黑.png);background-size: 876px 500px;}
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
                    <div class="clear">
                        <div class="top1 clear"></div>
                        <div class="top2 clear"></div>
                    </div>
                    <ul class="clear">
                        <div class="top3"><s:a href="http://localhost:8080/bank/customer/instructions.jsp"><br><br><font size="2px" color="#000000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户须知</font></s:a></div>
                        <div class="top4"></div>
                        <div class="top5"><a class=" btn btn-default" href="CustomerHistoryAdvise?idNumber=<s:property value='#request.idNumber'/>"><br><br><font size="2px" color="#000000">&nbsp;&nbsp;&nbsp;点击查看历史留言</font></a></div>
                        <div class="top6"></div>
                    </ul>
                </div><!--top区域结束-->
                
                <!--导航区域开始-->
                <div class="nav clear">
                    <ul class="clear">
                        <li><s:a href="http://localhost:8080/bank/customer/transfer.jsp">转账</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/customer/pay.jsp">生活缴费</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/customer/loanTypes.jsp">贷款须知</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/customer/commonProblem.jsp">常见问题查询</s:a></li>
                        <li><s:a href="http://localhost:8080/bank/customer/advise.jsp">意见箱</s:a></li>
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
                    <ul class="clear">
                        <div class="main1 clear"></div>
                        <div class="main2 clear">
                            <s:form action="inquire" method="post">
                                <table align="center" width="470px" height="298px" border="0" style="font-size:28px" style="text-align:center;">
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
                        </div>
                    </ul>    
                </div>
                
                <div class="news">
                    <a href="https://www.chinanews.com/">
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <font color="#000000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击进入新闻网</font><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        </a></div>
                
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
                    <br><br>
                    <li><center>网管信箱：ccut@163.com　投稿信箱：ccut@163.com </center></li><br>
                    <li><center>地址：长春市宽城区奋进乡长春工业大学　版权所有：村镇银行存储　网络实名：村镇银行网络服务中心 </center></li><br>
                    <li><center>京ICP备10052455号 京公网安备110102002036号 </center></li>
                    <li><center></center></li></font>
                </div>
                
            </div><!--foot区域结束-->
            
        </div>
                    
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