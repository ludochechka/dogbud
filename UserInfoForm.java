package g;

import javax.swing.*;

import g.Registrator.BtnListener;
import g.Registrator.LoginListener;
import g.Registrator.PasswdListener;

import java.awt.*;
import java.awt.event.*;

public class UserInfoForm extends JFrame{

	public OwnerInfo oi;
	User user;
	
	Integer dogID, adrID;
	
	JLabel label1 = new JLabel("Имя:");
	public JTextField namef = new JTextField("");
	
	
	JLabel label2 = new JLabel("Телефонный номер:");
	public JTextField phonef = new JTextField("");
	
	
	JLabel label3 = new JLabel("Время прогулок:");
	public JTextField timef = new JTextField("");
	

	public JButton btn = new JButton("Продолжить");
	
 
	public UserInfoForm(User uuser, Integer Dogid, Integer Adrid)
	{
		
		super("DogBud");
		dogID = Dogid;
		adrID = Adrid;
		oi = new OwnerInfo();
		user = uuser;
		this.setBounds(500,500,1000,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3,2,2,2));;
		
		namef.addActionListener(new NameListener());
	    	phonef.addActionListener(new PhoneListener());
		timef.addActionListener(new TimeListener());

		btn.addActionListener(new BtnListener());
		 
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel1.add(label1);
		panel1.add(namef); 
	    container.add(panel1);
	    
	    JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.add(label2);
		panel2.add(phonef); 
	    container.add(panel2);
	    
	    JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
		panel3.add(label3);
		panel3.add(timef); 
	    container.add(panel3);
		
		
		container.add(btn);
		
	}
	
	class NameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=namef.getText();
			System.out.println(message);
			oi.setOname(message);
		}
	}
	
	class PhoneListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=new String(phonef.getText());
			System.out.println(message);
			oi.setOphone(message);
		}
	}
	
	class TimeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=timef.getText();
			System.out.println(message);
			oi.setOtime(message);
		}
	}
	
	
	class BtnListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			oi.setOname(namef.getText());
			oi.setOphone(phonef.getText());
			oi.setOtime(timef.getText());
			
			user.setOi(oi);
			
			JOptionPane.showMessageDialog(null,user.toString(),"вы зарегистрировали пользователя!:",JOptionPane.PLAIN_MESSAGE);
			
			DB1 d = new DB1();
			Integer oid = d.AddUserDataOwner(oi, dogID, adrID);
			d.AddToUsers(oid, dogID, adrID, user.getLogin());
			
			ChooseWdw ch = new ChooseWdw(user,true);
			ch.setVisible(true);
		
		}
	}
}
