package g;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import g.AdressQuery.btnAdrListener;

public class LocationQuery extends JFrame{


	JLabel label1 = new JLabel("Вывести имена всех собак, живущих не далее чем ");
	public JTextField dlocf = new JTextField("");
	User U = new User();
	
	public JButton btnLoc = new JButton("Продолжить");
	
 
	public LocationQuery(User user)
	{
		super("DogBud");
		U = user;
		this.setBounds(500,500,1000,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3,2,2,2));
	
		btnLoc.addActionListener(new btnLocListener());
		

		 
		
		
	    JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel1.add(label1);
		panel1.add(dlocf); 
		panel1.add(btnLoc); 
		container.add(panel1);
	 
	  	

	}
	
	class btnLocListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Integer distance = Integer.valueOf(dlocf.getText());
			if (distance < 0) JOptionPane.showMessageDialog(null,"расстояние не может быть < 0 км","!!!",JOptionPane.PLAIN_MESSAGE);
			else
			{
				DB1 d = new DB1();
				try {
					Integer X = U.agetAx();
					Integer Y = U.agetAy();
					ArrayList<String> arr = d.Query("dogs.name", 
												"select dogs.name from dogs,owners,adress where "
												+ "(dogs.id = owners.dog_id and "
												+ "owners.adress_id = adress.id and "
												+ "sqrt(pow(adress.coordinate_x - "+ X +",2) + "
														+ "pow(adress.coordinate_y - " + Y + ",2)) < " + distance + ");");

					
					
					
					String names = "список собак, чьи хозяева живут\n не далее чем "+distance+" км от вас:\n\n";
					for (String s:arr)
					{
						names+=s;
						names+='\n';
					}
					JOptionPane.showMessageDialog(null,names,"!!!",JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
			
			
			
		}
	}
	
}



