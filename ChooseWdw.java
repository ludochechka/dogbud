package g;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ChooseWdw extends JFrame{

	
	User user;
	boolean isUser;
	public JButton button1 = new JButton("Собаки");
	public JButton button2 = new JButton("Хозяева");
	public JButton button3 = new JButton("Адреса");
	public JButton button4 = new JButton("Ближайшие собаки");
	
	public ChooseWdw(User uuser,boolean isU)
	{
		super("DogBud");
		user = uuser;
		isUser = isU;
		this.setBounds(100,100,250,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3,2,2,2));
		
		button1.addActionListener(new DogListener());
		button2.addActionListener(new OwnerListener());
		button3.addActionListener(new AdressListener());
		button4.addActionListener(new LocationListener());
		container.add(button1);
		container.add(button2);
		container.add(button3);
		container.add(button4);
	}
	
	
	class DogListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "dog";
			System.out.println(message);
			
			DogQuery dq = new DogQuery();
			dq.setVisible(true);
		}
	}
	
	class OwnerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "owner";
			System.out.println(message);
			
			OwnerQuery oq = new OwnerQuery();
			oq.setVisible(true);
		}
	}

	
	class AdressListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "adress";
			System.out.println(message);
			
			AdressQuery aq = new AdressQuery();
			aq.setVisible(true);
		}
	}
	
	class LocationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (!isUser) 
				JOptionPane.showMessageDialog(null,"данная функция доступна только \nдля зарегистрированных пользователей","!!!",JOptionPane.PLAIN_MESSAGE);
			else
			{
				String message = "location";
				System.out.println(message);
				LocationQuery lq = new LocationQuery(user);
				lq.setVisible(true);
				
			}
			
		}
	}
	
	
}
