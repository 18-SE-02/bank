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

public class Draw extends JDialog implements ActionListener {

	JFrame jf = new JFrame();
	JLabel jl1;
	JTextField jf1;
	JPanel jp1, jp2, jp3;
	JButton jb1, jb2;
	PreparedStatement ps;
	String cardNumber;
	double balance;

	// owner代笔父窗口,title是窗口的名字,modal指定是模式窗口()或者非模式窗口
	public Draw(Frame owner, String title, boolean modal, CustomerModel cm, int rowNum) {
		super(owner, title, modal);
		jl1 = new JLabel("取款金额");

		cardNumber = (String) cm.getValueAt(rowNum, 0);
		balance = (double) cm.getValueAt(rowNum, 2);
		jf1 = new JTextField(20);
		jb1 = new JButton("确定");
		jb1.addActionListener(this);
		jb2 = new JButton("取消");
		jb2.addActionListener(this);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		// 设置布局
		jp1.setLayout(new GridLayout(1, 1));
		jp2.setLayout(new GridLayout(1, 1));

		jp3.add(jb1);
		jp3.add(jb2);

		jp1.add(jl1);

		jp2.add(jf1);

		jf.add(jp1, BorderLayout.WEST);
		jf.add(jp2, BorderLayout.CENTER);
		jf.add(jp3, BorderLayout.SOUTH);

		jf.setSize(280, 120);
		jf.setVisible(true);

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - 140;
		int y = (int) screensize.getHeight() / 2 - 110;
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

				if (judge(jf1.getText())) {
					JOptionPane.showMessageDialog(null, "取款失败，取款金额必须为整数或小数！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					jf.dispose();
				} else if (searchPoint(jf1.getText()) == true) {
					JOptionPane.showMessageDialog(null, "取款失败，取款金额输入不规范！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					jf.dispose();
				} else if (judgeBlank(jf1.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "取款失败，取款金额中不能包含空格！", "提示信息",
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (Double.parseDouble(jf1.getText()) < 0) {
					JOptionPane.showMessageDialog(null, "取款失败，取款金额必须为正数！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					jf.dispose();
				} else if (balance < Double.parseDouble(jf1.getText())) {
					JOptionPane.showMessageDialog(null, "取款失败，取款金额大于总余额！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					jf.dispose();
				} else {
					balance = balance - Double.parseDouble(jf1.getText());
					String sql = "update customer1 set balance= '" + balance + "' where cardNumber= '" + cardNumber
							+ "'";
					stmt.executeUpdate(sql);

					JOptionPane.showMessageDialog(null, "取款成功", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					jf.dispose();// 关闭学生对话框
				}
			} catch (Exception arg1) {
				arg1.printStackTrace();
			}
		}

		else if (arg0.getSource() == jb2) {
			jf.dispose();// 关闭添加对话框
		}
	}

	public boolean searchPoint(String text) {
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.toCharArray()[i] == '.') {
				count++;
			}
		}
		if (count > 1) {
			return true;
		}
		return false;
	}

    public boolean judge(String number){
        for(int i = 0; i <number.length() ; i++){
            if((number.toCharArray()[i] < '0' || number.toCharArray()[i] > '9') && number.toCharArray()[i] != '.' && number.toCharArray()[i] != ' '){
                return true;
            }
        }
        return false;
    }
    public  boolean judgeBlank(String number){
        for(int i = 0; i <number.length() ; i++){
            if(number.toCharArray()[i] == ' '){
                return true;
            }
        }
        return false;
    }
}
