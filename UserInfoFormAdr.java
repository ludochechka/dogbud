package g;


import javax.swing.*;

import g.Registrator.BtnListener;
import g.Registrator.LoginListener;
import g.Registrator.PasswdListener;

import java.awt.*;
import java.awt.event.*;

public class UserInfoFormAdr extends JFrame{

	
	
	public AdressInfo ai;
	User user;
	Integer DogID;
	
	JLabel label1 = new JLabel("Город:");
	public JTextField cityf = new JTextField("");
	JLabel label2 = new JLabel("Улица:");
	public JTextField streetf = new JTextField("");
	JLabel label3 = new JLabel("Дом:");
	public JTextField hsf = new JTextField("");
	JLabel label4 = new JLabel("Квартира:");
	public JTextField aptf = new JTextField("");
	
	JLabel label5 = new JLabel("Координата х:");
	public JTextField xf = new JTextField("");
	JLabel label6 = new JLabel("Координата у:");
	public JTextField yf = new JTextField("");
	
	
	
	public JButton btn = new JButton("Продолжить");
	
 
	public UserInfoFormAdr(User uuser, Integer dogID)
	{
		
		super("DogBud");
		DogID = dogID;
		user = uuser;
		ai = new AdressInfo();
		this.setBounds(500,500,1000,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3,2,2,2));
		
		
		
		
		
		
		cityf.addActionListener(new CityListener());
		streetf.addActionListener(new StreetListener());
		hsf.addActionListener(new HouseListener());
		aptf.addActionListener(new AppartmentListener());

		
		btn.addActionListener(new BtnListener());

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel1.add(label1);
		panel1.add(cityf); 
	    container.add(panel1);
	    
	    JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.add(label2);
		panel2.add(streetf); 
	    container.add(panel2);
	    
	    JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
		panel3.add(label3);
		panel3.add(hsf); 
	    container.add(panel3);
	    
	    JPanel panel4 = new JPanel();
	  	panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));
	  	panel4.add(label4);
	  	panel4.add(aptf); 
	  	container.add(panel4);
	  	
	  	JPanel panel5 = new JPanel();
	  	panel5.setLayout(new BoxLayout(panel5, BoxLayout.PAGE_AXIS));
	  	panel5.add(label5);
	  	panel5.add(label6);
	  	panel5.add(xf);
	  	panel5.add(yf);
	  	container.add(panel5);

		
		container.add(btn);
		
	}
	
	class CityListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=cityf.getText();
			System.out.println(message);
			ai.setAcity(message);
		}
	}
	
	class StreetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=new String(streetf.getText());
			System.out.println(message);
			ai.setAstreet(message);
		}
	}
	
	class HouseListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=hsf.getText();
			System.out.println(message);
			ai.setAhouse(message);
		}
	}
	
	class AppartmentListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=aptf.getText();
			System.out.println(message);
			ai.setAapp(message);
		}
	}
	
	
	class BtnListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			ai.setAcity(cityf.getText());
			ai.setAstreet(streetf.getText());
			ai.setAhouse(aptf.getText());
			ai.setAapp(aptf.getText());
			ai.setAx(xf.getText());
			ai.setAy(yf.getText());
			
			DB1 d = new DB1();
			
			
			Integer adrID = d.AddUserDataAdress(ai);
			user.setAi(ai);
			UserInfoForm uif = new UserInfoForm(user, DogID, adrID);
			uif.setVisible(true);;
		}
	}
	
}
