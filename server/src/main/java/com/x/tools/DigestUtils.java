package com.x.tools;

import java.security.MessageDigest;

public class DigestUtils {

	private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	private static final char[] DIGITS_UPPER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static String md5Hex(String str) {
		return md5Hex(str, false);
	}

	private static MessageDigest messageDigest = null;
	public static String md5Hex(String str, boolean isUpper) {
		try {
			if(null == messageDigest){
				messageDigest = MessageDigest.getInstance("MD5");
			}
			return new String(encodeHex(messageDigest.digest(str.getBytes("UTF-8")),
					isUpper ? DIGITS_UPPER : DIGITS_LOWER));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static char[] encodeHex(final byte[] data, final char[] toDigits) {
		final int l = data.length;
		final char[] out = new char[l << 1];
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
			out[j++] = toDigits[0x0F & data[i]];
		}
		return out;
	}

}
