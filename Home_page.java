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

	// �����������ݿ�ı���
	Statement stat = null;
	PreparedStatement ps;
	Connection ct = null;
	ResultSet rs = null;

	public Home_page() {
		jf.setTitle("�������пͷ�ϵͳ");
		jf.setVisible(true);// ʹ���ڿ���
		jf.setSize(1200, 500);// ���ڵĴ�С
		jf.setLocation(150, 150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
		GridLayout layout = new GridLayout(5, 1);	  
		jp = new JPanel();
		word = new JLabel("���߿ͷ���ѯ����");
		jp.add(word);
		jp1 = new JPanel();
		home = new JButton("������");
		home.addActionListener(this);
		out = new JButton("�˳�ϵͳ");
		out.addActionListener(this);
		
		
		jp2	= new JPanel(layout);
		look = new JButton("�鿴��������");
		look.addActionListener(this);
		lookNew = new JButton("�鿴δ������");
		lookNew.addActionListener(this);
		lookOld = new JButton("�鿴�Ѷ�����");
		lookOld.addActionListener(this);
		reply = new JButton("�ظ�����");
		reply.addActionListener(this);
		read = new JButton("��Ϊ�Ѷ�����");
		read.addActionListener(this);

		jp1.add(home);
		jp1.add(out);
		jp2.add(look);
		jp2.add(lookNew);
		jp2.add(lookOld);
		jp2.add(read);
		jp2.add(reply);

		// ����ģ�Ͷ���
		am = new AdviseModel();

		// ��ʼ��
		table = new JTable(am);

		// �������ʾ��ȫ���ù�����
		jsp = new JScrollPane(table);
		jf.add(jsp);
		jf.add(jp, "North");
		jf.add(jp1, "South");
		jf.add(jp2, "West");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == out) {
			int n = JOptionPane.showConfirmDialog(this, "��ȷ��Ҫ�˳��", "ѯ��", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				System.exit(0);
			}
		}

		// ������
		else if (e.getSource() == home) {
			am = new AdviseModel();
			table.setModel(am);
		}

		// �鿴��������
		else if (e.getSource() == look) {
			String sql = "select * from leavemessage";
			am = new AdviseModel(sql);
			table.setModel(am);
		}

		// ��������Ϊ�Ѷ�
		else if (e.getSource() == read) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow�᷵�ظ��û����е���
			// ������û�һ�ж�û��ѡ���ͷ���-1
			if (rowNum == -1) {
				// ��ʾ
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			String date = (String) am.getValueAt(rowNum, 0);
			try {
				// 1.��������
				Class.forName("com.mysql.jdbc.Driver");
				// 2.�������ݿ�
				ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
				stat = ct.createStatement();// ����stat����
				String sql = "select * from leavemessage where date = '" + date + "' ";
				rs = stat.executeQuery(sql);// ��ѯ���
				while (rs.next()) {
					if (rs.getInt(4) == 1) {
						JOptionPane.showMessageDialog(null, "�Ѿ��鿴��������", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					} else {
						stat = null;
						stat = ct.createStatement();// ����stat����
						String sql1 = "update leavemessage set look= '" + 1 + "' where date= '" + date + "'";
						stat.executeUpdate(sql1);
						JOptionPane.showMessageDialog(null, "��Ϊ�Ѷ��ɹ�", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} catch (Exception arg1) {
				arg1.printStackTrace();
			}
			String sql = "select * from leavemessage where date = '" + date + "' ";
			// ����һ������ģ���࣬������
			am = new AdviseModel(sql);
			table.setModel(am);
		}

		// �鿴�Ѷ�����
		else if (e.getSource() == lookOld) {
			String sql = "select * from leavemessage where look = '" + 1 + "' ";
			am = new AdviseModel(sql);
			table.setModel(am);
		}
		
		// �鿴�Ѷ�����
		else if (e.getSource() == lookNew) {
			String sql = "select * from leavemessage where look = '" + 0 + "' ";
			am = new AdviseModel(sql);
			table.setModel(am);
		}
		
		// �ظ�����
		else if (e.getSource() == reply) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow�᷵�ظ��û����е���
			// ������û�һ�ж�û��ѡ���ͷ���-1
			if (rowNum == -1) {
				// ��ʾ
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			Reply reply = new Reply(this, "�޸���Ϣ", true, am, rowNum);
			String date = reply.date;
			String sql = "select * from leavemessage where date = '" + date + "' ";
			// ����һ������ģ���࣬������
			am = new AdviseModel(sql);
			table.setModel(am);
		}
			
	}

}
