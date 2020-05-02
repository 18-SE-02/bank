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
public class InquireAction extends ActionSupport{
    private String idNumber;
    private List list;
    private String message="error";

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    
    @Override
    public void validate() {
        int i;
        //获取request，并添加信息
	HttpServletRequest request=ServletActionContext.getRequest();
	request.setAttribute("idNumber", getIdNumber());
        CustomerDAO info=new CustomerDAO();
        list=info.queryInfo("idNumber", this.getIdNumber());
        UserInfoPO ui=new UserInfoPO();
        int count=0;
        for(i=0;i<list.size();i++){
            count++;
            ui=(UserInfoPO)list.get(i);
            if(this.getIdNumber().equals(ui.getIdNumber())){
                break;
            }
        }
        if(i!=list.size()){
            request.setAttribute("cardNumber", ui.getCardNumber());
            request.setAttribute("balance", ui.getBalance());
            request.setAttribute("loan", ui.getLoan());
            request.setAttribute("name", ui.getName());
            message="success";
        }
    }
    
    public String execute() throws Exception{
            return message;
    }
    
}
