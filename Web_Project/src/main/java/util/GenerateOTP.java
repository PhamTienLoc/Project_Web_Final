package util;

import java.security.SecureRandom;

public class GenerateOTP {

	public static String generateOTP(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("Độ dài OTP phải lớn hơn 0.");
		}

		final String digits = "0123456789";
		char[] otp = new char[length];
		SecureRandom random = new SecureRandom();

		for (int i = 0; i < length; i++) {
			otp[i] = digits.charAt(random.nextInt(digits.length()));
		}

		return new String(otp);

	}
}
