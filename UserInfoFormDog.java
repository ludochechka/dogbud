package g;


import javax.swing.*;

import g.Registrator.BtnListener;
import g.Registrator.LoginListener;
import g.Registrator.PasswdListener;

import java.awt.*;
import java.awt.event.*;

public class UserInfoFormDog extends JFrame{

	
	
	DogInfo di;
	User user;

	
	JLabel label1 = new JLabel("Имя собакиè:");
	public JTextField dnamef = new JTextField("");
	
	JLabel label2 = new JLabel("Порода собаки:");
	public JTextField dbreedf = new JTextField("");//
	
	JLabel label3 = new JLabel("Возраст собаки:");//
	public JTextField dagef = new JTextField("");//
	
	JLabel label4 = new JLabel("Вес собаки:");//
	public JTextField dwghf = new JTextField("");//
	
	JLabel label5 = new JLabel("Пол собаки:");//
	public JRadioButton dsexfm = new JRadioButton("м");//
	public JRadioButton dsexff = new JRadioButton("ж");//
	
	JLabel label6 = new JLabel("Кастрирована/стерилизована ли собака?:");//
	public JRadioButton daltfy = new JRadioButton("да");//
	public JRadioButton daltfn = new JRadioButton("нет");//
	
	JLabel label7 = new JLabel("Агрессивна ли собака?:");//
	public JRadioButton dagrfy = new JRadioButton("да");//
	public JRadioButton dagrfn = new JRadioButton("нт");//
	
	public JButton btn = new JButton("Продолжить");
	
 
	public UserInfoFormDog(User uuser)
	{
		super("DogBud");
		di = new DogInfo();
		user = uuser;
		
		this.setBounds(500,500,1000,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3,2,2,2));
	
		dnamef.addActionListener(new DNameListener());
		dbreedf.addActionListener(new DBreedListener());
		dagef.addActionListener(new DAgeListener());
		dwghf.addActionListener(new DWeightListener());

		 ButtonGroup group1 = new ButtonGroup();
		 group1.add(dsexfm);
		 group1.add(dsexff);
		 //container.add(dsexfm);
		 dsexfm.setSelected(true);
		 
		 ButtonGroup group2 = new ButtonGroup();
		 group2.add(daltfy);
		 group2.add(daltfn);
		 //container.add(daltfy);
		 daltfy.setSelected(true);
		 
		 ButtonGroup group3 = new ButtonGroup();
		 group3.add(dagrfy);
		 group3.add(dagrfn);
		 //container.add(dagrfy);
		 dagrfy.setSelected(true);
		 
		 
		dsexfm.addActionListener(new DSexListener());
		daltfy.addActionListener(new DAltListener());
		dagrfy.addActionListener(new DAgrListener());
		
		btn.addActionListener(new BtnListener());

		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel1.add(label1);
		panel1.add(dnamef); 
	    container.add(panel1);
	    
	    JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.add(label2);
		panel2.add(dbreedf); 
	    container.add(panel2);
	    
	    JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
		panel3.add(label3);
		panel3.add(dagef); 
	    container.add(panel3);
	    
	    JPanel panel4 = new JPanel();
	  	panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));
	  	panel4.add(label4);
	  	panel4.add(dwghf); 
	  	container.add(panel4);
	  	
	  	JPanel panel5 = new JPanel();
	  	panel5.setLayout(new BoxLayout(panel5, BoxLayout.PAGE_AXIS));
	  	panel5.add(label5);
	  	panel5.add(dsexfm); 
	  	panel5.add(dsexff); 
	  	container.add(panel5);
	  	 
	  	JPanel panel6 = new JPanel();
	  	panel6.setLayout(new BoxLayout(panel6, BoxLayout.PAGE_AXIS));
	  	panel6.add(label6);
	  	panel6.add(daltfy); 
	  	panel6.add(daltfn); 
	  	container.add(panel6);
	  	
	  	JPanel panel7 = new JPanel();
	  	panel7.setLayout(new BoxLayout(panel7, BoxLayout.PAGE_AXIS));
	  	panel7.add(label7);
	  	panel7.add(dagrfy); 
	  	panel7.add(dagrfn);
	  	container.add(panel7);
	  	

		container.add(btn);
		
	}
	

	class DNameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=new String(dnamef.getText());
			System.out.println(message);
			di.setDname(message);
		}
	}
	
	class DBreedListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=new String(dbreedf.getText());
			System.out.println(message);
			di.setDbreed(message);
		}
	}
	
	class DAgeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=new String(dagef.getText());
			System.out.println(message);
			di.setDage(message);
		}
	}
	
	class DWeightListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			message+=new String(dwghf.getText());
			System.out.println(message);
			di.setDweight(message);
		}
	}
	
	class DSexListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			Boolean isS = dsexfm.isSelected();
			if (isS == false) message = "м";
				else message = "ж";
			System.out.println(message);
			di.setDsex(isS);
		}
	}
	
	class DAltListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String message = "";
			Boolean isS = daltfy.isSelected();
			if (isS == false) message = "стерилен";
				else message = "нестерилен";
			System.out.println(message);
			di.setDalt(isS);
		}
	} 
	
	class DAgrListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		 	String message = "";
			Boolean isS = dagrfy.isSelected();
			if (isS == false) message = "агрессивен";
				else message = "неагрессивен";
			System.out.println(message);
			di.setDagr(isS);
		}
	}
	
	class BtnListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			di.setDname(dnamef.getText());
			di.setDweight(dwghf.getText());
			di.setDbreed(dbreedf.getText());
			di.setDage(dagef.getText());
			
			Boolean isS = dsexfm.isSelected();
			di.setDsex(isS);
			
			isS = dagrfy.isSelected();
			di.setDagr(isS);
			
			isS = daltfy.isSelected();
			di.setDalt(isS);
			
			user.setDi(di);
			
			DB1 db = new DB1();
			Integer dogID = db.AddUserDataDog(di);
			
			UserInfoFormAdr uifa = new UserInfoFormAdr(user,dogID);///!!!!!
			uifa.setVisible(true);
		}
	}
	
}
