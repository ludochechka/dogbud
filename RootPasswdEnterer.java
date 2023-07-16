package g;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class RootPasswdEnterer {
	
	
	public static ArrayList<String> enterRootPwd()
	{
		   FileInputStream fis;
	       Properties property = new Properties();
	       ArrayList<String> arr = new ArrayList<>();
	       try {
	           fis = new FileInputStream("src/g/config.properties");
	           property.load(fis);

	           String host = property.getProperty("db.host");
	           String login = property.getProperty("db.login");
	           String password = property.getProperty("db.password");
	           arr.add(host);
	           arr.add(login);
	           arr.add(password);
	           return arr;
	 
	       } catch (IOException e) {
	           System.err.println("ERROR: property file doesn't exist!");
	           return arr;
	       }
	}
}
