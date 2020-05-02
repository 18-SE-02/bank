package customerAction;

import DAO.CustomerDAO;
import com.opensymphony.xwork2.ActionSupport;
import PO.UserInfoPO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport{
    private String idNumber;
    private String password;
    private String message="error";
    private List list;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
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
                        if(ui.getPassword().equals(this.getPassword())){
                            message="success";
                        }else{
                            addFieldError("password","登录密码不正确！");
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
