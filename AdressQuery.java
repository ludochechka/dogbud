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

public class AdressQuery extends JFrame{


		JLabel label1 = new JLabel("Выбрать адрес хозяина собаки по имени ");
		public JTextField aadrf = new JTextField("");
		
		
		public JButton btnAdr = new JButton("Продолжить");
		
	 
		public AdressQuery()
		{
			super("DogBud");
			
			this.setBounds(500,500,1000,500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container container = this.getContentPane();
			container.setLayout(new GridLayout(3,2,2,2));
		
			btnAdr.addActionListener(new btnAdrListener());
			

			 
			
			
		    JPanel panel1 = new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
			panel1.add(label1);
			panel1.add(aadrf); 
			panel1.add(btnAdr); 
			container.add(panel1);
		 
		  	

		}
		
		class btnAdrListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = aadrf.getText();
				DB1 d = new DB1();
				try {
					 
					ArrayList<String> arrcity  = d.Query("city", "select * from dogs,owners,adress\r\n"
							+ "where (dogs.id = owners.dog_id and adress.id = owners.adress_id and dogs.name = '"+name +"');");
					
					ArrayList<String> arrstreet  = d.Query("street", "select * from dogs,owners,adress\r\n"
							+ "where (dogs.id = owners.dog_id and  adress.id = owners.adress_id and dogs.name = '"+name +"');");
					
					ArrayList<String> arrhouse  = d.Query("house_number", "select * from dogs,owners,adress\r\n"
							+ "where (dogs.id = owners.dog_id and  adress.id = owners.adress_id and dogs.name = '"+name +"');");
					
					ArrayList<String> arrap  = d.Query("apartment_number", "select * from dogs,owners,adress\r\n"
							+ "where (dogs.id = owners.dog_id and  adress.id = owners.adress_id and  dogs.name = '"+name +"');");
					if (arrcity.isEmpty()) JOptionPane.showMessageDialog(null,"нет собак с таким именем!","!!!",JOptionPane.PLAIN_MESSAGE);
					
					String adress = arrcity.get(0) + ", улица " + arrstreet.get(0) + ", дом  "+ arrhouse.get(0) +", квартира  "+ arrap.get(0);
					JOptionPane.showMessageDialog(null,adress,"адрес хозяина собаки собаки " + name +':',JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		}
		
	}


