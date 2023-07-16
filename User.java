package g;

import java.util.ArrayList;

public class User implements IUser{

	
	DogInfo di;
	OwnerInfo oi;
	AdressInfo ai;
	
	String login;
	
	public void setDi(DogInfo DI)
	{
		di = DI;
	}
	
	public void setOi(OwnerInfo OI)
	{
		oi = OI;
	}
	
	public void setAi(AdressInfo AI)
	{
		ai = AI;
	}
	
	public void setL(String L)
	{
		login = L;
	}
	
	public String dgetName()
	{
		return di.getDname();
	}
	
	public Integer dgetWeight()
	{
		return di.getDweight();
	}
	
	public String dgetBreed()
	{
		return di.getDbreed();
	}
	
	public Boolean dgetSex()
	{
		return di.getDsex();
	}
	
	public Boolean dgetAlt()
	{
		return di.getDalt();
	}
	
	public Boolean dgetAgr()
	{
		return di.getDagr();
	}
	

	public String ogetName()
	{
		return oi.getOname();
	}
	
	public String ogetPhone()
	{
		return oi.getOphone();
	}
	
	public String ogetTime()
	{
		return oi.getOtime();
	}
	
	public String agetCity()
	{
		return ai.getAcity();
	}
	
	public String agetStreet()
	{
		return ai.getAstreet();
	}
	
	public String agetHouse()
	{
		return ai.getAhouse();
	}
	
	public String agetAppp()
	{
		return ai.getAapp();
	}
	
	public Integer agetAx()
	{
		return ai.getAx();
	}
	
	public Integer agetAy()
	{
		return ai.getAy();
	}
	
	public String getLogin()
	{
		return login;
	}
	
	
	@Override
	public String toString()
	{
		String str = "User:  ";
		str += oi.toString();
		str+="\nAdress:  ";
		str += ai.toString();
		str+="\nDog:  ";
		str += di.toString();
		str+="\nLogin:  ";
		str+=login;
		
		return str;
		
	}
	
	
	
}
