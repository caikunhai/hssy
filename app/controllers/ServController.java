package controllers;
import static play.data.Form.form;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import services.ClothService;
import services.ServService;
import system.log.Logger;
import utils.CryptTool;
import bean.ClothesForm;

import com.thoughtworks.xstream.XStream;

import org.springframework.stereotype.Controller;

@Controller
public class ServController extends play.mvc.Controller {
	
	private static ServService servService;

	@Autowired
	@Qualifier("servService")
	public void setServService(ServService servService) {
		ServController.servService = servService;
	}
	
	

}
