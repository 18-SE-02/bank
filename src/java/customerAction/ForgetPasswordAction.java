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
public class ForgetPasswordAction extends ActionSupport{
    private String cardNumber;
    private String name;
    private String telephone;
    private String idNumber;
    private List list;
    private String message="error";

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    
    @Override
      public void validate(){
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
                UserInfoPO ui=new UserInfoPO();
                int count=0;
                for(int i=0;i<list.size();i++){
                    count++;
                    ui=(UserInfoPO)list.get(i);
                    if(this.getIdNumber().equals(ui.getIdNumber())){
                        if(!ui.getCardNumber().equals(this.getCardNumber())){
                            addFieldError("cardNumber","卡号不正确！");
                        } else if(!ui.getName().equals(this.getName())){
                            addFieldError("name","姓名不正确！");
                        } else if(!ui.getTelephone().equals(this.getTelephone())){
                            addFieldError("telephone","电话号码不正确！");
                        } else{
                            message="success";
                        }
                    }
                }
            }
        }
    }
    public String execute() throws Exception{
        return message;
    }
}