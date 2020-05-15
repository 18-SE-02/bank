/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerAction;

import DAO.LeaveMessageDAO;
import PO.LeaveMessage;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Administrator
 */
public class HistoryAdviseAction extends ActionSupport{
    private String idNumber;
    private List list;
    private String message="error";

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    
    public void validate() {
        int i;
        //获取request，并添加信息
	HttpServletRequest request=ServletActionContext.getRequest();
	request.setAttribute("idNumber", getIdNumber());
        LeaveMessageDAO dao=new LeaveMessageDAO();
        list=dao.queryInfo("idNum", this.getIdNumber());
        LeaveMessage ui=new LeaveMessage();
        int count=0;
        for(i=0;i<list.size();i++){
            count++;
            ui=(LeaveMessage)list.get(i);
            if(this.getIdNumber().equals(ui.getIdNum())){
                break;
            }
        }
        if(i!=list.size()){
            request.setAttribute("date", ui.getDate());
            request.setAttribute("message", ui.getMessage());
            request.setAttribute("reply", ui.getReply());
            if(ui.getLook()==0){
                 request.setAttribute("look", "客服未读");
            }else{
                request.setAttribute("look", "客服已读");
            }
            message="success";
        }
    }
    
    public String execute() throws Exception{
            return message;
    }
}
