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
public class LoanAction extends ActionSupport{
    private String idNumber;
    private double loan1;
    private List list;
    private String message="error";

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public double getLoan1() {
        return loan1;
    }

    public void setLoan1(double loan1) {
        this.loan1 = loan1;
    }

    
    
    public void validate(){
        int i=0;
	HttpServletRequest request=ServletActionContext.getRequest();
	request.setAttribute("idNumber", getIdNumber());
        CustomerDAO info=new CustomerDAO();
        list=info.queryInfo("idNumber", this.getIdNumber());
        if(list.size()==0){
            addFieldError("idNumber","身份证号码错误！");
        }else
        {
            UserInfoPO ui=new UserInfoPO();
            int count=0;
            for( i=0;i<list.size();i++){
                count++;
                ui=(UserInfoPO)list.get(i);
                if(this.getIdNumber().equals(ui.getIdNumber())){
                    break;
                }
            }
            if(i!=list.size()){
                ui.setLoan(ui.getLoan()+this.getLoan1());
                String update=info.updateInfo(ui);
                if(update.equals("success")){
                    message="success";
                }
            }
        } 
    }
    public String execute() throws Exception{
        return message;
    }
}
