package g;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import g.DogQuery.DAgeListener;
import g.DogQuery.DAgrListener;
import g.DogQuery.DAltListener;
import g.DogQuery.DSexListener;
import g.DogQuery.DWeightListener;

public class OwnerQuery extends JFrame{


	
	JLabel label1 = new JLabel("Выбрать имя хозяина собаки по имени ");
	public JTextField onamef = new JTextField("");
	
	JLabel label2 = new JLabel("Выбрать телефон хозяина собаки по имени  ");
	public JTextField ophonef = new JTextField("");
	
	JLabel label3 = new JLabel("Выбрать часы прогулки собаки по имени ");
	public JTextField otimef = new JTextField("");
	

	public JButton btnName = new JButton("Продолжить");
	public JButton btnPhone = new JButton("Продолжить");
	public JButton btnTime = new JButton("Продолжить");
	
 
	public OwnerQuery()
	{
		super("DogBud");
		
		this.setBounds(500,500,1000,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3,2,2,2));
	
		btnName.addActionListener(new btnNameListener());
		
		btnPhone.addActionListener(new btnPhoneListener());
		
		btnTime.addActionListener(new btnTimeListener());

		 
		
		
	    JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel1.add(label1);
		panel1.add(onamef); 
		panel1.add(btnName); 
		container.add(panel1);
			   
		
	    JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.add(label2);
		panel2.add(ophonef); 
		panel2.add(btnPhone); 
	    container.add(panel2);
	    
	
	    JPanel panel3 = new JPanel();
	  	panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
	  	panel3.add(label3);
	  	panel3.add(otimef); 
		panel3.add(btnTime);
	  	container.add(panel3); 
	  	 
	  	 
	
	

	}
	
	class btnNameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String name = onamef.getText();
			DB1 d = new DB1();
			try {
				
				ArrayList<String> arr1  = d.Query("name", "select owners.name from dogs,owners "
						+ "where (dogs.id = owners.dog_id and dogs.name = '"+name+"');");
				if (arr1.isEmpty()) JOptionPane.showMessageDialog(null,"нет собак с таким именем!","!!!" + name +':',JOptionPane.PLAIN_MESSAGE);
				String res = "";
				for (String s:arr1)
				{
					res+=s;
					res+='\n';
				}
				JOptionPane.showMessageDialog(null,res,"Имя хозяина собаки " + name +':',JOptionPane.PLAIN_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
	}
	
	class btnPhoneListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			String name = ophonef.getText();
			DB1 d = new DB1();
			try {
				
				ArrayList<String> arr1  = d.Query("phone_number", "select owners.phone_number from dogs,owners "
						+ "where (dogs.id = owners.dog_id and dogs.name = '"+name+"');");
				if (arr1.isEmpty()) JOptionPane.showMessageDialog(null,"нет собак с таким именем!","!!!" + name +':',JOptionPane.PLAIN_MESSAGE);
				String res = "";
				for (String s:arr1)
				{
					res+=s;
					res+='\n';
				}
				JOptionPane.showMessageDialog(null,res,"номер хозяина собаки " + name +':',JOptionPane.PLAIN_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				
			
			
		}
	}
	
	class btnTimeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String name = otimef.getText();
			DB1 d = new DB1();
			try {
				
				ArrayList<String> arr1  = d.Query("walking_hours", "select owners.walking_hours from dogs,owners "
						+ "where (dogs.id = owners.dog_id and dogs.name = '"+name+"');");
				if (arr1.isEmpty()) JOptionPane.showMessageDialog(null,"нет собак с таким именем!","!!!" + name +':',JOptionPane.PLAIN_MESSAGE);
				String res = "";
				for (String s:arr1)
				{
					res+=s;
					res+='\n';
				}
				JOptionPane.showMessageDialog(null,res,"прогулки хозяина собаки" + name +':',JOptionPane.PLAIN_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
	}
}

