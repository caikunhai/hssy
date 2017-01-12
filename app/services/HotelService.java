package services;

import java.util.List;

import entities.BnsHotel;
import entities.BnsHotelImg;

public interface HotelService {
	
	public BnsHotel save(BnsHotel obj);
	
	public BnsHotel get(String id);
	
	public List<Object> listAll();
	
	public List<BnsHotel> search(String company);
	
	public List<BnsHotelImg> listHotelImg(String hotel);
	
	public BnsHotelImg saveImg(BnsHotelImg obj);
	
	public void delImg(String id);

}
