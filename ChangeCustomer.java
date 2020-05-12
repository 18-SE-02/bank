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

	JFrame jf = new JFrame();
	JLabel jl5, jl6;
	JTextField jf5, jf6;
	JPanel jp1, jp2, jp3;
	JButton jb1, jb2;
	PreparedStatement ps;
	String cardNumber;
	String telephone;
	String password;

	// owner代笔父窗口,title是窗口的名字,modal指定是模式窗口()或者非模式窗口
	public ChangeCustomer(Frame owner, String title, boolean modal, CustomerModel cm, int rowNum) {
		super(owner, title, modal);
		jl5 = new JLabel("密码");
		jl6 = new JLabel("电话号码");

		cardNumber = (String) cm.getValueAt(rowNum, 0);
		jf5 = new JTextField(20);
		jf5.setText(cm.getValueAt(rowNum, 7).toString());
		password = jf5.getText();
		jf6 = new JTextField(20);
		jf6.setText(cm.getValueAt(rowNum, 5).toString());
		telephone = jf6.getText();
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

		jf.add(jp1, BorderLayout.WEST);
		jf.add(jp2, BorderLayout.CENTER);
		jf.add(jp3, BorderLayout.SOUTH);

		jf.setSize(280, 160);
		jf.setVisible(true);

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - 140;
		int y = (int) screensize.getHeight() / 2 - 80;
		jf.setLocation(x, y);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == jb1) {
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
				if (password.equals(jf5.getText()) && telephone.equals(jf6.getText())) {
					JOptionPane.showMessageDialog(null, "您至少需要修改一项信息！", "提示信息", JOptionPane.INFORMATION_MESSAGE);

				} else {
					if (jf5.getText() == null || jf5.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "密码不允许为空！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					} else if (judge3(jf5.getText()) == true) {
						JOptionPane.showMessageDialog(null, "密码只能为数字！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					} else if (jf5.getText().length() != 6) {
						JOptionPane.showMessageDialog(null, "密码只能为6位！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					} else if (jf6.getText() == null || jf6.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "电话号码不允许为空！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					} else if (jf6.getText().length() != 11) {
						JOptionPane.showMessageDialog(null, "电话号码长度错误！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					} else if (jf6.getText().toCharArray()[0] != '1') {
						JOptionPane.showMessageDialog(null, "电话号码错误！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					} else if (judge3(jf6.getText()) == true) {
						JOptionPane.showMessageDialog(null, "电话号码只能是数字！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					} else {
						String sql = "update customer1 set password= '" + jf5.getText() + "' where cardNumber= '"
								+ cardNumber + "'";
						String sql1 = "update customer1 set telephone= '" + jf6.getText() + "' where cardNumber= '"
								+ cardNumber + "'";
						JOptionPane.showMessageDialog(null, "修改信息成功", "提示信息", JOptionPane.INFORMATION_MESSAGE);
						stmt.executeUpdate(sql);
						stmt.executeUpdate(sql1);

						jf.dispose();// 关闭学生对话框
					}
				}
			} catch (Exception arg1) {
				arg1.printStackTrace();
			}
		}

		else if (arg0.getSource() == jb2) {
			jf.dispose();// 关闭添加对话框
		}
	}

	public boolean judge3(String telephone) {
		for (int i = 0; i < telephone.length(); i++) {
			if (telephone.toCharArray()[i] > '9' || telephone.toCharArray()[i] < '0') {
				return true;
			}
		}
		return false;
	}

	public boolean judgesame(String telephone) {
		int count = 0;
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
			// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer1");

			while (rs.next()) {
				if (telephone.equals(rs.getString("telephone"))) {

					count = 1;
				}
			}

			if (count == 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
