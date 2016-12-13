package utils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;


public class BeanConverter extends BeanUtilsBean {

	public static <T> T convertObject(Object source, Class<T> destType) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(source, destType);
	}

	@SuppressWarnings("unchecked")
	public static List convertList(Object source, Type destType) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(source, destType);
	}

	@SuppressWarnings("unchecked")
	public static List convertPage(Page<?> source, Type destType) {
		List<?> srcList = org.apache.commons.collections.IteratorUtils
				.toList(source.iterator());
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(srcList, destType);
	}

	public static <T> T convertBean(Class<T> c, HttpServletRequest request)
			throws Exception {
		return convertBean(c, request.getParameterMap());
	}

	public static <T> T convertBean(Class<T> c,
			Map<String, ? extends Object> map) throws Exception {
		T t = c.newInstance();
		getUtils().populate(t, map);
		return t;
	}

	public static <T> List<T> convertList(Class<T> c,
			List<Map<String, Object>> source) throws Exception {
		List<T> list = new ArrayList<T>();
		for (Map<String, Object> map : source) {
			list.add(convertBean(c, map));
		}
		return list;
	}

	public static Object valid(Object value) {
		if (!value.toString().isEmpty() && !value.toString().equals("")) {
			return value;
		}
		return null;
	}

	private static BeanUtilsBean getUtils() {
		DateConverter converter = new DateConverter();
		ConvertUtilsBean convertUtil = new ConvertUtilsBean();
		convertUtil.register(converter, java.util.Date.class);
		convertUtil.register(converter, java.sql.Date.class);
		convertUtil.register(converter, java.sql.Time.class);
		convertUtil.register(converter, java.sql.Timestamp.class);
		PropertyUtilsBean propUtil = new PropertyUtilsBean();
		return new BeanUtilsBean(convertUtil, propUtil);

	}
}
