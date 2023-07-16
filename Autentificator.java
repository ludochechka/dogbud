package g;


import java.awt.*;
import java.awt.event.*;
import java.security.SecureRandom;

import javax.swing.*;

import g.MainWdw.GuestBListener;
import g.MainWdw.RegisterBListener;
import g.MainWdw.SigninBListener;
import g.Registrator.BtnListener;

public class Autentificator extends JFrame{

	

	JLabel label1 = new JLabel("Введите логин:");
	public JTextField logf = new JTextField("");
	JLabel label2 = new JLabel("Введите пароль:");
	public JPasswordField pwdf = new JPasswordField("");
	
	public JButton btn = new JButton("Продолжить");

	public Autentificator()
	{
		super("Autentification");
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
			
			System.out.println("autentification:\n");
			
			DB1 d = new DB1(); 
			
			String pwdS = d.GetPwd(log);
			String salt = d.GetSalt(log);
			
			Hasher h = new Hasher();
		    String pwdSalted  = h.HashWithSalt(pwd, salt);
		    System.out.println("you entered password and salted it:" + pwdSalted + "\n");
		    
			if (d.isUserExist(log))
			{
				if (!pwdS.equals(pwdSalted)) 
					{
					String s = "неверный логин или пароль!";
					JOptionPane.showMessageDialog(null,s,"!!!",JOptionPane.PLAIN_MESSAGE);
					}
				else 
					{
					User user = new User();
					user.setL(log);
					Integer dogId = d.getUserId("dog_id", "select * from users where (login = '"+log+"');");
					Integer ownerId = d.getUserId("owner_id", "select * from users where (login = '"+log+"');");
					Integer adressId = d.getUserId("adress_id", "select * from users where (login = '"+log+"');");
					
					OwnerInfo oi = d.getOwnerInfo(ownerId);
					DogInfo di = d.getDogInfo(dogId);
					AdressInfo ai = d.getAdressInfo(adressId);
					
					user.setAi(ai);
					user.setDi(di);
					user.setOi(oi);
					
					JOptionPane.showMessageDialog(null,user.toString(),"вы вошли под пользователем:",JOptionPane.PLAIN_MESSAGE);
					ChooseWdw ch = new ChooseWdw(user,true);///!!!
					ch.setVisible(true);
					}
			}
			else 
			{
				String s = "нет такого пользователя!";
				JOptionPane.showMessageDialog(null,s,"!!!",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	
}