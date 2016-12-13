package controllers;

import java.util.HashMap;
import java.util.Map;

import entities.BnsUser;
import play.libs.Json;
import play.modules.spring.Spring;
import play.mvc.Http.Context;
import repositories.BnsUserRepository;
import play.mvc.Result;
import play.mvc.Security;
import system.log.Logger;

public class Secured extends Security.Authenticator {
	
	private static BnsUserRepository userRepository;
	
	@Override
	public String getUsername(final Context ctx) {
		String token = ctx.request().getHeader("token");
		if(token==null||"null".equals(token)){
			return null;
		}
		Logger.info("token", token);
		if(play.cache.Cache.get(token)==null){
			if(userRepository==null){
				userRepository= Spring.getBeanOfType(BnsUserRepository.class);
			}
			BnsUser obj=userRepository.findByToken(token);
			if(obj==null){
				return null;
			}
		}
		return "success";
	}
	
	@Override
	public Result onUnauthorized(final Context ctx) {
		Map<String, Object> vo = new HashMap<String, Object>();
		vo.put("code", 101);
		vo.put("message", "会话过期,请重新登录.");
		return ok(Json.toJson(vo));
		//return forbidden(Json.toJson(Messages.get("无效token")));
	}
}