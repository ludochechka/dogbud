package g;

import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;

public class DB1
{

private static String url;
private static String username;
private static String password;

private static Statement statement;
private static Connection connection;




public static void GetRootPwd()
{
	RootPasswdEnterer rpwde = new RootPasswdEnterer();
	ArrayList<String> data = rpwde.enterRootPwd();
	 
	url = data.get(0);
	username = data.get(1);
	password = data.get(2);
}


public static ArrayList<String> Query(String columnName, String query) throws SQLException
{
		ResultSet resultSet;
		ArrayList<String> arr = new ArrayList<>();
		
		GetRootPwd();
		try (Connection conn = DriverManager.getConnection(url, username, password)){

			System.out.println("Connection to DB is succesfull!");
			statement = conn.createStatement();
			try {
				resultSet = statement.executeQuery(query);
			 	try {
					while(resultSet.next()){
						arr.add(resultSet.getString(columnName));
					}
					return arr;
					
				} catch (SQLException e) {
					e.printStackTrace();
					return arr;
				} 
			} catch (SQLException e1) {
				e1.printStackTrace();
				return arr;
			}

		}
	

	catch(Exception ex){
		System.out.println("Connection failed...");
		System.out.println(ex);
		return arr;
	}
}


public Integer AddUserDataDog(DogInfo di)
{
	Integer Did = -1;
	try (Connection conn = DriverManager.getConnection(url, username, password)){
		
		
		System.out.println("Connection to DB succesfull!");
        statement = conn.createStatement();
        
        String breed = di.getDbreed();
        ArrayList<String> breeds  = Query("breed_id", "Select * from breeds where (breed_name = '"+breed+"');");
        
        statement = conn.createStatement();
        
        
        if (breeds.isEmpty())  statement.executeUpdate("INSERT Breeds (breed_name) value ('"+breed+"');");	
        
        Integer breedID = Integer.valueOf(Query("breed_id", "Select * from breeds where (breed_name = '"+breed+"');") .get(0));
        statement = conn.createStatement();
        int rows = statement.executeUpdate("INSERT Dogs (name, breed_id, age, weight, Sex, Is_altered, Is_agressive) value ('"+di.getDname()+"',"
        																													+breedID+','+
        																													di.getDage()+','+
        																													di.getDweight()+','+
        					 																								di.getDsex()+','+
        																													di.getDalt()+','+
        																													di.getDagr()+");");
        
        statement = conn.createStatement();
        System.out.printf("Added %d rows", rows);
        ResultSet rs = statement.executeQuery("select id from dogs where (name = '"+di.getDname()+"' and breed_ID = "+breedID + " and weight = "+di.getDweight()+");");
        rs.next();
        Did = rs.getInt("id");	 
        return Did;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return Did;
		}

	catch(Exception ex){
	System.out.println("Connection while adding dog failed...");
	System.out.println(ex);
	return Did;
	}
}


public Integer AddUserDataOwner(OwnerInfo oi, Integer dogID, Integer adressID)
{
	Integer OID = -1;
	try (Connection conn = DriverManager.getConnection(url, username, password)){

		System.out.println("Connection to DB succesfull!");
        
        statement = conn.createStatement();
       
        int rows = statement.executeUpdate("INSERT Owners (name, dog_id, walking_hours, adress_id, phone_number) value ('"+oi.getOname()+"',"
        																													+dogID+",'"+
        																													oi.getOtime()+"',"+
         																													+adressID+",'"+
        					 																								oi.getOphone()+"');");
        
        
        System.out.printf("Added %d rows", rows);
        statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select id from owners where (name = '"+oi.getOname()+"' and walking_hours = '"+oi.getOtime()+"');");	   
        rs.next();
        OID = rs.getInt("id");  
             
		 return OID;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return OID;
		}

	catch(Exception ex){
	System.out.println("Connection while adding owner failed...");
	System.out.println(ex);
	return OID;
	}
}
 


public void AddToUsers(Integer ownerID, Integer dogID, Integer adressID, String login)
{
	try (Connection conn = DriverManager.getConnection(url, username, password)){

		System.out.println("Connection to DB succesfull!");
        
        statement = conn.createStatement();
       
        int rows = statement.executeUpdate("INSERT users (login, dog_id, owner_id, adress_id) value ('"+login+"',"
																									+dogID+","+
																									ownerID+","+
																									+adressID+");");
      
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}

	catch(Exception ex){
	System.out.println("Connection while adding to users failed...");
	System.out.println(ex);
	}
}
 

public Integer AddUserDataAdress(AdressInfo ai)
{
	Integer aID = -1;
	try (Connection conn = DriverManager.getConnection(url, username, password)){

		System.out.println("Connection to DB succesfull!");
        statement = conn.createStatement();
        
        
        int rows = statement.executeUpdate("INSERT Adress (city, street, house_number, apartment_number, coordinate_x, coordinate_y) value ('"
        																													+ai.getAcity()+"','"+
        																													ai.getAstreet()+"',"+
        																													ai.getAhouse()+","+
        					 																								ai.getAapp()+','+
        																													ai.getAx()+','+
        																													ai.getAy()+");");
        System.out.printf("Added %d rows", rows);
        statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select id from adress where (city = '"+ai.getAcity()+"' and street = '"+ai.getAstreet()+"' and house_number = "+ai.getAhouse()+" and apartment_number = "+ai.getAapp()+");");	   
        rs.next();
        aID = rs.getInt("id");     
        return aID;	 
		} catch (SQLException e1) {
			e1.printStackTrace();
			return aID;
		}

	catch(Exception ex){
	System.out.println("Connection while adding adress failed...");
	System.out.println(ex);
	return aID;
	}
}
 

 
public boolean isUserExist(String login)
{
	String query = "Select * from userdata where (login = '"+login+"');";
	ArrayList<String> arr;
	try {
		arr = Query("salt", query);
		if (arr.isEmpty()) return false;
		else return true;
		

	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	
}

public boolean AddPwd(String login, String pwd)
{
	if (isUserExist(login)) return false;
	else
	{
	try (Connection conn = DriverManager.getConnection(url, username, password)){
		
        statement = conn.createStatement();
         
        byte[] salt = new byte[16];
    	salt = SecureRandom.getSeed(16);
    	Byte[] arr = new Byte[16];
    	for (int i  = 0; i < 16; i++)
    	{
    		arr[i] = Byte.valueOf(salt[i]);
    	} 
    	String s = "";
    	for (int i  = 0; i < 16; i++)
    	{
    		s += Byte.toString(arr[i]);
    		System.out.print(arr[i]+"   ");
    	}
    	System.out.print("\n");
    	
    	Hasher h = new Hasher();
    	String passwd = h.HashWithSalt(pwd, s);
    			
        int rows = statement.executeUpdate("INSERT userdata(salt, passwd, login) VALUES ('"+s+"','"+passwd+"','"+login+"');");
        
        System.out.println("data added to db \n");
        System.out.println("you entered password " + passwd);
        System.out.println("it's salt " + salt);
        System.out.println("login " + login + '\n');
       
        
        return true;     
			 
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

	catch(Exception ex){
		
	System.out.println("Connection failed...");
	System.out.println(ex);
	return false;
	}
}	
}

public String GetPwd(String login)
{
	String pwd = "";
	
	if (isUserExist(login))
	
	{
	try (Connection conn = DriverManager.getConnection(url, username, password)){
		
        statement = conn.createStatement();
         		
       ResultSet resultSet = statement.executeQuery("select * from userdata where (login = '"+login+"');");
       
       
       resultSet.next();
       pwd = resultSet.getString("passwd");
       
       System.out.println("data got from db \n");
       System.out.println("you got passwd: " + pwd + " of " + login + " user\n");
   
   	   
        return pwd;     
			 
		} catch (SQLException e1) {
			e1.printStackTrace();
			return pwd;
		}

	catch(Exception ex){
	System.out.println("Connection failed...");
	System.out.println(ex);
	return pwd;
	}
	
}
	return pwd;
}

public String GetSalt(String login)
{
	String salt = "";
	
	if (isUserExist(login))
	
	{
	try (Connection conn = DriverManager.getConnection(url, username, password)){
		
        statement = conn.createStatement();
         		
        ResultSet resultSet = statement.executeQuery("select * from userdata where (login = '"+login+"');");
        
        resultSet.next();
        salt = resultSet.getString("salt");
        
        
       
       System.out.println("data got from db \n");
       System.out.println("you got salt: " + salt + " of " + login + "user\n");
       return salt;     
			 
		} catch (SQLException e1) {
			e1.printStackTrace();
			return salt;
		}

	catch(Exception ex){
	System.out.println("Connection failed...");
	System.out.println(ex);
	return salt;
	}
	
}
	return salt;
}

public Integer getUserId(String columnName, String query)
{
	Integer ID = -1;
	try (Connection conn = DriverManager.getConnection(url, username, password)){

		System.out.println("Connection to DB succesfull!");
        statement = conn.createStatement();
        
        ResultSet rs = statement.executeQuery(query);
        rs.next();
        ID = rs.getInt(columnName);     
        return ID;	 
		} catch (SQLException e1) {
			e1.printStackTrace();
			return ID;
		}

	catch(Exception ex){
	System.out.println("Connection while adding adress failed...");
	System.out.println(ex);
	return ID;
	}
}



public OwnerInfo getOwnerInfo(Integer ownerId)
{
	OwnerInfo oi = new OwnerInfo();
	try (Connection conn = DriverManager.getConnection(url, username, password)){

		System.out.println("Connection to DB succesfull!");
        statement = conn.createStatement();
        
        ResultSet rs = statement.executeQuery("select * from owners where (id = "+ownerId+");");
        rs.next();
        oi.setOname(rs.getString("name"));
        oi.setOphone(rs.getString("phone_number"));
        oi.setOtime(rs.getString("walking_hours"));
        return oi;	 
		} catch (SQLException e1) {
			e1.printStackTrace();
			return oi;
		}

	catch(Exception ex){
	System.out.println("Connection while adding adress failed...");
	System.out.println(ex);
	return oi;
	}
}

public DogInfo getDogInfo(Integer dogId)
{
	DogInfo di = new DogInfo();
	try (Connection conn = DriverManager.getConnection(url, username, password)){

		System.out.println("Connection to DB succesfull!");
        statement = conn.createStatement();
        
        ResultSet rs = statement.executeQuery("select * from dogs where (id = "+dogId+");");
        rs.next();
        di.setDname(rs.getString("name"));
        di.setDage(rs.getString("age"));
        di.setDweight(rs.getString("weight"));
        di.setDsex(rs.getBoolean("sex"));
        di.setDalt(rs.getBoolean("is_altered"));
        di.setDagr(rs.getBoolean("is_agressive"));
        
        statement = conn.createStatement();
        rs = statement.executeQuery("select * from dogs where (id = "+dogId+");");
        rs.next();
        
        Integer breedId = Integer.valueOf(rs.getString("breed_id"));
        statement = conn.createStatement();
        rs = statement.executeQuery("select * from breeds where (breed_id = "+breedId+");");
        rs.next();
        String breed = rs.getString("breed_name");
        di.setDbreed(breed);
        return di;	 
		} catch (SQLException e1) {
			e1.printStackTrace();
			return di;
		}

	catch(Exception ex){
	System.out.println("Connection while adding adress failed...");
	System.out.println(ex);
	return di;
	}
}

public AdressInfo getAdressInfo(Integer adressId)
{
	AdressInfo ai = new AdressInfo();
	try (Connection conn = DriverManager.getConnection(url, username, password)){

		System.out.println("Connection to DB succesfull!");
        statement = conn.createStatement();
        
        ResultSet rs = statement.executeQuery("select * from adress where (id = "+adressId+");");
        rs.next();
        ai.setAcity(rs.getString("city"));
        ai.setAstreet(rs.getString("street"));
        ai.setAhouse(rs.getString("house_number"));
        ai.setAapp(rs.getString("apartment_number"));
        ai.setAx(rs.getString("coordinate_x"));
        ai.setAy(rs.getString("coordinate_y"));
        return ai;	 
		} catch (SQLException e1) {
			e1.printStackTrace();
			return ai;
		}

	catch(Exception ex){
	System.out.println("Connection while adding adress failed...");
	System.out.println(ex);
	return ai;
	}
}

}
		







