package bankService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Home_page extends JFrame implements ActionListener {

	JFrame jf = new JFrame();
	Container container = jf.getContentPane();
	JButton home, look, reply, lookNew, lookOld, out, read;
	JPanel jp1,jp2,jp;
	JTable table;
	JLabel word;
	AdviseModel am;
	JScrollPane jsp;

	// 定义连接数据库的变量
	Statement stat = null;
	PreparedStatement ps;
	Connection ct = null;
	ResultSet rs = null;

	public Home_page() {
		jf.setTitle("村镇银行客服系统");
		jf.setVisible(true);// 使窗口可视
		jf.setSize(1200, 500);// 窗口的大小
		jf.setLocation(150, 150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
		GridLayout layout = new GridLayout(5, 1);	  
		jp = new JPanel();
		word = new JLabel("在线客服咨询管理");
		jp.add(word);
		jp1 = new JPanel();
		home = new JButton("主界面");
		home.addActionListener(this);
		out = new JButton("退出系统");
		out.addActionListener(this);
		
		
		jp2	= new JPanel(layout);
		look = new JButton("查看所有留言");
		look.addActionListener(this);
		lookNew = new JButton("查看未读留言");
		lookNew.addActionListener(this);
		lookOld = new JButton("查看已读留言");
		lookOld.addActionListener(this);
		reply = new JButton("回复留言");
		reply.addActionListener(this);
		read = new JButton("标为已读留言");
		read.addActionListener(this);

		jp1.add(home);
		jp1.add(out);
		jp2.add(look);
		jp2.add(lookNew);
		jp2.add(lookOld);
		jp2.add(read);
		jp2.add(reply);

		// 创建模型对象
		am = new AdviseModel();

		// 初始化
		table = new JTable(am);

		// 若表格显示不全设置滚动条
		jsp = new JScrollPane(table);
		jf.add(jsp);
		jf.add(jp, "North");
		jf.add(jp1, "South");
		jf.add(jp2, "West");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == out) {
			int n = JOptionPane.showConfirmDialog(this, "你确定要退出嘛？", "询问", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				System.exit(0);
			}
		}

		// 主界面
		else if (e.getSource() == home) {
			am = new AdviseModel();
			table.setModel(am);
		}

		// 查看所有留言
		else if (e.getSource() == look) {
			String sql = "select * from leavemessage";
			am = new AdviseModel(sql);
			table.setModel(am);
		}

		// 将留言置为已读
		else if (e.getSource() == read) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow会返回给用户点中的行
			// 如果该用户一行都没有选，就返回-1
			if (rowNum == -1) {
				// 提示
				JOptionPane.showMessageDialog(this, "请选中一行");
				return;
			}
			String date = (String) am.getValueAt(rowNum, 0);
			try {
				// 1.加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				// 2.连接数据库
				ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
				stat = ct.createStatement();// 创建stat对象
				String sql = "select * from leavemessage where date = '" + date + "' ";
				rs = stat.executeQuery(sql);// 查询结果
				while (rs.next()) {
					if (rs.getInt(4) == 1) {
						JOptionPane.showMessageDialog(null, "已经查看过该留言", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					} else {
						stat = null;
						stat = ct.createStatement();// 创建stat对象
						String sql1 = "update leavemessage set look= '" + 1 + "' where date= '" + date + "'";
						stat.executeUpdate(sql1);
						JOptionPane.showMessageDialog(null, "置为已读成功", "提示信息", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} catch (Exception arg1) {
				arg1.printStackTrace();
			}
			String sql = "select * from leavemessage where date = '" + date + "' ";
			// 构建一个数据模型类，并更新
			am = new AdviseModel(sql);
			table.setModel(am);
		}

		// 查看已读留言
		else if (e.getSource() == lookOld) {
			String sql = "select * from leavemessage where look = '" + 1 + "' ";
			am = new AdviseModel(sql);
			table.setModel(am);
		}
		
		// 查看已读留言
		else if (e.getSource() == lookNew) {
			String sql = "select * from leavemessage where look = '" + 0 + "' ";
			am = new AdviseModel(sql);
			table.setModel(am);
		}
		
		// 回复留言
		else if (e.getSource() == reply) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow会返回给用户点中的行
			// 如果该用户一行都没有选，就返回-1
			if (rowNum == -1) {
				// 提示
				JOptionPane.showMessageDialog(this, "请选中一行");
				return;
			}
			Reply reply = new Reply(this, "修改信息", true, am, rowNum);
			String date = reply.date;
			String sql = "select * from leavemessage where date = '" + date + "' ";
			// 构建一个数据模型类，并更新
			am = new AdviseModel(sql);
			table.setModel(am);
		}
			
	}

}
