package bankMaster;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Home extends JFrame implements ActionListener {
	JFrame jf = new JFrame();
	Container container = jf.getContentPane();
	JButton admin, service, out;
	JPanel jp;
	JScrollPane jsp;
	
	public Home() {
		jf.setTitle("�������й���ϵͳ");
		jf.setVisible(true);// ʹ���ڿ���
		jf.setSize(400, 200);// ���ڵĴ�С
		jf.setLocation(500, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        
        admin = new JButton("  ��̨��Ա����  ");
        admin.addActionListener(this);
        service = new JButton("  �ͷ���Ա����  ");
        service.addActionListener(this);
        out = new JButton("�˳�ϵͳ");
        out.addActionListener(this);
		admin.setPreferredSize(new Dimension(200,30));
		service.setPreferredSize(new Dimension(200,30));
		out.setPreferredSize(new Dimension(200,30));
		out.setBounds(100, 100, 100, 100);
		
        jp = new JPanel();
        jp.add(admin);
		jp.add(service);
		jp.add(out);
		
		jf.add(jp);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == admin) {
			jf.dispose();
			Home_admin homeAdmin = new Home_admin();
		}
		
		
		else if(e.getSource() == service) {
			jf.dispose();
			Home_service homeService = new Home_service();
		}
		
		
		else if(e.getSource() == out){
			int n = JOptionPane.showConfirmDialog(this, "��ȷ��Ҫ�˳��", "ѯ��", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				System.exit(0);
			}
		}
	}
}
