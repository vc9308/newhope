package com.codingvictor.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Get a random hex string as "salt" to mix another hex string
 * to protect string that you want to protect
 * @author victor
 * @version 1.0
 */
public class Salt {
	
	/**
	 * 
	 * @param hexLength
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String getSalt(int hexLength) throws NoSuchAlgorithmException {
		byte[] byteArray = new byte[hexLength];
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		random.nextBytes(byteArray);
		
		return Encryption.byteArray2HexString(byteArray);
	}
	
    public static void main(String[] args) throws NoSuchAlgorithmException {
    	System.out.println(getSalt(8));
    }
}
