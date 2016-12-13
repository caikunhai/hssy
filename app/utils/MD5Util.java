package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class MD5Util {
	/**
	 * 用MD5算法加密
	 * @param in String : 待加密的原文
	 * @return String : 加密后的密文，如果原文为空，则返回null;
	 */
	public static String encode(final String in){
		return encode(in, "");
	}
	/**
	 * 用MD5算法加密
	 * @param in String : 待加密的原文
	 * @param charset String : 加密算法字符集
	 * @return String : 加密后的密文，若出错或原文为null，则返回null
	 */
	public static String encode(final String in, final String charset){
		if(in == null) return null;
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			if(charset==null || "".equals(charset)){
				md.update(in.getBytes());
			}else{
				try{
					md.update(in.getBytes(charset));
				}catch(Exception e){
					md.update(in.getBytes());
				}
			}
			byte[] digesta = md.digest();
			return byte2hex(digesta);
		}catch(java.security.NoSuchAlgorithmException ex){
			//出错
			return null;
		}
	}
	private static String byte2hex(final byte[] b){
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++){
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if(stmp.length() == 1){
				hs = hs + "0" + stmp;
			}else{
				hs = hs + stmp;
			}
		}
		return hs;
	}
	
	public static byte[] encode(final byte[] in){
		if(in == null) return null;
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(in);
			return md.digest();
		}catch(NoSuchAlgorithmException ex){
			return null;
		}
	}
	public MD5Util(){
	}
	
	public static void main(String[] arg){
		System.out.println(MD5Util.encode("951357"));
	}
}