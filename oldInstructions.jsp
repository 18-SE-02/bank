<%-- 
    Document   : instructions
    Created on : 2020-5-5, 20:08:05
    Author     : 王师千里不留行
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="网上银行用户须知页"></s:text></title>
        <style>
        #header {
            background-color:transparent;
            color:black;
            text-align:center;
            padding:5px;
        }       
        </style>
    </head>
    <body style="background:url(F:/SSH/bank/web/oldCustomer/oldBgground.jpg);background-size: 100% 100%;background-attachment: fixed">
        <div id="header">
            <h1 style="font-family:'黑体'; font-size:45px;">网上银行用户须知</h1>
        </div>
        <marquee direction="left" align="bottom" style="font-family:'黑体'; font-size:35px;" onmouseout="this.start()" onmouseover="this.stop()" scrollamount="3" scrolldelay="1">温馨提示：请保护好您的个人信息，紧防诈骗</marquee>
        <hr align="center" size="px" width="100%" color="grey">
            <br><br><br>
            <table border="0" align="center" frame="border" align="center" height="100" width="80%" style="font-family:'黑体'; font-size:35px;">
                <tr>
                    <td>
                        <p>1、产品介绍
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;村镇银行网络服务中心是一个基于互联网环境，全天候向您提供账户查询、余额查询、账单查询、转账业务、预约服务、生活缴费等业务的金融服务平台。
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;我们的目的是让您足不出户就能进行自助便捷的金融服务，以减少您在现实网点中排队等号的苦恼。
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>2、开通流程
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;客户携带有效身份证件原件及在我行办理的银行卡，到我行任意网点填写网银开户申请表即可。
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>3、安全提示
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;①请确保您登录的是正确的网址。
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;②妥善保管您的登录账号和密码。请尽量避免使用生日、身份证号、电话号码等与本人身份信息相关的数字作为密码。
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;③认真核对交易信息。在您处理网上转账业务时，请仔细核对收款人的身份信息及转账金额，确认无误后再进行提交等操作。
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;④经常查询账户信息。关注账号内的资金变动，定期检查网银交易记录。
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;⑤不在网吧等公共场所使用网上银行。
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;⑥谨防诈骗信息。及时关注网上银行的公告信息，不要相信任何套用用户名和密码的行为，我行不会以任何名义向用户索要用户信息，如发现异常请及时拨打客服电话。
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>4、温馨提示
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;①用户在我行用同一银行卡的单笔交易限额最高为2000元，日累计金额最高为5万元。超过最高金额请在我行网上服务中进行预约，并按时前往线下网点办理业务。
                        <p>&nbsp;&nbsp;&nbsp;&nbsp;②诸如网银开户、信用卡办理、贷款、大金额交易等业务无法通过网络办理，请用户自行预约并携带电子凭证前往我行线下网点办理。
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                    </td>
                </tr>
            </table>
        <br><br><br><br>
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