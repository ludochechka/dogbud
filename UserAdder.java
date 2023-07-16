package g;

import java.util.ArrayList;

public class UserAdder {

	
	public void AddUser(String login, String pwd)
	{
		RootPasswdEnterer rpwde = new RootPasswdEnterer();
		ArrayList<String> data = rpwde.enterRootPwd();
		if (data.size()==3)
		{
			String url = data.get(0);
			String username = data.get(1);
			String password = data.get(2);
			
			DB db = new DB(url,username,password);
			
			db.AddUserData(login,pwd);
		}
		
	}
}
