package g;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class DogQuery extends JFrame{


		
		JLabel label1 = new JLabel("Выбрать собак возраста ");
		public JTextField dagef = new JTextField("");
		public JRadioButton dagel = new JRadioButton("меньше");//
		public JRadioButton dagem = new JRadioButton("больше");//
		public JRadioButton dagee = new JRadioButton("равного");//
		
		JLabel label2 = new JLabel("Выбрать собак породы ");
		public JTextField dbreedf = new JTextField("");
		
		JLabel label3 = new JLabel("Выбрать собак веса ");
		public JTextField dwghf = new JTextField("");
		public JRadioButton dwghl = new JRadioButton("меньше");
		public JRadioButton dwghm = new JRadioButton("больше");
		public JRadioButton dwghe = new JRadioButton("равного");
	
		JLabel label4 = new JLabel("Выбрать собак пола ");
		public JRadioButton dsexfm = new JRadioButton("м");
		public JRadioButton dsexff = new JRadioButton("ж");
		
		JLabel label5 = new JLabel("Выбрать собак ");
		public JRadioButton daltfy = new JRadioButton("стерильных");
		public JRadioButton daltfn = new JRadioButton("фертильных");
		
		JLabel label6 = new JLabel("Выбрать собак ");//
		public JRadioButton dagrfy = new JRadioButton("агрессивных");
		public JRadioButton dagrfn = new JRadioButton("неагрессивных");
		
		public JButton btnAge = new JButton("Продолжить");
		public JButton btnBreed = new JButton("Продолжить");
		public JButton btnWeight = new JButton("Продолжить");
		public JButton btnSex = new JButton("Продолжить");
		public JButton btnAgr = new JButton("Продолжить");
		public JButton btnAlt = new JButton("Продолжить");
		
	 
		public DogQuery()
		{
			super("DogBud");
			
			this.setBounds(500,500,1000,500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container container = this.getContentPane();
			container.setLayout(new GridLayout(3,2,2,2));
		
			dagef.addActionListener(new DAgeListener());
			
			dwghf.addActionListener(new DWeightListener());

			 ButtonGroup group1 = new ButtonGroup();
			 group1.add(dsexfm);
			 group1.add(dsexff);
			 dsexfm.setSelected(true);
			 
			 ButtonGroup group2 = new ButtonGroup();
			 group2.add(daltfy);
			 group2.add(daltfn);
			 daltfy.setSelected(true);
			 
			 ButtonGroup group3 = new ButtonGroup();
			 group3.add(dagrfy);
			 group3.add(dagrfn);
			 dagrfy.setSelected(true);
			 
			 ButtonGroup group4 = new ButtonGroup();
			 group4.add(dagel);
			 group4.add(dagem);
			 group4.add(dagee);
			 dagel.setSelected(true);
			 
			 ButtonGroup group5 = new ButtonGroup();
			 group5.add(dwghl);
			 group5.add(dwghm);
			 group5.add(dwghe);
			 dwghl.setSelected(true);
			 
			
			dsexfm.addActionListener(new DSexListener());
			daltfy.addActionListener(new DAltListener());
			dagrfy.addActionListener(new DAgrListener());
			
			btnAge.addActionListener(new BtnAgeListener());
			btnBreed.addActionListener(new BtnBreedListener());
			btnWeight.addActionListener(new BtnWeightListener());
			btnSex.addActionListener(new BtnSexListener());
			btnAlt.addActionListener(new BtnAltListener());
			btnAgr.addActionListener(new BtnAgrListener());
			
		    JPanel panel1 = new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
			panel1.add(label1);
			panel1.add(dagef); 
			panel1.add(dagel);
			panel1.add(dagem); 
			panel1.add(dagee); 
			panel1.add(btnAge); 
			container.add(panel1);
				   
			
		    JPanel panel2 = new JPanel();
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
			panel2.add(label2);
			panel2.add(dbreedf); 
			panel2.add(btnBreed); 
		    container.add(panel2);
		    
		
		    JPanel panel3 = new JPanel();
		  	panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
		  	panel3.add(label3);
		  	panel3.add(dwghf); 
		  	panel3.add(dwghl);
			panel3.add(dwghm);
			panel3.add(dwghe);
			panel3.add(btnWeight);
		  	container.add(panel3); 
		  	 
		  	JPanel panel4 = new JPanel();
		  	panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));
		  	panel4.add(label4);
		  	panel4.add(dsexfm); 
		  	panel4.add(dsexff); 
		  	panel4.add(btnSex,BorderLayout.EAST);
		  	container.add(panel4,BorderLayout.EAST);
		  	 
		  	JPanel panel5 = new JPanel();
		  	panel5.setLayout(new BoxLayout(panel5, BoxLayout.PAGE_AXIS));
		  	panel5.add(label5);
		  	panel5.add(daltfy); 
		  	panel5.add(daltfn); 
		  	panel5.add(btnAlt);
		  	container.add(panel5,BorderLayout.SOUTH);
		  	
		  	JPanel panel7 = new JPanel();
		  	panel7.setLayout(new BoxLayout(panel7, BoxLayout.PAGE_AXIS));
		  	panel7.add(label6);
		  	panel7.add(dagrfy); 
		  	panel7.add(dagrfn);
			panel7.add(btnAgr);
		  	container.add(panel7);
		  	

			
		}
		

		
		
		class DBreedListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String message = "";
				message+=new String(dbreedf.getText());
				System.out.println(message);
				
			}
		}
		
		class DAgeListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String message = "";
				message+=new String(dagef.getText());
				System.out.println(message);
			}
		}
		
		class DWeightListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String message = "";
				message+=new String(dwghf.getText());
				System.out.println(message);
				
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
			
			}
		}
		
		class BtnAgeListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				Integer val = Integer.valueOf(dagef.getText());
				char symbol = ' ';
				if (dagel.isSelected()) symbol = '<';
				if (dagem.isSelected()) symbol = '>';
				if (dagee.isSelected()) symbol = '=';
				DB1 d = new DB1();
				try {
					ArrayList<String> arr  = d.Query("name", "select * from dogs where (age " + symbol + val +");");
					String res = "";
					for (String s:arr)
					{
						res+=s;
						res+='\n';
					}
					JOptionPane.showMessageDialog(null,res,"Имена собак возраста " + symbol + ' '+val+':',JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		}
		
		class BtnBreedListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String breed = dbreedf.getText();
				
				DB1 d = new DB1();
				try {
					Integer bid = -1;
					ArrayList<String> arr = d.Query("breed_id", "select * from breeds where (breed_name = '" + breed +"');");
					if (arr.isEmpty()) JOptionPane.showMessageDialog(null,"в базе нет такой породы собак","!!!",JOptionPane.PLAIN_MESSAGE); 
					else
					{
						bid = Integer.valueOf(arr.get(0));
						ArrayList<String> arr1  = d.Query("name", "select * from dogs where (breed_Id =" + bid +");");
						String res = "";
						for (String s:arr1)
						{
							res+=s;
							res+='\n';
						}
						JOptionPane.showMessageDialog(null,res,"Имена собак породы " + breed +':',JOptionPane.PLAIN_MESSAGE);
					}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			}
		}
		
		class BtnWeightListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				Integer val = Integer.valueOf(dwghf.getText());
				char symbol = ' ';
				if (dwghl.isSelected()) symbol = '<';
				if (dwghm.isSelected()) symbol = '>';
				if (dwghe.isSelected()) symbol = '=';
				DB1 d = new DB1();
				try {
					ArrayList<String> arr  = d.Query("name", "select * from dogs where (weight " + symbol + val +");");
					String res = "";
					for (String s:arr)
					{
						res+=s;
						res+='\n';
					}
					JOptionPane.showMessageDialog(null,res,"Имена собак массой " + symbol + ' '+val+':',JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		}
		
		class BtnSexListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				int symbol = -1;
				if (dsexfm.isSelected()) symbol = 1;
				if (dsexff.isSelected()) symbol = 0;
				DB1 d = new DB1();
				try {
					ArrayList<String> arr  = d.Query("name", "select * from dogs where (sex = " + symbol +");");
					String res = "";
					for (String s:arr)
					{
						res+=s;
						res+='\n';
					}
					String sex = "";
					if (symbol == 0) sex+="женского";
					else sex+="мужского";
					JOptionPane.showMessageDialog(null,res,"Имена собак " + sex + " пола:",JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		}
		
		class BtnAltListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				int symbol = -1;
				if (daltfy.isSelected()) symbol = 1;
				if (daltfn.isSelected()) symbol = 0;
				DB1 d = new DB1();
				try {
					ArrayList<String> arr  = d.Query("name", "select * from dogs where (is_altered = " + symbol +");");
					String res = "";
					for (String s:arr)
					{
						res+=s;
						res+='\n';
					}
					String alt = "";
					if (symbol == 0) alt+="не";
					JOptionPane.showMessageDialog(null,res,"Имена собак " + alt + "кастрированных: ",JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		}
		
		class BtnAgrListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				int symbol = -1;
				if (dagrfy.isSelected()) symbol = 1;
				if (dagrfn.isSelected()) symbol = 0;
				DB1 d = new DB1();
				try {
					ArrayList<String> arr  = d.Query("name", "select * from dogs where (is_agressive = " + symbol +");");
					String res = "";
					for (String s:arr)
					{
						res+=s;
						res+='\n';
					}
					String alt = "";
					if (symbol == 0) alt+="не";
					JOptionPane.showMessageDialog(null,res,"Имена собак " + alt + "агрессивных: ",JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		}
		
	}
