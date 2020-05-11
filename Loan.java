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
		 jl1 = new JLabel("������");
		 jl2 = new JLabel("��������");
		 String [] type = {"��ѧ����","������ҵ����","������������","�����ۺ����Ѵ���","���幤�̻���ҵ����","��ҵ��֤����"}; 
		 jcombo = new JComboBox(type);
		 jlist = new JList(type);
		 jcombo.addActionListener(this);
		 
		 cardNumber=(String)cm.getValueAt(rowNum, 0);
		 loan = (double)cm.getValueAt(rowNum, 3);
		 jf1 = new JTextField(20);
		 jb1 = new JButton("����");
		 jb1.addActionListener(this);
		 jb2 = new JButton("ȡ��");
		 jb2.addActionListener(this);
		 
		 jp1 = new JPanel();
		 jp2 = new JPanel();
		 jp3 = new JPanel();
		 
		 //���ò���
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
			JOptionPane.showMessageDialog(null, "����ʧ�ܣ����Ȼ��嵱ǰ����", "��ʾ��Ϣ",
		              JOptionPane.INFORMATION_MESSAGE);
			this.dispose();//�رնԻ���
		}
		
		if(arg0.getSource() == jb1){
			   Connection ct = null;
			   PreparedStatement pstmt = null;
			   ResultSet rs = null;
			   Statement stmt = null;
			
			try{
				//1.��������
			    Class.forName("com.mysql.jdbc.Driver");
			    System.out.println("���سɹ�");
			    //2.�������ݿ�
			    ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
			    stmt = ct.createStatement();
			    
			    loan = loan+Double.parseDouble(jf1.getText());
				String sql = "update customer1 set loan= '" + loan + "' where cardNumber= '" + cardNumber + "'";
				String sql1 = "update customer1 set type= '" + loanType + "' where cardNumber= '" + cardNumber + "'";
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql1);
				
			    this.dispose();//�ر�ѧ���Ի���
			    
			}catch(Exception arg1){
				arg1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "����ɹ�", "��ʾ��Ϣ",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(arg0.getSource() == jb2){
			System.out.println("��ѡ����ȡ��");
			this.dispose();//�ر���ӶԻ���
		} else if(arg0.getSource() == jcombo) {
			loanType = jcombo.getSelectedIndex()+1;
		}
	}
	
}
