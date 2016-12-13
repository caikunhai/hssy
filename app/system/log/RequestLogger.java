package system.log;

import java.sql.Timestamp;

import play.modules.spring.Spring;
import play.mvc.Http.Request;
import play.mvc.Http.RequestHeader;
import repositories.SysRequestLogRepository;

import com.google.gson.Gson;

import entities.SysRequestLog;

public class RequestLogger {

	public static final String VERSION = "1.0";

	private static final Gson CONVERTER = new Gson();

	private static SysRequestLogRepository SysRequestLogRepo;

	public static void log(Request req) {
		if (SysRequestLogRepo == null) {
			SysRequestLogRepo = Spring
					.getBeanOfType(SysRequestLogRepository.class);
		}

		String path = CONVERTER.toJson(req.path());
		if(path.length()>6){
			String body = CONVERTER.toJson(req.body());
			String queryString = CONVERTER.toJson(req.queryString());
			String ipAddr = getClientIP(req);
			String header = CONVERTER.toJson(req.headers());

			SysRequestLog log = new SysRequestLog();
			log.setBody(body);
			log.setHeader(header);
			log.setPath(path);
			log.setIp(ipAddr);
			log.setQuery(queryString);
			log.setVer(VERSION);
			log.setCreatedTime(new Timestamp(System.currentTimeMillis()));
			SysRequestLogRepo.save(log);
		}
	}

	/*private static String getIpAddr() {
		String ipAddr = null;
		try {
			ipAddr = Http.Context.current().request().remoteAddress();
		} catch (Exception ex) {
		}

		if (ipAddr == null) {
			ipAddr = "0.0.0.0";
		}

		return ipAddr;
	}*/
	
	public static String getClientIP(RequestHeader request) {
		String ip = request.getHeader("x-forwarded-for");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");

		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.remoteAddress();
		}
		
		if (ip.split(",").length > 0) {
			ip = ip.split(",")[0];
			return ip;
		}
		
		return ip;
	}
	

}
