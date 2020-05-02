package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_a_href;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_text_name_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_s_a_href = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_s_text_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("    </head>\n");
      out.write("    <body style=\"background:url(F:/SSH/bank/web/customer/index.png);background-size: 100% 100%;background-attachment: fixed\">\n");
      out.write("        ");
response.setCharacterEncoding("UTF-8");
      out.write("\n");
      out.write("        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      if (_jspx_meth_s_a_0(_jspx_page_context))
        return;
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("        <div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
    _jspx_th_s_text_0.setName("欢迎登录村镇银行网络服务中心");
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
    _jspx_th_s_a_0.setHref("http://localhost:8080/bank/customer/login.jsp");
    int _jspx_eval_s_a_0 = _jspx_th_s_a_0.doStartTag();
    if (_jspx_eval_s_a_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_a_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_a_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_a_0.doInitBody();
      }
      do {
        out.write("<font color=\"#FF8C00\" size=\"6\" face=\"仿宋\">点击进入</font>");
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
}
