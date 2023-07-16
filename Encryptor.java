package g;

public class Encryptor 
{

	static int AlphabetSize = 26;
	static String word;
	static String keyword = "passallexams";
	
	static Character[][] arr;
	
	Encryptor(String c)
	{
		//AlphabetSize = size;
		word = c;
		//keyword = d;
		
		arr = createMatrix();
		
	}
	
	
	public static void printMatrix(Character[][] arr)
	{
		for (int i = 0; i < AlphabetSize; i++)
		{
			for (int j = 0; j < AlphabetSize; j++)
				System.out.print(arr[i][j]);
			System.out.println("");
		}
	}
	
	public static Character[][] createMatrix()
	{ 
		
		Character[][] arr = new Character[AlphabetSize][AlphabetSize];
		char ch = 'a';
		for (int i = 0; i < AlphabetSize; i++)
		{
			char cha = ch;
			for (int j = 0; j < AlphabetSize; j++)
			{ 
				arr[i][j] = Character.valueOf(cha);
				cha = (char)(((int)cha+8)%AlphabetSize + (int)'a');
				
			} 
			ch++;
			
		}
		
		printMatrix(arr);
		return arr;
	}
	
	public static String encrypt()
	{
		String keystr = new String();
		String chifr = new String();
		
		int index = 0; 
		for (int i = 0; i < word.length();i++)
		{
			keystr+=keyword.charAt(index);
			index = (index+1)%keyword.length();
		}
		
		for (int i = 0; i < word.length(); i++)
		{
			chifr+=arr[keystr.charAt(i) - 'a'][word.charAt(i) - 'a'];
		}
		
		return chifr;
	}
	
	public static String decrypt(String chifr)
	{
		String keystr = new String();
		String str = new String();
		 
		int index = 0;  
		for (int i = 0; i < chifr.length();i++)
		{ 
			keystr+=keyword.charAt(index);
			index = (index+1)%keyword.length();
		}
		
		for (int i = 0; i < chifr.length(); i++)
		{
			str+=arr[0][(chifr.charAt(i) - (keystr.charAt(i)-'a')+7)%AlphabetSize];
		} 
		 
		return str;
	}
	
}
