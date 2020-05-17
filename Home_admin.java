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

	// �����������ݿ�ı���
	Statement stat = null;
	PreparedStatement ps;
	Connection ct = null;
	ResultSet rs = null;

	public Home_admin() {
		jf.setTitle("�������й�̨ϵͳ");
		jf.setVisible(true);// ʹ���ڿ���
		jf.setSize(1200, 500);// ���ڵĴ�С
		jf.setLocation(150, 150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);

		GridLayout layout1 = new GridLayout(8, 1);
		GridLayout layout2 = new GridLayout(8, 1);
		jp1 = new JPanel();
		id1 = new JLabel("������Ҫ��ѯ�Ĺ�̨��Ա��id�ţ�");
		id = new JTextField(20);
		inquire = new JButton("��ѯ");
		inquire.addActionListener(this);
		jp1.add(id1);
		jp1.add(id);
		jp1.add(inquire);

		jp2 = new JPanel();
		back = new JButton("������һ��");
		back.addActionListener(this);
		home = new JButton("������");
		home.addActionListener(this);
		out = new JButton("�˳�ϵͳ");
		out.addActionListener(this);

		jp3 = new JPanel(layout1);
		add = new JButton("ע��");
		add.addActionListener(this);
		change = new JButton("�޸�");
		change.addActionListener(this);
		delete = new JButton("ɾ��");
		delete.addActionListener(this);

		jp2.add(back);
		jp2.add(home);
		jp2.add(out);
		jp3.add(add);
		jp3.add(change);
		jp3.add(delete);

		// ����ģ�Ͷ���
		em = new EmployeeModel();

		// ��ʼ��
		table = new JTable(em);
//		this.setWidth();

		// �������ʾ��ȫ���ù�����
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
			// ��Ϊ�ѶԱ�����ݷ�װ��StuModel�У����ԱȽϼ򵥵���ɲ�ѯ
			String id = this.id.getText().trim();
			// дһ��sql���
			String sql = "select * from admin where id = '" + id + "' ";
			// ����һ������ģ���࣬������
			em = new EmployeeModel(sql);
			// ����jtable
			table.setModel(em);
		}

		else if (e.getSource() == add) {
			AddAdmin add = new AddAdmin(this, "����", true);
			String id = add.id;
//			System.out.println(id);
			String sql = "select * from admin where id = '" + id + "' ";
			// ����һ������ģ���࣬������
			em = new EmployeeModel(sql);
			// ����jtable
			table.setModel(em);
		}

		else if (e.getSource() == delete) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow�᷵�ظ��û����е���
			// ������û�һ�ж�û��ѡ���ͷ���-1
			if (rowNum == -1) {
				// ��ʾ
				JOptionPane.showMessageDialog(this, "��ѡ���̨��Ա");
				return;
			}

			// �õ��û�ID
			String id = (String) em.getValueAt(rowNum, 0);
			String tip = "��ȷ��Ҫɾ��id��Ϊ" + id + "�Ĺ�̨��Ա�";
			int n = JOptionPane.showConfirmDialog(this, tip, "ѯ��", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				// �������ݿ�,���ɾ������
				try {
					// 1.��������
					Class.forName("com.mysql.jdbc.Driver");
					// 2.�������ݿ�
					ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
					ps = ct.prepareStatement("delete from admin where id = ?");
					ps.setString(1, id);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "�ѳɹ�ɾ��id��Ϊ"+id+"�Ĺ�̨��Ա", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
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
				// ����jtable
				table.setModel(em);
			}
		}

		// ������
		else if (e.getSource() == home) {
			em = new EmployeeModel();
			id.setText("");
			table.setModel(em);
		}

		// �˳�
		else if (e.getSource() == out) {
			int n = JOptionPane.showConfirmDialog(this, "��ȷ��Ҫ�˳��", "ѯ��", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				System.exit(0);
			}
		}

		// ����
		else if (e.getSource() == change) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow�᷵�ظ��û����е���
			// ������û�һ�ж�û��ѡ���ͷ���-1
			if (rowNum == -1) {
				// ��ʾ
				JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸Ĺ�̨��Ա");
				return;
			}
			ChangeAdmin changeAdmin = new ChangeAdmin(this, "�޸���Ϣ", true, em, rowNum);
			String id = changeAdmin.id;
//			System.out.println(id);
			String sql = "select * from admin where id = '" + id + "' ";
			// ����һ������ģ���࣬������
			em = new EmployeeModel(sql);
			// ����jtable
			table.setModel(em);
		}
		
		else if (e.getSource() == back) {
			jf.dispose();
			Home home = new Home();
		}
	}

}
