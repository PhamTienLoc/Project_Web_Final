package util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
	
	public static String toBcrypt(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public static boolean checkPassword(String rawPassword, String encryptedPassword) {
		return BCrypt.checkpw(rawPassword, encryptedPassword);
	}
	
}
