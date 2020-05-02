/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerAction;

/**
 *
 * @author Hello
 */

import DAO.CustomerDAO;
import PO.UserInfoPO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class RepaymentAction extends ActionSupport{
    private String idNumber;
    private double repayment;
    private List list;
    private String message="error";

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public double getRepayment() {
        return repayment;
    }

    public void setRepayment(double repayment) {
        this.repayment = repayment;
    }
   

    @Override
    public void validate(){
        int i=0;
	HttpServletRequest request=ServletActionContext.getRequest();
	request.setAttribute("idNumber", getIdNumber());
        CustomerDAO info=new CustomerDAO();
        list=info.queryInfo("idNumber", this.getIdNumber());
        if(list.size()==0){
            addFieldError("idNumber","身份证号码错误！");
        }else{
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
                if(this.getRepayment()>ui.getBalance()){
                    addFieldError("repayment","您的还款金额大于余额，请先进行存款！");
		} else if(this.getRepayment()>ui.getLoan()){
                    addFieldError("repayment","您的还款金额大于贷款金额");
                }
                else if(this.getRepayment()<=ui.getBalance()){
                    ui.setBalance(ui.getBalance()-this.getRepayment());
                    ui.setLoan(ui.getLoan()-this.getRepayment());
                    String update=info.updateInfo(ui);
                    if(update.equals("success")){
                        message="success";
                    }
                }
            }
        } 
    }
    public String execute() throws Exception{
        return message;
    }
}  

