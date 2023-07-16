package g;

public class OwnerInfo {

		String name;
		String phone;
		String time;
		
		void setOname(String n)
		{
			name = n;
		}
		
		void setOtime(String p)
		{
			time = p;
		}
		
		void setOphone(String t)
		{
			phone = t;
		}
		
		String getOname()
		{
			return name;
		}
		
		String getOtime()
		{
			return time;
		}
		
		String getOphone()
		{
			return phone;
		}
		
		@Override
		public String toString()
		{
			String str = "";
			str += name;
			str += ",\nphone_number: " + phone;
			str += ",\nwalking hours: " + time;
			
			return str;
			
		}
	}
	
