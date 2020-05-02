package customerAction;

import DAO.CustomerDAO;
import PO.UserInfoPO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Random;

/**
 *
 * @author 180409-常颖-20182931
 */
public class RegisterAction extends ActionSupport{
    private String name;
    private String password1;
    private String password2;
    private String telephone;
    private String idNumber;
    private String mess="error";
    private List list;
   
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
        int[] month_to_day ={ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(this.getIdNumber() == null || this.getIdNumber().length() == 0){
            addFieldError("idNumber","身份证号码不能为空！");
        }else if(this.getIdNumber().length() != 18){
            addFieldError("idNumber","身份证号码长度错误！");
        }else if((this.getIdNumber().toCharArray()[17] < '0' || this.getIdNumber().toCharArray()[17] > '9')
                && this.getIdNumber().toCharArray()[17] != 'X' && this.getIdNumber().toCharArray()[17] != 'x'){
            addFieldError("idNumber","身份证号码错误！");
        }else if(judge(this.getIdNumber()) == true){
             addFieldError("idNumber","身份证号码错误！");
        }else {
            int month, day;
            month = ((int)this.getIdNumber().toCharArray()[10] - 48)*10+((int)this.getIdNumber().toCharArray()[11] - 48);
            day = ((int)this.getIdNumber().toCharArray()[12] - 48)*10+((int)this.getIdNumber().toCharArray()[13] - 48);
                if((month > 12) || (day > month_to_day[month-1])){
                addFieldError("idNumber","身份证号码错误！");
            }else{   
                CustomerDAO info=new CustomerDAO();
                list=info.queryInfo("idNumber", this.getIdNumber());
                UserInfoPO ui=new UserInfoPO();
                for(int i=0;i<list.size();i++){
                    ui=(UserInfoPO)list.get(i);
                    if(ui.getIdNumber().equals(this.getIdNumber())){
                        addFieldError("idNumber","身份证号码已存在！");
                        break;
                    }
                }
            }
        }
            
        if(this.getPassword1() == null || this.getPassword1().length() == 0){
            addFieldError("password1","登录密码不允许为空！");
        }else if(judge(this.getPassword1()) == true){
            addFieldError("password1","登录密码只能为数字！");
        }else if(this.getPassword1().length() != 6){
            addFieldError("password1","登录密码长度只能为6！");
        }else if(!this.getPassword1().equals(this.getPassword2())){
            addFieldError("password2","两次密码不一致！");
        }
        
        if(this.getName()==null||this.getName().length()==0){
            addFieldError("name","姓名不允许为空！");
        }else{
            for(int i = 0; i < this.getName().length(); i++){
                if((this.getName().toCharArray()[i]+"").getBytes().length == 1){
                    addFieldError("name","姓名不允许出现字母，数字或字符！");
                    break;
                }
            }
        }
        if(this.getTelephone()==null||this.getTelephone().length()==0){
            addFieldError("telephone","电话不允许为空！");
        }else if(this.getTelephone().length() != 11){
            addFieldError("telephone","电话长度错误！");
        }else if(this.getTelephone().toCharArray()[0] != '1'){
            addFieldError("telephone","电话号码错误！");
        }else{
            for(int i = 0; i < this.getTelephone().length(); i++){
                if(this.getTelephone().toCharArray()[i] > '9' || this.getTelephone().toCharArray()[i] < '0'){
                    addFieldError("telephone","电话号码只能是数字！");
                    break;
                }
            }
        }
    }
    
    public boolean judge(String idnumber){
        for(int i = 0; i <idnumber.length() ; i++){
            if(idnumber.toCharArray()[i] < '0' || idnumber.toCharArray()[i] > '9'){
                return true;
                }
        }
        return false;
    }
    
    
    public UserInfoPO userInfo(){
        UserInfoPO info=new UserInfoPO();
        info.setName(this.getName());
        info.setPassword(this.getPassword1()); 
        info.setIdNumber(this.getIdNumber());
        info.setTelephone(this.getTelephone());
        info.setCardNumber(cardNum());
        return info;
    }
    
    public String cardNum() {
        String[] start = {"4367", "6227", "62288", "6222", "6221", "6013", "4563", "6210", "6222"};
        Random rand = new Random();
        int number = rand.nextInt(9);
        String card = start[number];
        for (int i = start[number].length(); i < 19; i++) {
            card += rand.nextInt(10);
        }
        return card;
    }
   public String execute() throws Exception{
        CustomerDAO dao=new CustomerDAO();
        String ri=dao.saveInfo(userInfo());
        if(ri.equals("success")){
            mess="success";
        }
        return mess;
    }
}
