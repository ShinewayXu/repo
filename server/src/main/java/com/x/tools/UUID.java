package com.x.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UUID {
	
	private static Pattern PAT = Pattern.compile("-");

	public static String get(){
		java.util.UUID d = java.util.UUID.randomUUID();
		String str = d.toString();
		Matcher mat = PAT.matcher(str);
		return mat.replaceAll("");
	}
}
