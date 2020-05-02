/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerAction;

import DAO.CustomerDAO;
import PO.UserInfoPO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Administrator
 */
public class ChangePasswordAction extends ActionSupport{
    private String idNumber;
    private String password1;
    private String password2;
    private String mess="error";
    private List list;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
      @Override
      public void validate(){
        UserInfoPO ui=new UserInfoPO();
        //获取request，并添加信息
	HttpServletRequest request=ServletActionContext.getRequest();
	request.setAttribute("idNumber", getIdNumber());
        if(this.getIdNumber()==null||this.getIdNumber().length()==0){
            addFieldError("idNumber","身份证号码不能为空！");
        }else{
            CustomerDAO info=new CustomerDAO();
            list=info.queryInfo("idNumber", this.getIdNumber());
            if(list.size()==0){
                addFieldError("idNumber","该用户尚未注册！");
            }else{
                int count=0;
                for(int i=0;i<list.size();i++){
                    count++;
                    ui=(UserInfoPO)list.get(i);
                    if(this.getIdNumber().equals(ui.getIdNumber())){
                        if(CheckPassword()){
                            ui.setPassword(this.getPassword1());
                            String update=info.updateInfo(ui);
                            if(update.equals("success")){
                            mess="success";
                            }
                        }
                    }
                }
            }
        }
    }
      
      public boolean CheckPassword(){
          if(this.getPassword1() == null || this.getPassword1().length() == 0){
            addFieldError("password1","登录密码不允许为空！");
        }else if(judge(this.getPassword1()) == true){
            addFieldError("password1","登录密码只能为数字！");
        }else if(this.getPassword1().length() != 6){
            addFieldError("password1","登录密码长度只能为6！");
        }else if(!this.getPassword1().equals(this.getPassword2())){
            addFieldError("password2","两次密码不一致！");
        } else{
            return true;
        }
        return false;
      }
      
    public boolean judge(String idnumber){
        for(int i = 0; i <idnumber.length() ; i++){
            if(idnumber.toCharArray()[i] < '0' || idnumber.toCharArray()[i] > '9'){
                return true;
                }
        }
        return false;
    }
      
    public String execute() throws Exception{
        return mess;
    }
}