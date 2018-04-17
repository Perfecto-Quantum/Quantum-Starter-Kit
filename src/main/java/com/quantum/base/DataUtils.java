 /**
 * 
 */
package com.quantum.base;

import org.sonatype.plexus.components.cipher.DefaultPlexusCipher;
import org.sonatype.plexus.components.cipher.PlexusCipherException;
import org.sonatype.plexus.components.sec.dispatcher.DefaultSecDispatcher;

public final class DataUtils {
	
	////***** For Isolation Testing Purpose ONLY, should comments out when done *****
	//// To create the encode password, we can use maven command line
	////		$>mvn -emp hello
	//// Result Ecnoded password is= {DaouGqdidtQHdeGK7OTFPZJbuKvMNN5uYEECd9LS2sA=}
	//// This allows you to the test within this class only...
	
//	public static void main(String[] args) throws Exception {	
//		String myPassword = "{lRbS2im3N+sHiGWQUYZ4kjJioMwVOsZHMANIMknlhxU=}";
//		System.out.println("Encoded PW.... " +myPassword);
//		System.out.println("Decoded PW.... " +decodeMasterPassword(myPassword));	
//	}
	//===========================================================
	
	private static String decodePassword(String encodedPassword, String key) throws PlexusCipherException {
		DefaultPlexusCipher cipher = new DefaultPlexusCipher();
		return cipher.decryptDecorated(encodedPassword, key);
	}
	
	public static String decodeMasterPassword(String encodedMasterPassword) throws PlexusCipherException {
		return decodePassword(encodedMasterPassword, DefaultSecDispatcher.SYSTEM_PROPERTY_SEC_LOCATION);
	}
}
