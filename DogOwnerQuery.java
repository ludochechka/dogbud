package g;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DogOwnerQuery extends JFrame{

			JLabel label1 = new JLabel("������� ����� �������� ");
			public JTextField dagef = new JTextField("");
			public JRadioButton dagel = new JRadioButton("������");//
			public JRadioButton dagem = new JRadioButton("������");//
			public JRadioButton dagee = new JRadioButton("�������");//
			
			JLabel label2 = new JLabel("������� ����� ������ ");
			public JTextField dbreedf = new JTextField("");
			
			JLabel label3 = new JLabel("������� ����� ���� ");
			public JTextField dwghf = new JTextField("");
			public JRadioButton dwghl = new JRadioButton("������");//
			public JRadioButton dwghm = new JRadioButton("������");//
			public JRadioButton dwghe = new JRadioButton("�������");//
			
			JLabel label4 = new JLabel("������� ����� ���� ");//
			public JRadioButton dsexfm = new JRadioButton("�");//
			public JRadioButton dsexff = new JRadioButton("�");//
			
			JLabel label5 = new JLabel("������� ����� ");//
			public JRadioButton daltfy = new JRadioButton("����������");//
			public JRadioButton daltfn = new JRadioButton("����������");//
			
			JLabel label6 = new JLabel("������� ����� ");//
			public JRadioButton dagrfy = new JRadioButton("�����������");//
			public JRadioButton dagrfn = new JRadioButton("�������������");//
			
			public JButton btnAge = new JButton("����������");
			public JButton btnBreed = new JButton("����������");
			public JButton btnWeight = new JButton("����������");
			public JButton btnSex = new JButton("����������");
			public JButton btnAgr = new JButton("����������");
			public JButton btnAlt = new JButton("����������");
			
			
		 
			public DogOwnerQuery()
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
				
				btnAge.addActionListener(new BtnListener());
				btnBreed.addActionListener(new BtnListener());
				btnWeight.addActionListener(new BtnListener());
				btnSex.addActionListener(new BtnListener());
				btnAlt.addActionListener(new BtnListener());
				btnAgr.addActionListener(new BtnListener());
				
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
					if (isS == false) message = "�";
						else message = "�";
					System.out.println(message);
				
				}
			}
			
			class DAltListener implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					String message = "";
					Boolean isS = daltfy.isSelected();
					if (isS == false) message = "��������";
						else message = "����������";
					System.out.println(message);
					
				}
			} 
			
			class DAgrListener implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
				 	String message = "";
					Boolean isS = dagrfy.isSelected();
					if (isS == false) message = "����������";
						else message = "������������";
					System.out.println(message);
				
				}
			}
			
			class BtnListener implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					String log = btnAgr.getText();
					String pwd = new String(btnAgr.getText());
					
					
				}
			}
			
			
			
		}


