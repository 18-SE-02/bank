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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ChangeCustomer extends JDialog implements ActionListener{

	JLabel jl5,jl6;
	JTextField jf5,jf6;
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	PreparedStatement ps;
	String cardNumber,idNumber;
	
	//owner���ʸ�����,title�Ǵ��ڵ�����,modalָ����ģʽ����()���߷�ģʽ����
		 public ChangeCustomer(Frame owner,String title, boolean modal,CustomerModel cm,int rowNum){
			 super(owner,title,modal);
			 jl5 = new JLabel("����");
			 jl6 = new JLabel("�绰����");
			 
			 cardNumber=(String)cm.getValueAt(rowNum, 0);
			 jf5 = new JTextField(20);
			 jf5.setText(cm.getValueAt(rowNum, 7).toString());
			 jf6 = new JTextField(20);
			 jf6.setText(cm.getValueAt(rowNum, 5).toString());
			 
			 jb1 = new JButton("�޸�");
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
			
			 
			  jp1.add(jl5);
			  jp1.add(jl6);
			
			  jp2.add(jf5);
			  jp2.add(jf6);
			  
			  this.add(jp1, BorderLayout.WEST);
			  this.add(jp2, BorderLayout.CENTER);
			  this.add(jp3, BorderLayout.SOUTH);
			  
			  this.setSize(300,200);
			  this.setVisible(true);
			 
		 }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
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
			    
				String sql = "update customer1 set password= '" + jf5.getText() + "' where cardNumber= '" + cardNumber + "'";
				String sql1 = "update customer1 set telephone= '" + jf6.getText() + "' where cardNumber= '" + cardNumber + "'";
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql1);
				
			    this.dispose();//�ر�ѧ���Ի���
			    
			}catch(Exception arg1){
				arg1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "��ϲ���޸ĳɹ���", "��ʾ��Ϣ",
			JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(arg0.getSource() == jb2){
			System.out.println("��ѡ����ȡ��");
			this.dispose();//�ر���ӶԻ���
		}
	}

}
