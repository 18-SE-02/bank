package bankAdmin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangeCustomer extends JDialog implements ActionListener {

	JLabel jl5, jl6;
	JTextField jf5, jf6;
	JPanel jp1, jp2, jp3;
	JButton jb1, jb2;
	PreparedStatement ps;
	String cardNumber;

	// owner代笔父窗口,title是窗口的名字,modal指定是模式窗口()或者非模式窗口
	public ChangeCustomer(Frame owner, String title, boolean modal, CustomerModel cm, int rowNum) {
		super(owner, title, modal);
		jl5 = new JLabel("密码");
		jl6 = new JLabel("电话号码");

		cardNumber = (String) cm.getValueAt(rowNum, 0);
		jf5 = new JTextField(20);
		jf5.setText(cm.getValueAt(rowNum, 7).toString());
		jf6 = new JTextField(20);
		jf6.setText(cm.getValueAt(rowNum, 5).toString());

		jb1 = new JButton("修改");
		jb1.addActionListener(this);
		jb2 = new JButton("取消");
		jb2.addActionListener(this);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		// 设置布局
		jp1.setLayout(new GridLayout(2, 1));
		jp2.setLayout(new GridLayout(2, 1));

		jp3.add(jb1);
		jp3.add(jb2);

		jp1.add(jl5);
		jp1.add(jl6);

		jp2.add(jf5);
		jp2.add(jf6);

		this.add(jp1, BorderLayout.WEST);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);

		this.setSize(280,160);
        this.setLocationRelativeTo(null);    
        this.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == jb1) {
			
			if(judgePassword(jf5.getText()) && judgeTelephone(jf6.getText()))
			{
			Connection ct = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Statement stmt = null;

			try {
				// 1.加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				// 2.连接数据库
				ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
				stmt = ct.createStatement();

				String sql = "update customer1 set password= '" + jf5.getText() + "' where cardNumber= '" + cardNumber
						+ "'";
				String sql1 = "update customer1 set telephone= '" + jf6.getText() + "' where cardNumber= '" + cardNumber
						+ "'";
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql1);

				this.dispose();
				JOptionPane.showMessageDialog(null, "修改成功", "提示信息", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception arg1) {
				arg1.printStackTrace();
			}
		}
		}

		else if (arg0.getSource() == jb2) {
			this.dispose();// 关闭添加对话框
		}
	}
	
	
	public boolean judgePassword(String password) {
		if (password == null || password.length() == 0) {
			JOptionPane.showMessageDialog(null, "密码不允许为空！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (judge3(password) == true) {
			JOptionPane.showMessageDialog(null, "密码只能为数字！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (password.length() != 6) {
			JOptionPane.showMessageDialog(null, "密码只能为6位！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	public boolean judgeTelephone(String telephone) {
		int count = 0;
		if (telephone == null || telephone.length() == 0) {
			JOptionPane.showMessageDialog(null, "电话号码不允许为空！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
		} else if (telephone.length() != 11) {
			JOptionPane.showMessageDialog(null, "电话号码长度错误！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
		} else if (telephone.toCharArray()[0] != '1') {
			JOptionPane.showMessageDialog(null, "电话号码错误！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
		} else if (judge3(telephone) == true) {
			JOptionPane.showMessageDialog(null, "电话号码只能是数字！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
		} else {
			return true;
		}

		return false;
	}
	
	public boolean judge3(String telephone) {
		for (int i = 0; i < telephone.length(); i++) {
			if (telephone.toCharArray()[i] > '9' || telephone.toCharArray()[i] < '0') {
				return true;
			}
		}
		return false;
	}

}
