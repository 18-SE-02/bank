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
	// �����¼���������ʵ��ActionListener�ӿ�

	JFrame jf = new JFrame();
	Container container = jf.getContentPane();
	JButton inquire, add, change, delete, home, out, loan, open, deposit, draw, repay;
	JPanel jp1, jp2,jp3,jp4;
	JLabel num;
	JTextField cardNum;
	JTable table;
	CustomerModel cm;
	JScrollPane jsp;

	// �����������ݿ�ı���
	Statement stat = null;
	PreparedStatement ps;
	Connection ct = null;
	ResultSet rs = null;

	public Home_page() {

		jf.setTitle("�������й�̨ϵͳ");
		jf.setVisible(true);// ʹ���ڿ���
		jf.setSize(1200, 500);// ���ڵĴ�С
		jf.setLocation(150, 150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

		GridLayout layout1 = new GridLayout(8, 1);		
		GridLayout layout2 = new GridLayout(8, 1);			
		jp1 = new JPanel();
		num = new JLabel("�����뿨�ţ�");
		cardNum = new JTextField(20);
		inquire = new JButton("��ѯ");
		inquire.addActionListener(this);
		jp1.add(num);
		jp1.add(cardNum);
		jp1.add(inquire);

		jp2 = new JPanel();
		home = new JButton("ϵͳ�˵�");
		home.addActionListener(this);
		out = new JButton("�˳�ϵͳ");
		out.addActionListener(this);
		
		jp3=new JPanel(layout1);
		add = new JButton("ע��");
		add.addActionListener(this); 
		change = new JButton("�޸�");
		change.addActionListener(this);
		delete = new JButton("ɾ��");
		delete.addActionListener(this);

			
		deposit = new JButton("���");
		deposit.addActionListener(this);
		draw = new JButton("ȡ��");
		draw.addActionListener(this);
		loan = new JButton("����");
		loan.addActionListener(this);
		repay = new JButton("����");
		repay.addActionListener(this);
		open = new JButton("��ͨ����");
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

		// ����ģ�Ͷ���
		cm = new CustomerModel();

		// ��ʼ��
		table = new JTable(cm);
		this.setWidth();

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
			String cardNum = this.cardNum.getText().trim();
			// дһ��sql���
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// ����һ������ģ���࣬������
			cm = new CustomerModel(sql);
			// ����jtable
			table.setModel(cm);
			this.setWidth();
		}

		else if (e.getSource() == add) {
			AddCustomer add = new AddCustomer(this, "���ѧ��", true);
			String cardNum = add.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// ����һ������ģ���࣬������
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		else if (e.getSource() == delete) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow�᷵�ظ��û����е���
			// ������û�һ�ж�û��ѡ���ͷ���-1
			if (rowNum == -1) {
				// ��ʾ
				JOptionPane.showMessageDialog(this, "��ѡ���û�");
				return;
			}

			// �õ��û�ID
			String cusCardNum = (String) cm.getValueAt(rowNum, 0);
			String tip = "��ȷ��Ҫɾ������Ϊ" + cusCardNum + "�ĳ�Ա�";
			int n = JOptionPane.showConfirmDialog(this, tip, "ѯ��", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				// �������ݿ�,���ɾ������
				try {
					// 1.��������
					Class.forName("com.mysql.jdbc.Driver");
					// 2.�������ݿ�
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
				// ����jtable
				table.setModel(cm);
				this.setWidth();
			}
		}

		// ������
		else if (e.getSource() == home) {
			cm = new CustomerModel();
			cardNum.setText("");
			table.setModel(cm);
			this.setWidth();
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
				JOptionPane.showMessageDialog(this, "��ѡ���޸��û�");
				return;
			}
			ChangeCustomer changeCustomer = new ChangeCustomer(this, "�޸���Ϣ", true, cm, rowNum);
			String cardNum = changeCustomer.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// ����һ������ģ���࣬������
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		else if (e.getSource() == loan) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow�᷵�ظ��û����е���
			// ������û�һ�ж�û��ѡ���ͷ���-1
			if (rowNum == -1) {
				// ��ʾ
				JOptionPane.showMessageDialog(this, "��ѡ������û�");
				return;
			}
			Loan loan1 = new Loan(this, "�޸���Ϣ", true, cm, rowNum);
			String cardNum = loan1.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// ����һ������ģ���࣬������
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		// ���
		else if (e.getSource() == deposit) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow�᷵�ظ��û����е���
			// ������û�һ�ж�û��ѡ���ͷ���-1
			if (rowNum == -1) {
				// ��ʾ
				JOptionPane.showMessageDialog(this, "��ѡ�����û�");
				return;
			}
			Deposit deposit = new Deposit(this, "���", true, cm, rowNum);
			String cardNum = deposit.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// ����һ������ģ���࣬������
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		// ȡ��
		else if (e.getSource() == draw) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow�᷵�ظ��û����е���
			// ������û�һ�ж�û��ѡ���ͷ���-1
			if (rowNum == -1) {
				// ��ʾ
				JOptionPane.showMessageDialog(this, "��ѡ��ȡ���û�");
				return;
			}
			Draw draw = new Draw(this, "ȡ��", true, cm, rowNum);
			String cardNum = draw.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// ����һ������ģ���࣬������
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		else if (e.getSource() == open) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow�᷵�ظ��û����е���
			// ������û�һ�ж�û��ѡ���ͷ���-1
			if (rowNum == -1) {
				// ��ʾ
				JOptionPane.showMessageDialog(this, "��ѡ��������ͨ�û�");
				return;
			}
			String CardNumber1 = (String) cm.getValueAt(rowNum, 0);
			Connection ct = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Statement stmt = null;
			try {
				// 1.��������
				Class.forName("com.mysql.jdbc.Driver");
				// 2.�������ݿ�
				ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
				stmt = ct.createStatement();
				String sql = "update customer1 set onlineBanking= '" + 1 + "' where cardNumber= '" + CardNumber1 + "'";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "��ͨ�����ɹ�", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception arg1) {
				arg1.printStackTrace();
			}
			String sql = "select * from customer1 where cardNumber = '" + CardNumber1 + "' ";
			// ����һ������ģ���࣬������
			cm = new CustomerModel(sql);
			table.setModel(cm);
			this.setWidth();
		}

		// ����
		else if (e.getSource() == repay) {
			int rowNum = this.table.getSelectedRow();// getSelectedRow�᷵�ظ��û����е���
			// ������û�һ�ж�û��ѡ���ͷ���-1
			if (rowNum == -1) {
				// ��ʾ
				JOptionPane.showMessageDialog(this, "��ѡ�񻹿��û�");
				return;
			}
			Repayment repayment = new Repayment(this, "����", true, cm, rowNum);
			String cardNum = repayment.cardNumber;
			String sql = "select * from customer1 where cardNumber = '" + cardNum + "' ";
			// ����һ������ģ���࣬������
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
