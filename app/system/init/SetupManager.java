package system.init;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import play.modules.spring.Spring;
import repositories.BnsClothesRepository;
import repositories.BnsCompanyRepository;
import repositories.BnsHotelRepository;
import repositories.BnsSiteRepository;
import entities.BnsClothes;
import entities.BnsCompany;
import entities.BnsHotel;
import entities.BnsSite;

public class SetupManager {
	
	public static void setup(){
		initCompany();
	}
	
	
	//初始化住宿
	public static void initHotel() {
		Map<String,BnsHotel> map =new HashMap<String,BnsHotel>();
		BnsHotelRepository hotelRepository =Spring.getBeanOfType(BnsHotelRepository.class);
		Iterable<BnsHotel> itr =hotelRepository.findAll();
		Iterator<BnsHotel> it= itr.iterator();
		while(it.hasNext()){
			BnsHotel obj =it.next();
			map.put(obj.getId(), obj);
		}
		play.cache.Cache.set("hotel", map);
		
	}
	
	//初始化景点
	public static void initSite() {
		Map<String,BnsSite> map =new HashMap<String,BnsSite>();
		BnsSiteRepository siteRepository =Spring.getBeanOfType(BnsSiteRepository.class);
		Iterable<BnsSite> itr =siteRepository.findAll();
		Iterator<BnsSite> it= itr.iterator();
		while(it.hasNext()){
			BnsSite obj =it.next();
			map.put(obj.getId(), obj);
		}
		play.cache.Cache.set("site", map);
	}
	
	//初始化服饰
	public static void initClothes() {
		Map<String,BnsClothes> map =new HashMap<String,BnsClothes>();
		BnsClothesRepository clothesRepository =Spring.getBeanOfType(BnsClothesRepository.class);
		Iterable<BnsClothes> itr =clothesRepository.findAll();
		Iterator<BnsClothes> it= itr.iterator();
		while(it.hasNext()){
			BnsClothes obj =it.next();
			map.put(obj.getId(), obj);
		}
		play.cache.Cache.set("cloth", map);
	}
	
	//缓存高级服务商
	public static void initCompany() {
		Map<String,BnsCompany> map =new HashMap<String,BnsCompany>();
		BnsCompanyRepository companyRepository =Spring.getBeanOfType(BnsCompanyRepository.class);
		List<BnsCompany> list =companyRepository.findService();
		for(BnsCompany obj:list){
			map.put(obj.getId(), obj);
		}
		play.cache.Cache.set("company", map);
	}
	
}
