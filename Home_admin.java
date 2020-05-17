package bankMaster;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Home_admin extends JFrame implements ActionListener {
	JFrame jf = new JFrame();
	Container container = jf.getContentPane();
	JButton inquire, change, back, add, delete, home, out;
	JPanel jp1, jp2, jp3;
	JTable table;
	JLabel id1;
	EmployeeModel em;
	JScrollPane jsp;
	JTextField id;

	// 定义连接数据库的变量
	Statement stat = null;
	PreparedStatement ps;
	Connection ct = null;
	ResultSet rs = null;

	public Home_admin() {
		jf.setTitle("村镇银行柜台系统");
		jf.setVisible(true);// 使窗口可视
		jf.setSize(1200, 500);// 窗口的大小
		jf.setLocation(150, 150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);

		GridLayout layout1 = new GridLayout(8, 1);
		GridLayout layout2 = new GridLayout(8, 1);
		jp1 = new JPanel();
		id1 = new JLabel("请输入要查询的柜台人员的id号：");
		id = new JTextField(20);
		inquire = new JButton("查询");
		inquire.addActionListener(this);
		jp1.add(id1);
		jp1.add(id);
		jp1.add(inquire);

		jp2 = new JPanel();
		back = new JButton("返回上一层");
		back.addActionListener(this);
		home = new JButton("主界面");
		home.addActionListener(this);
		out = new JButton("退出系统");
		out.addActionListener(this);

		jp3 = new JPanel(layout1);
		add = new JButton("注册");
		add.addActionListener(this);
		change = new JButton("修改");
		change.addActionListener(this);
		delete = new JButton("删除");
		delete.addActionListener(this);

		jp2.add(back);
		jp2.add(home);
		jp2.add(out);
		jp3.add(add);
		jp3.add(change);
		jp3.add(delete);

		// 创建模型对象
		em = new EmployeeModel();

		// 初始化
		table = new JTable(em);
//		this.setWidth();

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
			String id = this.id.getText().trim();
			// 写一个sql语句
			String sql = "select * from admin where id = '" + id + "' ";
			// 构建一个数据模型类，并更新
			em = new EmployeeModel(sql);
			// 更新jtable
			table.setModel(em);
		}

		else if (e.getSource() == add) {
			AddAdmin add = new AddAdmin(this, "增加", true);
			String id = add.id;
//			System.out.println(id);
			String sql = "select * from admin where id = '" + id + "' ";
			// 构建一个数据模型类，并更新
			em = new EmployeeModel(sql);
			// 更新jtable
			table.setModel(em);
		}

		else if (e.getSource() == delete) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow会返回给用户点中的行
			// 如果该用户一行都没有选，就返回-1
			if (rowNum == -1) {
				// 提示
				JOptionPane.showMessageDialog(this, "请选择柜台人员");
				return;
			}

			// 得到用户ID
			String id = (String) em.getValueAt(rowNum, 0);
			String tip = "你确定要删除id号为" + id + "的柜台人员嘛？";
			int n = JOptionPane.showConfirmDialog(this, tip, "询问", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				// 连接数据库,完成删除任务
				try {
					// 1.加载驱动
					Class.forName("com.mysql.jdbc.Driver");
					// 2.连接数据库
					ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
					ps = ct.prepareStatement("delete from admin where id = ?");
					ps.setString(1, id);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "已成功删除id号为"+id+"的柜台人员", "提示信息", JOptionPane.INFORMATION_MESSAGE);
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
				em = new EmployeeModel();
				// 更新jtable
				table.setModel(em);
			}
		}

		// 主界面
		else if (e.getSource() == home) {
			em = new EmployeeModel();
			id.setText("");
			table.setModel(em);
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
				JOptionPane.showMessageDialog(this, "请选择要修改柜台人员");
				return;
			}
			ChangeAdmin changeAdmin = new ChangeAdmin(this, "修改信息", true, em, rowNum);
			String id = changeAdmin.id;
//			System.out.println(id);
			String sql = "select * from admin where id = '" + id + "' ";
			// 构建一个数据模型类，并更新
			em = new EmployeeModel(sql);
			// 更新jtable
			table.setModel(em);
		}
		
		else if (e.getSource() == back) {
			jf.dispose();
			Home home = new Home();
		}
	}

}
