package bankAdmin;

import java.awt.*;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCustomer extends JDialog implements ActionListener{

	 //定义我需要的swing组件
	JLabel jl2,jl5,jl6,jl7;
	JTextField jf1,jf2,jf5,jf6,jf7;
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;	
	String cardNumber;
	
	//owner代笔父窗口,title是窗口的名字,modal指定是模式窗口()或者非模式窗口
	 public AddCustomer(Frame owner,String title, boolean modal){
		 super(owner,title,modal);
		 jl2 = new JLabel("姓名");
		 jl5 = new JLabel("密码");
		 jl6 = new JLabel("电话号码");
		 jl7 = new JLabel("身份证号码");
		
		 jf2 = new JTextField(20);
		 jf5 = new JTextField(20);
		 jf6 = new JTextField(20);
		 jf7 = new JTextField(20);
		 
		 jb1 = new JButton("添加");
		 jb1.addActionListener(this);
		 jb2 = new JButton("取消");
		 jb2.addActionListener(this);
		 
		 jp1 = new JPanel();
		 jp2 = new JPanel();
		 jp3 = new JPanel();

		 //设置布局
		 jp1.setLayout(new GridLayout(7,1));
		 jp2.setLayout(new GridLayout(7,1));

		 jp3.add(jb1);
		 jp3.add(jb2);

		 jp1.add(jl2);
		 jp1.add(jl5);
		 jp1.add(jl6);
		 jp1.add(jl7);


		 jp2.add(jf2);
		 jp2.add(jf5);
		 jp2.add(jf6);
		 jp2.add(jf7);

		 this.add(jp1, BorderLayout.WEST);
		 this.add(jp2, BorderLayout.CENTER);
		 this.add(jp3, BorderLayout.SOUTH);

		 this.setSize(500,300);
		 this.setVisible(true);
		 this.getContentPane().setLayout(null);
		 this.setLocation(500, 150);
		  
	 }
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == jb1){
			String name,password,telephone,idNum;
			name = jf2.getText();
			password = jf5.getText();
			telephone = jf6.getText();
			idNum = jf7.getText();

	    if(judgeName(name) && judge(password) && judgeTelephone(telephone) && judgeIdnum(idNum)) {
			Connection ct = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try{
				//1.加载驱动
			    Class.forName("com.mysql.jdbc.Driver");
			    System.out.println("加载成功");
			    //2.连接数据库
			    ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");

			    //与编译语句对象

			    String strsql = "insert into customer1 values(?,?,?,?,?,?,?,?,?)";
			    pstmt = ct.prepareStatement(strsql);
			  
			    //给对象赋值
			    pstmt.setString(1,getCardNumber());
			    pstmt.setString(2,jf2.getText());
			    pstmt.setString(3,"0");
			    pstmt.setString(4,"0");
			    pstmt.setString(5,jf5.getText());
			    pstmt.setString(6,jf6.getText());
			    pstmt.setString(7,jf7.getText());
			    pstmt.setString(8,"0");
			    pstmt.setString(9,"0");

			    pstmt.executeUpdate();
			    JOptionPane.showMessageDialog(null, "添加账户成功！", "提示信息",
			              JOptionPane.INFORMATION_MESSAGE);
			    this.dispose();//关闭学生对话框

			   }catch(Exception arg1){
				   arg1.printStackTrace();
			   }finally{
				   try{
					   if(rs!=null){
						   rs.close();
						   rs = null;
					   }
					   if(pstmt != null){
						   pstmt.close();
						   pstmt = null;
					   }
					   if(ct != null){
						   ct.close();
						   ct = null;
					   }
				   }catch(Exception arg2){
					   arg2.printStackTrace();
				   }
			   }
		}}
		
		else if(arg0.getSource() == jb2){
			System.out.println("你选择了取消");
			this.dispose();//关闭添加对话框
		}
		
	}

	
	public boolean judgeIdnum(String idNum){
		int count=0;
		int[] month_to_day ={ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(idNum == null || idNum.length() == 0){
        	JOptionPane.showMessageDialog(null, "请输入身份证号码", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
        }else if(idNum.length() != 18){
        	JOptionPane.showMessageDialog(null, "身份证号码长度错误！", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
        }else if((idNum.toCharArray()[17] < '0' || idNum.toCharArray()[17] > '9')
                && idNum.toCharArray()[17] != 'X' && idNum.toCharArray()[17] != 'x'){
        	JOptionPane.showMessageDialog(null, "身份证号码错误！", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
        }else if(judge(idNum) == true){
        	JOptionPane.showMessageDialog(null, "身份证号码错误！", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
        }else {
            int month, day;
            month = ((int)idNum.toCharArray()[10] - 48)*10+((int)idNum.toCharArray()[11] - 48);
            day = ((int)idNum.toCharArray()[12] - 48)*10+((int)idNum.toCharArray()[13] - 48);
                if((month > 12) || (day > month_to_day[month-1])){
                	JOptionPane.showMessageDialog(null, "身份证号码错误！", "提示信息",
  			              JOptionPane.INFORMATION_MESSAGE);
            }else if(judgeAdult(idNum) == true){  
            	JOptionPane.showMessageDialog(null, "您是未成年人，禁止注册！", "提示信息",
			              JOptionPane.INFORMATION_MESSAGE);
            	}else {
            	try {
					Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
					// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
					System.out.println("数据库连接成功");
					
					Statement stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery("select * from customer1");

					while (rs.next()) {
						if (idNum.equals(rs.getString("idNumber")) ) {
							JOptionPane.showMessageDialog(null, "该身份证号码已存在", "提示信息",
			  			              JOptionPane.INFORMATION_MESSAGE);
							count=1;
						}
					}
					
					if(count==0) {
						return true;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        }
        return false;
    }
	
	public boolean judgePassword(String password) {
		if(password == null || password.length() == 0){
			JOptionPane.showMessageDialog(null, "密码不允许为空！", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else {
            
        	try {
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
				// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
				System.out.println("数据库连接成功");
				
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery("select * from customer1");
	


			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    return true;
}
	
	public boolean judgeTelephone(String telephone) {
		int count = 0;
		if(telephone == null || telephone.length() == 0){
			JOptionPane.showMessageDialog(null, "电话号码不允许为空！", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
        }else if(telephone.length() != 11){
        	JOptionPane.showMessageDialog(null, "电话号码长度错误！", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
        }else if(telephone.toCharArray()[0] != '1'){
        	JOptionPane.showMessageDialog(null, "电话号码错误！", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
        }else if(judge3(telephone)==true){
        	JOptionPane.showMessageDialog(null, "电话号码只能是数字！", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
        }else{  
        	try {
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
				// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
				System.out.println("数据库连接成功");
				
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery("select * from customer1");

				while (rs.next()) {
					if (telephone.equals(rs.getString("telephone")) ) {
						JOptionPane.showMessageDialog(null, "该电话号码已存在", "提示信息",
		  			              JOptionPane.INFORMATION_MESSAGE);
						count=1;
					}
				}
				
				if(count==0) {
					return true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	
    return false;
}
        
    
	
	public boolean judgeName(String name){
		int count = 0;
        if(name == null || name.length() == 0){
        	JOptionPane.showMessageDialog(null, "姓名不允许为空！", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
        }else if(judge2(name)==true){
        	JOptionPane.showMessageDialog(null, "姓名不允许出现字母，数字或字符！", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
        }else {    
            	try {
					Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
					// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
					System.out.println("数据库连接成功");
					
					Statement stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery("select * from customer1");

					while (rs.next()) {
						if (name.equals(rs.getString("name")) ) {
							JOptionPane.showMessageDialog(null, "该姓名已存在", "提示信息",
			  			              JOptionPane.INFORMATION_MESSAGE);
							count=1;
						}
					}
					
					if(count==0) {
						return true;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
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
	
	public boolean judge2(String name) {
		for(int i = 0; i <name.length(); i++){
        if((name.toCharArray()[i]+"").getBytes().length == 1){
             return true;
         }
        
		}
		return false;
	}
	
	public boolean judge3(String telephone) {
		for(int i = 0; i < telephone.length(); i++){
            if(telephone.toCharArray()[i] > '9' || telephone.toCharArray()[i] < '0'){
            	return true;
            }
		}
		return false;
	}
	
	public String getCardNumber() {
		 String[] start = {"4367", "6227", "62288", "6222", "6221", "6013", "4563", "6210", "6222"};
	     Random rand = new Random();
	     int number = rand.nextInt(9);
	     cardNumber = start[number];
	     for (int i = start[number].length(); i < 19; i++) {
	    	 cardNumber += rand.nextInt(10);
	     }
	     return cardNumber;
	}
	
	public boolean judgeAdult(String idNumber) {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//获取系统时间
		String localdate = df.format(date);
		int year = ((int)localdate.toCharArray()[0] - 48) * 1000 + ((int)localdate.toCharArray()[1] -48) * 100
				+((int)localdate.toCharArray()[2] - 48)*10 +(int)localdate.toCharArray()[3] - 48 ;
		int born = ((int)idNumber.toCharArray()[6] - 48) * 1000 + ((int)idNumber.toCharArray()[7] -48) * 100
				+((int)idNumber.toCharArray()[8] - 48)*10 +(int)idNumber.toCharArray()[9] - 48 ;
		if(year - born >= 18) {
			return false;
		}
		return true;
	}
}
