package g;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWdw extends JFrame{

	public JButton button1 = new JButton("Вход");
	public JButton button2 = new JButton("Регистрация");
	public JButton button3 = new JButton("Продолжить как гость");
	public JLabel label1 = new JLabel("Добро пожаловать в DogBud!");
	
	public MainWdw()
	{
		super("DogBud");
		this.setBounds(100,100,250,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3,2,2,2));
		container.add(label1);
		 
		button1.addActionListener(new SigninBListener());
		button2.addActionListener(new RegisterBListener());
		button3.addActionListener(new GuestBListener());
		
		container.add(button1);
		container.add(button2);
		container.add(button3);
		
	}
	
	class SigninBListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+="Вход";
			System.out.println(message);
			
			Autentificator au = new Autentificator();
			au.setVisible(true);
		}
	}
	
	class RegisterBListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+="Регистрация";
			System.out.println(message);
			Registrator r = new Registrator();
			r.setVisible(true);
		}
	}
	
	class GuestBListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "Гостевой доступ";
			System.out.println(message);
			GuestWarningWdw g = new GuestWarningWdw();
			g.setVisible(true);
		}
	}
}

/*
 * 
JRadiobutton rbutton = new JRadiobutton();
JRadiobutton rbutton1 = new JRadiobutton();
 ButtonGroup group = new ButtonGroup();
 group.add(rbutton);
 group.add(rbutton1);
 container.add(rbutton);
 rbutton.setSelected(true);
 */