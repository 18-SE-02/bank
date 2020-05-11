package bankAdmin;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Loan extends JDialog implements ActionListener{

	JLabel jl1,jl2;
	JTextField jf1;
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	PreparedStatement ps;
	String cardNumber;
	Double loan;
	JComboBox jcombo;
	JList jlist;
	String type;
	int loanType;
	
	 public Loan(Frame owner,String title, boolean modal,CustomerModel cm,int rowNum){
		 super(owner,title,modal);
		 jl1 = new JLabel("贷款金额");
		 jl2 = new JLabel("贷款类型");
		 String [] type = {"助学贷款","个人助业贷款","个人汽车贷款","个人综合消费贷款","个体工商户创业贷款","企业保证贷款"}; 
		 jcombo = new JComboBox(type);
		 jlist = new JList(type);
		 jcombo.addActionListener(this);
		 
		 cardNumber=(String)cm.getValueAt(rowNum, 0);
		 loan = (double)cm.getValueAt(rowNum, 3);
		 jf1 = new JTextField(20);
		 jb1 = new JButton("贷款");
		 jb1.addActionListener(this);
		 jb2 = new JButton("取消");
		 jb2.addActionListener(this);
		 
		 jp1 = new JPanel();
		 jp2 = new JPanel();
		 jp3 = new JPanel();
		 
		 //设置布局
		 jp1.setLayout(new GridLayout(2,1));
		 jp2.setLayout(new GridLayout(2,1));
		 
		 jp3.add(jb1);
		 jp3.add(jb2);
		
		 
		  jp1.add(jl1);
		  jp1.add(jl2);
		
		  jp2.add(jf1);
		  jp2.add(jcombo);
		  
		  this.add(jp1, BorderLayout.WEST);
		  this.add(jp2, BorderLayout.CENTER);
		  this.add(jp3, BorderLayout.SOUTH);
		  
		  this.setSize(400,150);
		  this.setVisible(true);
		 
	 }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(loan!=0) {
			JOptionPane.showMessageDialog(null, "贷款失败，请先还清当前贷款", "提示信息",
		              JOptionPane.INFORMATION_MESSAGE);
			this.dispose();//关闭对话框
		}
		
		if(arg0.getSource() == jb1){
			   Connection ct = null;
			   PreparedStatement pstmt = null;
			   ResultSet rs = null;
			   Statement stmt = null;
			
			try{
				//1.加载驱动
			    Class.forName("com.mysql.jdbc.Driver");
			    System.out.println("加载成功");
			    //2.连接数据库
			    ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
			    stmt = ct.createStatement();
			    
			    loan = loan+Double.parseDouble(jf1.getText());
				String sql = "update customer1 set loan= '" + loan + "' where cardNumber= '" + cardNumber + "'";
				String sql1 = "update customer1 set type= '" + loanType + "' where cardNumber= '" + cardNumber + "'";
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql1);
				
			    this.dispose();//关闭学生对话框
			    
			}catch(Exception arg1){
				arg1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "贷款成功", "提示信息",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(arg0.getSource() == jb2){
			System.out.println("你选择了取消");
			this.dispose();//关闭添加对话框
		} else if(arg0.getSource() == jcombo) {
			loanType = jcombo.getSelectedIndex()+1;
		}
	}
	
}
