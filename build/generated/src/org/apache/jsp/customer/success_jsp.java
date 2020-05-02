package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class success_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_textfield_value_name_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_form_method_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_a_href;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_text_name_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_s_textfield_value_name_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_s_form_method_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_s_a_href = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_s_text_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_s_textfield_value_name_label_nobody.release();
    _jspx_tagPool_s_form_method_action.release();
    _jspx_tagPool_s_a_href.release();
    _jspx_tagPool_s_text_name_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>");
      if (_jspx_meth_s_text_0(_jspx_page_context))
        return;
      out.write("</title>\n");
      out.write("        \n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            \n");
      out.write("        #header {\n");
      out.write("            background-color:transparent;\n");
      out.write("            color:black;\n");
      out.write("            text-align:center;\n");
      out.write("            padding:5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("            /*公共css样式*/\n");
      out.write("            *{margin:0;padding:0;}\n");
      out.write("            body{border:1px solid purple;font-size:12px;color: #333;}\n");
      out.write("            ul{list-style: none;}\n");
      out.write("            .clear{display:block;overflow: hidden; }\n");
      out.write("            /**/\n");
      out.write("            .head{border: 1px solid blue;}\n");
      out.write("            .top{border: 1px solid yellow;}\n");
      out.write("            .top div{float:left;}\n");
      out.write("            .top ul{float:right;}\n");
      out.write("            .top ul li{float:left;}\n");
      out.write("        \n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <br>\n");
      out.write("            <h1>欢迎您来！</h1>\n");
      out.write("            <br>\n");
      out.write("        </div>\n");
      out.write("     <body style=\"background:url(bgground.jpg);background-size: 100% 100%;background-attachment: fixed\">\n");
      out.write("        <div class=\"body\">\n");
      out.write("            <div class=\"head\">\n");
      out.write("                <div class=\"top clear\">\n");
      out.write("                    <div><span>请选择您需要办理的业务：</span>\n");
      out.write("                        ");
      if (_jspx_meth_s_a_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_s_a_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_s_a_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_s_a_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_s_a_4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <ul class=\"clear\">\n");
      out.write("                        <li><a href=\"#\">网站首页</a></li>\n");
      out.write("                        <li><a href=\"#\"> 网站导航</a></li>\n");
      out.write("                        <li><a href=\"#\"> 我的服务</a></li>\n");
      out.write("                        <li><a href=\"#\"> 意见箱</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"head_img\"></div>\n");
      out.write("                <div class=\"nav\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                    <br><br>\n");
      out.write("    ");
      if (_jspx_meth_s_form_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    <br><br>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_text_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_text_0 = (org.apache.struts2.views.jsp.TextTag) _jspx_tagPool_s_text_name_nobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_text_0.setPageContext(_jspx_page_context);
    _jspx_th_s_text_0.setParent(null);
    _jspx_th_s_text_0.setName("村镇银行网络服务中心");
    int _jspx_eval_s_text_0 = _jspx_th_s_text_0.doStartTag();
    if (_jspx_th_s_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_0);
      return true;
    }
    _jspx_tagPool_s_text_name_nobody.reuse(_jspx_th_s_text_0);
    return false;
  }

  private boolean _jspx_meth_s_a_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_a_0 = (org.apache.struts2.views.jsp.ui.AnchorTag) _jspx_tagPool_s_a_href.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_a_0.setPageContext(_jspx_page_context);
    _jspx_th_s_a_0.setParent(null);
    _jspx_th_s_a_0.setHref("http://localhost:8080/bank/customer/addMoney.jsp");
    int _jspx_eval_s_a_0 = _jspx_th_s_a_0.doStartTag();
    if (_jspx_eval_s_a_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_a_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_a_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_a_0.doInitBody();
      }
      do {
        out.write('存');
        out.write('款');
        int evalDoAfterBody = _jspx_th_s_a_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_a_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_s_a_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_a_href.reuse(_jspx_th_s_a_0);
      return true;
    }
    _jspx_tagPool_s_a_href.reuse(_jspx_th_s_a_0);
    return false;
  }

  private boolean _jspx_meth_s_a_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_a_1 = (org.apache.struts2.views.jsp.ui.AnchorTag) _jspx_tagPool_s_a_href.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_a_1.setPageContext(_jspx_page_context);
    _jspx_th_s_a_1.setParent(null);
    _jspx_th_s_a_1.setHref("http://localhost:8080/bank/customer/loanMoney.jsp");
    int _jspx_eval_s_a_1 = _jspx_th_s_a_1.doStartTag();
    if (_jspx_eval_s_a_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_a_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_a_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_a_1.doInitBody();
      }
      do {
        out.write('贷');
        out.write('款');
        int evalDoAfterBody = _jspx_th_s_a_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_a_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_s_a_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_a_href.reuse(_jspx_th_s_a_1);
      return true;
    }
    _jspx_tagPool_s_a_href.reuse(_jspx_th_s_a_1);
    return false;
  }

  private boolean _jspx_meth_s_a_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_a_2 = (org.apache.struts2.views.jsp.ui.AnchorTag) _jspx_tagPool_s_a_href.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_a_2.setPageContext(_jspx_page_context);
    _jspx_th_s_a_2.setParent(null);
    _jspx_th_s_a_2.setHref("http://localhost:8080/bank/customer/withdrawMoney.jsp");
    int _jspx_eval_s_a_2 = _jspx_th_s_a_2.doStartTag();
    if (_jspx_eval_s_a_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_a_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_a_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_a_2.doInitBody();
      }
      do {
        out.write('取');
        out.write('款');
        int evalDoAfterBody = _jspx_th_s_a_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_a_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_s_a_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_a_href.reuse(_jspx_th_s_a_2);
      return true;
    }
    _jspx_tagPool_s_a_href.reuse(_jspx_th_s_a_2);
    return false;
  }

  private boolean _jspx_meth_s_a_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_a_3 = (org.apache.struts2.views.jsp.ui.AnchorTag) _jspx_tagPool_s_a_href.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_a_3.setPageContext(_jspx_page_context);
    _jspx_th_s_a_3.setParent(null);
    _jspx_th_s_a_3.setHref("http://localhost:8080/bank/customer/repaymentMoney.jsp");
    int _jspx_eval_s_a_3 = _jspx_th_s_a_3.doStartTag();
    if (_jspx_eval_s_a_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_a_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_a_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_a_3.doInitBody();
      }
      do {
        out.write('还');
        out.write('款');
        int evalDoAfterBody = _jspx_th_s_a_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_a_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_s_a_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_a_href.reuse(_jspx_th_s_a_3);
      return true;
    }
    _jspx_tagPool_s_a_href.reuse(_jspx_th_s_a_3);
    return false;
  }

  private boolean _jspx_meth_s_a_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:a
    org.apache.struts2.views.jsp.ui.AnchorTag _jspx_th_s_a_4 = (org.apache.struts2.views.jsp.ui.AnchorTag) _jspx_tagPool_s_a_href.get(org.apache.struts2.views.jsp.ui.AnchorTag.class);
    _jspx_th_s_a_4.setPageContext(_jspx_page_context);
    _jspx_th_s_a_4.setParent(null);
    _jspx_th_s_a_4.setHref("http://localhost:8080/bank/customer/changePwd.jsp");
    int _jspx_eval_s_a_4 = _jspx_th_s_a_4.doStartTag();
    if (_jspx_eval_s_a_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_a_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_a_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_a_4.doInitBody();
      }
      do {
        out.write("修改密码");
        int evalDoAfterBody = _jspx_th_s_a_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_a_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_s_a_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_a_href.reuse(_jspx_th_s_a_4);
      return true;
    }
    _jspx_tagPool_s_a_href.reuse(_jspx_th_s_a_4);
    return false;
  }

  private boolean _jspx_meth_s_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:form
    org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_form_0 = (org.apache.struts2.views.jsp.ui.FormTag) _jspx_tagPool_s_form_method_action.get(org.apache.struts2.views.jsp.ui.FormTag.class);
    _jspx_th_s_form_0.setPageContext(_jspx_page_context);
    _jspx_th_s_form_0.setParent(null);
    _jspx_th_s_form_0.setAction("inquire");
    _jspx_th_s_form_0.setMethod("post");
    int _jspx_eval_s_form_0 = _jspx_th_s_form_0.doStartTag();
    if (_jspx_eval_s_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_form_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_form_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_form_0.doInitBody();
      }
      do {
        out.write("\n");
        out.write("         <table align=\"center\" width=\"30%\" border=\"5\" >\n");
        out.write("                <tr>\n");
        out.write("                <td>\n");
        out.write("                    ");
        if (_jspx_meth_s_textfield_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_s_form_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                </td>\n");
        out.write("                <td>\n");
        out.write("                    <input type=\"submit\" value=\"查询余额\">\n");
        out.write("                </td>\n");
        out.write("                </tr>\n");
        out.write("         </table>\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_s_form_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_form_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_s_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_form_method_action.reuse(_jspx_th_s_form_0);
      return true;
    }
    _jspx_tagPool_s_form_method_action.reuse(_jspx_th_s_form_0);
    return false;
  }

  private boolean _jspx_meth_s_textfield_0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:textfield
    org.apache.struts2.views.jsp.ui.TextFieldTag _jspx_th_s_textfield_0 = (org.apache.struts2.views.jsp.ui.TextFieldTag) _jspx_tagPool_s_textfield_value_name_label_nobody.get(org.apache.struts2.views.jsp.ui.TextFieldTag.class);
    _jspx_th_s_textfield_0.setPageContext(_jspx_page_context);
    _jspx_th_s_textfield_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_form_0);
    _jspx_th_s_textfield_0.setName("idNumber");
    _jspx_th_s_textfield_0.setValue("%{#request.idNumber}");
    _jspx_th_s_textfield_0.setLabel("身份证号码");
    int _jspx_eval_s_textfield_0 = _jspx_th_s_textfield_0.doStartTag();
    if (_jspx_th_s_textfield_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_textfield_value_name_label_nobody.reuse(_jspx_th_s_textfield_0);
      return true;
    }
    _jspx_tagPool_s_textfield_value_name_label_nobody.reuse(_jspx_th_s_textfield_0);
    return false;
  }
}
