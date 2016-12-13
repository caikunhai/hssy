package utils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;

/**
 * 10659101短信平台提供接口工具类
 * 
 * @author wangqing
 * 
 */
public class CryptTool {

	public final static String CODE_SUCCESS = "00000";// 调用成功
	public final static String CODE_NVOKING_ERROR = "00001";// 调用异常
	public final static String CODE_VERIFY_FAILED = "00002";// 验证不通过
	public final static String CODE_PARAMETER_ERROR = "00003";// 请填写正确的请求参数
	public final static String CODE_DB_ERROR = "00004";// 数据库异常

	public CryptTool() {

	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * MD5 摘要计算(byte[]).
	 * 
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[] 16 bit digest
	 */
	public static byte[] md5Digest(byte[] src) throws Exception {
		java.security.MessageDigest alg = java.security.MessageDigest
				.getInstance("MD5"); // MD5 is 16 bit message digest

		return alg.digest(src);
	}

	/**
	 * MD5 摘要计算(String).
	 * 
	 * @param src
	 *            String
	 * @throws Exception
	 * @return String
	 */
	public static String md5Digest(String src) throws Exception {
		return byteArrayToHexString(md5Digest(src.getBytes()));
	}

	/**
	 * 获取时间戳timestr
	 * 
	 * @return
	 */
	public static String getDate() {
		java.util.Date dt = new java.util.Date(System.currentTimeMillis());
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		return fmt.format(dt);
	}
	
	/**
	 * 处理 10659101短信下行接口返回的json数据
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getData(String json) {
		Gson gson = new Gson();
		Map<String, String> infoMap = new HashMap<String, String>();
		infoMap = (Map<String, String>) gson.fromJson(json, infoMap.getClass());
		return infoMap;
	}

	
	
	/**
	 * 自定义订单编号生成方法
	 */
	public static String getCode(String code) {
		return code+CryptTool.getDate()+CryptTool.getNum(3);
	}
	
	
	public static String getUUID() {
		String uuid =UUID.randomUUID().toString()+UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
	
	/**
	 * 生成随机数
	 * 
	 * @param lenght
	 * @return
	 */
	public static String getNum(int lenght) {

		String[] randomValues = new String[] { "0", "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "0", "1", "0", "3", "4", "5", "6", "7", "8", "9",
				"0", "1", "2", "3", "4", "5" };
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < lenght; i++) {
			Double number = Math.random() * (randomValues.length - 1);
			str.append(randomValues[number.intValue()]);
		}
		return str.toString();
	}
	
	/**
	 * 生成随机数
	 * 
	 * @param lenght
	 * @return
	 */
	public static String getRandom(int lenght) {

		String[] randomValues = new String[] 
		  { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
		    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
		    "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
		    "u", "v", "w", "x", "y", "z", "A", "B", "C", "D",
		    "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
		    "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < lenght; i++) {
			Double number = Math.random() * (randomValues.length - 1);
			str.append(randomValues[number.intValue()]);
		}
		return str.toString();
	}
	
	/** Test crypt */
	public static void main(String[] args) {
		try {
			// 获得的明文数据
			String desStr = "123456";
			// 生成MAC
			String MAC = md5Digest(desStr);
			System.out.println(MAC);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}