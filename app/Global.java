import java.io.File;
import java.lang.reflect.Method;

import play.Application;
import play.Configuration;
import play.GlobalSettings;
import play.api.mvc.Handler;
import play.libs.Json;
import play.mvc.Action;
import play.mvc.Http.Request;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;
import play.mvc.Results;
import system.init.SetupManager;
import system.log.Logger;
import system.log.RequestLogger;
import utils.HttpResult;

/**
 * play 初始化文件
 * 
 * @author caikunhai 20140818
 * 
 */
public class Global extends GlobalSettings {
	
	private static String LOG_TAG = Global.class.getSimpleName();

	@Override
	public void beforeStart(Application arg0) {
		super.beforeStart(arg0);
	}

	@Override
	public void onStart(Application app) {
		try {
			SetupManager.setup();
		} catch (Exception e) {
			Logger.error(LOG_TAG, "系统初始化时出现异常！", e);
		}
		Logger.info(LOG_TAG, "onStart");
	}

	@Override
	public Result onError(RequestHeader reqHeader, Throwable tr) {
		HttpResult result = new HttpResult();
		result.setMessage(tr.getMessage());
		Logger.error(LOG_TAG, "系统出现一个未经正常捕获的异常，请注意！", tr);
		return Results.internalServerError(Json.toJson(result));
	}

	@Override
	public Action<?> onRequest(Request req, Method method) {
		 //RequestLogger.log(req);
		return super.onRequest(req, method);
	}

	@Override
	public <A> A getControllerInstance(Class<A> arg0) throws Exception {
		// TODO Auto-generated method stub
		return super.getControllerInstance(arg0);
	}

	@Override
	public Result onBadRequest(RequestHeader arg0, String arg1) {
		// TODO Auto-generated method stub
		Logger.warn(LOG_TAG, "onBadRequest");
		return super.onBadRequest(arg0, arg1);
	}

	@Override
	public Result onHandlerNotFound(RequestHeader header) {
		// TODO Auto-generated method stub
		Logger.warn(LOG_TAG, "onHandlerNotFound,method:" + header.method()
				+ " ,path: " + header.path());
		return super.onHandlerNotFound(header);
	}

	@Override
	public Configuration onLoadConfig(Configuration arg0, File arg1,
			ClassLoader arg2) {
		return super.onLoadConfig(arg0, arg1, arg2);
	}

	@Override
	public Handler onRouteRequest(RequestHeader header) {
		return super.onRouteRequest(header);
	}

	@Override
	public void onStop(Application arg0) {
		// TODO Auto-generated method stub
		Logger.info(LOG_TAG, "onStop");
		super.onStop(arg0);
	}
	
	
}