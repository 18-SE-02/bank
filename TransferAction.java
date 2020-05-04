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
public class TransferAction extends ActionSupport{
    private String idNumber1;
    private String idNumber2;
    private String password;
    private double money;
    private List list1;
    private List list2;
    private String message="error";

    public String getIdNumber1() {
        return idNumber1;
    }

    public void setIdNumber1(String idNumber1) {
        this.idNumber1 = idNumber1;
    }

    public String getIdNumber2() {
        return idNumber2;
    }

    public void setIdNumber2(String idNumber2) {
        this.idNumber2 = idNumber2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
     @Override
    public void validate(){
        int i=0,j=0;
        UserInfoPO ui1=new UserInfoPO();
        UserInfoPO ui2=new UserInfoPO();
	HttpServletRequest request=ServletActionContext.getRequest();
	request.setAttribute("idNumber", getIdNumber1());
        CustomerDAO info=new CustomerDAO();
        list1=info.queryInfo("idNumber", this.getIdNumber1());
        if(list1.size()==0){
            addFieldError("idNumber1","您的身份证号码错误！");
        }else{
            list2=info.queryInfo("idNumber", this.getIdNumber2());
            if(list2.size()==0){
                addFieldError("idNumber2","转入账户身份证号码错误！");
            }else{
                for( i=0;i<list1.size();i++){
                    ui1=(UserInfoPO)list1.get(i);
                    if(this.getIdNumber1().equals(ui1.getIdNumber())){
                        break;
                    }
                }
                for( j=0;j<list2.size();j++){
                    ui2=(UserInfoPO)list2.get(i);
                    if(this.getIdNumber2().equals(ui2.getIdNumber())){
                        break;
                    }
                }
                if(i!=list1.size()&&j!=list2.size()){
                    if(getMoney()>ui1.getBalance()){
                        addFieldError("money","您的转账金额大于总余额！");
                    }
                    else if(!getPassword().equals(ui1.getPassword())){
                        addFieldError("password","您的账户密码错误！");
                    }
                    else{
                        ui1.setBalance(ui1.getBalance()-this.getMoney());
                        String update1=info.updateInfo(ui1);
                        ui2.setBalance(ui2.getBalance()+this.getMoney());
                        String update2=info.updateInfo(ui2);
                        if(update1.equals("success")&&update2.equals("success")){
                            request.setAttribute("successMessage", "转账成功");
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