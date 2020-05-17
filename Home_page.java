package bankAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Home_page extends JFrame implements ActionListener {
	// 动作事件监听器，实现ActionListener接口

	JFrame jf = new JFrame();
	Container container = jf.getContentPane();
	JButton inquire, add, change, delete, home, out, loan, open, deposit, draw, repay;
	JPanel jp1, jp2,jp3,jp4;
	JLabel num;
	JTextField cardNum;
	JTable table;
	CustomerModel cm;
	JScrollPane jsp;

	// 定义连接数据库的变量
	Statement stat = null;
	PreparedStatement ps;
	Connection ct = null;
	ResultSet rs = null;

	public Home_page() {

		jf.setTitle("村镇银行柜台系统");
		jf.setVisible(true);// 使窗口可视
		jf.setSize(1200, 500);// 窗口的大小
		jf.setLocation(150, 150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

		GridLayout layout1 = new GridLayout(8, 1);		
		GridLayout layout2 = new GridLayout(8, 1);			
		jp1 = new JPanel();
		num = new JLabel("请输入卡号：");
		cardNum = new JTextField(20);
		inquire = new JButton("查询");
		inquire.addActionListener(this);
		jp1.add(num);
		jp1.add(cardNum);
		jp1.add(inquire);

		jp2 = new JPanel();
		home = new JButton("系统菜单");
		home.addActionListener(this);
		out = new JButton("退出系统");
		out.addActionListener(this);
		
		jp3=new JPanel(layout1);
		add = new JButton("注册");
		add.addActionListener(this); 
		change = new JButton("修改");
		change.addActionListener(this);
		delete = new JButton("删除");
		delete.addActionListener(this);

			
		deposit = new JButton("存款");
		deposit.addActionListener(this);
		draw = new JButton("取款");
		draw.addActionListener(this);
		loan = new JButton("贷款");
		loan.addActionListener(this);
		repay = new JButton("还款");
		repay.addActionListener(this);
		open = new JButton("开通网银");
		open.addActionListener(this);
		

		jp2.add(home);
		jp2.add(out);
		jp3.add(add);
		jp3.add(change);
		jp3.add(delete);
		jp3.add(deposit);
		jp3.add(draw);
		jp3.add(loan);
		jp3.add(repay);
		jp3.add(open);

		// 创建模型对象
		cm = new CustomerModel();

		// 初始化
		table = new JTable(cm);
		this.setWidth();

		// 若表格显示不全设置滚动条
		jsp = new JScrollPane(table);
		jf.add(jsp);
		jf.add(jp1, "North");
		jf.add(jp2, "South");
		jf.add(jp3, "West");
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == inquire) {
			// 因为把对表的数据封装到StuModel中，可以比较简单的完成查询
			String cardNum = this.cardNum.getText().trim();
			// 写一个sql语句
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// 构建一个数据模型类，并更新
			cm = new CustomerModel(sql);
			// 更新jtable
			table.setModel(cm);
			this.setWidth();
		}

		else if (e.getSource() == add) {
			AddCustomer add = new AddCustomer(this, "添加学生", true);
			String cardNum = add.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// 构建一个数据模型类，并更新
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		else if (e.getSource() == delete) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow会返回给用户点中的行
			// 如果该用户一行都没有选，就返回-1
			if (rowNum == -1) {
				// 提示
				JOptionPane.showMessageDialog(this, "请选择用户");
				return;
			}

			// 得到用户ID
			String cusCardNum = (String) cm.getValueAt(rowNum, 0);
			String tip = "你确定要删除卡号为" + cusCardNum + "的成员嘛？";
			int n = JOptionPane.showConfirmDialog(this, tip, "询问", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				// 连接数据库,完成删除任务
				try {
					// 1.加载驱动
					Class.forName("com.mysql.jdbc.Driver");
					// 2.连接数据库
					ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
					ps = ct.prepareStatement("delete from customer1 where cardNumber = ?");
					ps.setString(1, cusCardNum);
					ps.executeUpdate();
				} catch (Exception arg1) {
					arg1.printStackTrace();
				} finally {
					try {
						if (rs != null) {
							rs.close();
							rs = null;

						}
						if (ps != null) {
							ps.close();
							ps = null;
						}
						if (ct != null) {
							ct.close();
							ct = null;
						}
					} catch (Exception arg2) {
						arg2.printStackTrace();
					}
				}
				cm = new CustomerModel();
				// 更新jtable
				table.setModel(cm);
				this.setWidth();
			}
		}

		// 主界面
		else if (e.getSource() == home) {
			cm = new CustomerModel();
			cardNum.setText("");
			table.setModel(cm);
			this.setWidth();
		}

		// 退出
		else if (e.getSource() == out) {
			int n = JOptionPane.showConfirmDialog(this, "你确定要退出嘛？", "询问", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				System.exit(0);
			}
		}

		// 更改
		else if (e.getSource() == change) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow会返回给用户点中的行
			// 如果该用户一行都没有选，就返回-1
			if (rowNum == -1) {
				// 提示
				JOptionPane.showMessageDialog(this, "请选择修改用户");
				return;
			}
			ChangeCustomer changeCustomer = new ChangeCustomer(this, "修改信息", true, cm, rowNum);
			String cardNum = changeCustomer.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// 构建一个数据模型类，并更新
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		else if (e.getSource() == loan) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow会返回给用户点中的行
			// 如果该用户一行都没有选，就返回-1
			if (rowNum == -1) {
				// 提示
				JOptionPane.showMessageDialog(this, "请选择贷款用户");
				return;
			}
			Loan loan1 = new Loan(this, "修改信息", true, cm, rowNum);
			String cardNum = loan1.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// 构建一个数据模型类，并更新
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		// 存款
		else if (e.getSource() == deposit) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow会返回给用户点中的行
			// 如果该用户一行都没有选，就返回-1
			if (rowNum == -1) {
				// 提示
				JOptionPane.showMessageDialog(this, "请选择存款用户");
				return;
			}
			Deposit deposit = new Deposit(this, "存款", true, cm, rowNum);
			String cardNum = deposit.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// 构建一个数据模型类，并更新
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		// 取款
		else if (e.getSource() == draw) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow会返回给用户点中的行
			// 如果该用户一行都没有选，就返回-1
			if (rowNum == -1) {
				// 提示
				JOptionPane.showMessageDialog(this, "请选择取款用户");
				return;
			}
			Draw draw = new Draw(this, "取款", true, cm, rowNum);
			String cardNum = draw.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// 构建一个数据模型类，并更新
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		else if (e.getSource() == open) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow会返回给用户点中的行
			// 如果该用户一行都没有选，就返回-1
			if (rowNum == -1) {
				// 提示
				JOptionPane.showMessageDialog(this, "请选择网银开通用户");
				return;
			}
			String CardNumber1 = (String) cm.getValueAt(rowNum, 0);
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
				String sql = "update customer1 set onlineBanking= '" + 1 + "' where cardNumber= '" + CardNumber1 + "'";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "开通网银成功", "提示信息", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception arg1) {
				arg1.printStackTrace();
			}
			String sql = "select * from customer1 where cardNumber = '" + CardNumber1 + "' ";
			// 构建一个数据模型类，并更新
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		// 还款
		else if (e.getSource() == repay) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow会返回给用户点中的行
			// 如果该用户一行都没有选，就返回-1
			if (rowNum == -1) {
				// 提示
				JOptionPane.showMessageDialog(this, "请选择还款用户");
				return;
			}
			Repayment repayment = new Repayment(this, "还款", true, cm, rowNum);
			String cardNum = repayment.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// 构建一个数据模型类，并更新
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}
	}
	
	public void setWidth() {
		int columncount = this.table.getColumnCount();
		for (int i = 0; i < columncount; i++) {
			if (i == 0 || i == 5 || i == 6) {
				this.table.getColumnModel().getColumn(i).setPreferredWidth(180);
			} else if (i == 1 ) {
				this.table.getColumnModel().getColumn(i).setPreferredWidth(50);
			} else if (i == 2 || i == 3|| i == 8) {
				this.table.getColumnModel().getColumn(i).setPreferredWidth(150);
			} else {
				this.table.getColumnModel().getColumn(i).setPreferredWidth(100);
			}
		}
	}

}
