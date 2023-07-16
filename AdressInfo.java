package g;

public class AdressInfo {

			String city;
			String street;
			String  house;
			String app;
			
			Integer coordinate_x;
			Integer coordinate_y;
			
			void setAcity(String c)
			{
				city = c;
			}
			
			void setAstreet(String s)
			{
				street = s;
			}
			
			void setAhouse(String h)
			{
				house = h;
			}
			
			void setAapp(String a)
			{
				app = a;
			}
			
			void setAx(String x)
			{
				coordinate_x = Integer.valueOf(x);
			}
			
			void setAy(String y)
			{
				coordinate_y = Integer.valueOf(y);
			}
			
			String getAcity()
			{
				return city;
			}
			
			String getAstreet()
			{
				return street;
			}
			
			String getAhouse()
			{
				return house;
			}
			
			String getAapp()
			{
				return app;
			}
			
			Integer getAx()
			{
				return coordinate_x;
			}
			
			Integer getAy()
			{
				return coordinate_y;
			}
			
			@Override
			public String toString()
			{
				String str = "";
				str += city;
				str += ", " + street;
				str += "street,\n " + house;
				str += ",\n" + app;
				
				str += "x:" + coordinate_x.toString();
				str += "\ny:" + coordinate_y.toString();
				return str;
				
			}
		}
		

