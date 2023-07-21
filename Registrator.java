package g;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import g.MainWdw.GuestBListener;
import g.MainWdw.RegisterBListener;
import g.MainWdw.SigninBListener;

public class Registrator extends JFrame{

	JLabel label1 = new JLabel("Введите логин:");
	public JTextField logf = new JTextField("");
	JLabel label2 = new JLabel("Введите пароль:");
	public JPasswordField pwdf = new JPasswordField("");
	
	public JButton btn = new JButton("Зарегистрироваться!");
	
	User user;
	
 
	public Registrator()
	{
		super("Регистрация");
		user = new User();
		this.setBounds(100,100,250,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3,2,2,2));
		container.add(label1);
		container.add(label2);
		
		logf.addActionListener(new LoginListener());
		pwdf.addActionListener(new PasswdListener());
		pwdf.setEchoChar('@');
		btn.addActionListener(new BtnListener());
		
		container.add(logf);
		container.add(pwdf);
		container.add(btn);
		
	}
	
	class LoginListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=logf.getText();
			System.out.println(message);
		}
	}
	
	class PasswdListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=new String(pwdf.getPassword());
			System.out.println(message);
		}
	}
	
	class BtnListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String log = logf.getText();
			String pwd = new String(pwdf.getPassword());
			
			System.out.println("registration:\n");
			
			DB1 d = new DB1(); 
			
			if (d.isUserExist(log)) 
			{
				String s = "Этт логин занят!";
				JOptionPane.showMessageDialog(null,s,"!!!",JOptionPane.PLAIN_MESSAGE);
			}
			else 
			{
				d.AddPwd(log, pwd);
				user.setL(log);
				UserInfoFormDog uif = new UserInfoFormDog(user);
				uif.setVisible(true);
			}
		}
	}	
}
