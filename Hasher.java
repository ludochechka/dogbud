package g;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Hasher {
	

public static String md5Custom(String st) {
    MessageDigest messageDigest = null;
    byte[] digest = new byte[0];

    try {
        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(st.getBytes());
        digest = messageDigest.digest();
    } catch (NoSuchAlgorithmException e) {
    	
        e.printStackTrace();
    }

    BigInteger bigInt = new BigInteger(1, digest);
    String md5Hex = bigInt.toString(16);

    while( md5Hex.length() < 32 ){
        md5Hex = "0" + md5Hex;
    }

    return md5Hex;
}

public static String HashWithSalt(String pwd, String salt)
{
	String str = "";
	str+=salt;
	str+=pwd;
	String str_hashed = md5Custom(str);
	return str_hashed;
	
}
}
