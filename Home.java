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
		jf.setTitle("村镇银行管理系统");
		jf.setVisible(true);// 使窗口可视
		jf.setSize(400, 200);// 窗口的大小
		jf.setLocation(500, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        
        admin = new JButton("  柜台人员管理  ");
        admin.addActionListener(this);
        service = new JButton("  客服人员管理  ");
        service.addActionListener(this);
        out = new JButton("退出系统");
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
			int n = JOptionPane.showConfirmDialog(this, "你确定要退出嘛？", "询问", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				System.exit(0);
			}
		}
	}
}
