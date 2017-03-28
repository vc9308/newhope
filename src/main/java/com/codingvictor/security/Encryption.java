package com.codingvictor.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Encrypt any string will be protected
 * @author victor
 * @version 1.0
 */
public class Encryption {

	public enum Algorithms {
		MD2("MD2"), MD5("MD5"), SHA_1("SHA-1"), SHA_256("SHA-256"), SHA512("SHA-512");
		
		private String string;
		
		Algorithms(String string) {
			this.string = string;
		}
		
		public String toString() {
			return string;
		}
	}
	
	/**
	 * This method returns encrypted string by specifically algorithms
	 * @param originStr origin string will encrypt
	 * @param algorithms encryption algorithm
	 * @return encrypted string
	 * @throws NoSuchAlgorithmException 
	 */
    public static String generate(String originStr, Algorithms algorithms) throws NoSuchAlgorithmException {
    	String result = null;
    	
    	if (originStr != null && originStr.length() > 0) {  
                MessageDigest messageDigest = MessageDigest.getInstance(algorithms.toString());
                byte[] originByte = originStr.getBytes(StandardCharsets.UTF_8);
                byte[] encryptedByte = messageDigest.digest(originByte);

                result = byteArray2HexString(encryptedByte);
                
        }  
        return result;
    }
    
    /**
     * @param byteArray any byte array will convert to string
     * @return
     */
    
    public static String byteArray2HexString(byte[] byteArray) {
    	StringBuffer hexStringBuffer = new StringBuffer();  
        for (int i = 0; i < byteArray.length; i++) {  
            String hex = Integer.toHexString(0xff & byteArray[i]);  
            if (hex.length() == 1) {
            	hexStringBuffer.append('0');
            }
            hexStringBuffer.append(hex);
        }
        return hexStringBuffer.toString();
    }
    
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String result = generate("0", Algorithms.SHA_256);
		System.out.println(result);
		// SHA-256: 5feceb66ffc86f38d952786c6d696c79c2dbc239dd4e91b46729d73a27fb57e9
	}
}

