package g;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import g.MainWdw.GuestBListener;
import g.MainWdw.RegisterBListener;
import g.MainWdw.SigninBListener;

public class GuestWarningWdw extends JFrame{


	
	JLabel text1 = new JLabel("Внимание: гостевой вход не позволяет воспользоваться полным функционалом приложения!!!");
	
	JButton button = new JButton("ok(");
	

	public GuestWarningWdw()
	{
		super("Warning!");
		this.setBounds(100,100,250,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3,2,2,2));
		container.add(text1);
		
		button.addActionListener(new OkListener());
		container.add(button);
		
	}
	
	class OkListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			User u = new User();
			ChooseWdw ch = new ChooseWdw(u,false);
			ch.setVisible(true);
		}
	}
	
	
}
