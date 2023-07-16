package g;

public class DogInfo {


			String nameD;
			String breed;
			Integer age;
			Integer weight;
			Boolean sex;
			Boolean isAltered;
			Boolean isAgressive;
			
			void setDname (String n)
			{
				nameD = n;
			}
			
			void setDbreed (String b)
			{
				breed = b;
			}
			
			void setDage(String a)
			{
				age = Integer.valueOf(a);
			}
			
			void setDweight(String w)
			{
				weight = Integer.valueOf(w);
			}
			
			void setDsex(Boolean s)
			{
				sex = s;
			}
			
			void setDagr(Boolean ag)
			{
				isAgressive = ag;
			}
			
			void setDalt(Boolean al)
			{
				isAltered = al;
			}
			
			String getDname ()
			{
				return nameD;
			}
			
			String getDbreed ()
			{
				return breed;
			}
			
			
			Integer getDage()
			{
				return age;
			}
			
			Integer getDweight()
			{
				return weight;
			}
			
			Boolean getDsex()
			{
				return sex;
			}
			
			Boolean getDagr()
			{
				return isAgressive;
			}
			
			Boolean getDalt()
			{
				return isAltered;
			}
			
			@Override
			public String toString()
			{
				String str = "";
				str += nameD;
				str += ", " + breed;
				str += ",\n age: " + age.toString();
				str += "years,\n weight: " + weight.toString();
				str += "kg,\n sex: ";
				if (sex == true) str+="male";
					else str+="female";
				str+=",\n";
				if (isAgressive == true) str+="agressive";
				else str+="not agressive";
				str+=",\n";
				if (sex == true) str+="altered";
				else str+="not altered";
				
				return str;
				
			}
			
		
		}
		
