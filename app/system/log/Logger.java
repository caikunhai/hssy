package system.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;

import play.modules.spring.Spring;
import play.mvc.Http;
import repositories.SysLogRepository;
import entities.SysLog;

public class Logger {

	private static SysLogRepository SysLogRepo;

	public static void error(String tag, String msg) {
		error(tag, msg, null);
	}

	public static void error(String tag, String msg, Throwable tr) {
		write(tag, msg, tr, LogType.ERROR);
	}

	public static void warn(String tag, String msg, Throwable tr) {
		write(tag, msg, tr, LogType.WARN);
	}

	public static void warn(String tag, String msg) {
		warn(tag, msg, null);
	}

	public static void info(String tag, String msg, Throwable tr) {
		write(tag, msg, tr, LogType.INFO);
	}

	public static void info(String tag, String msg) {
		info(tag, msg, null);
	}

	public static void debug(String tag, String msg, Throwable tr) {
		write(tag, msg, tr, LogType.DEBUG);
	}

	public static void debug(String tag, String msg) {
		debug(tag, msg, null);
	}

	private static String getIpAddr() {
		String ipAddr = null;

		try {
			ipAddr = Http.Context.current().request().remoteAddress();
		} catch (Exception ex) {
		}

		if (ipAddr == null) {
			ipAddr = "0.0.0.0";
		}

		return ipAddr;
	}

	private static String initLogContent(String msg, Throwable tr) {
		String content = msg;

		if (tr != null) {
			content += "\n\n" + getStackTrace(tr);
		}

		return content;
	}

	private static String getStackTrace(Throwable tr) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		tr.printStackTrace(pw);
		return sw.toString();
	}

	private static void write(String tag, String msg, Throwable tr, LogType type) {
		if (SysLogRepo == null) {
			SysLogRepo = Spring.getBeanOfType(SysLogRepository.class);
		}
		SysLog log = new SysLog();
		log.setTag(tag);
		log.setIp(getIpAddr());
		log.setType(type.ordinal());
		log.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		log.setContent(initLogContent(msg, tr));
		SysLogRepo.save(log);

		if (tr != null) {
			tr.printStackTrace();
		}
	}

}
