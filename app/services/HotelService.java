package services;

import java.util.List;

import entities.BnsHotel;

public interface HotelService {
	
	public BnsHotel save(BnsHotel obj);
	
	public BnsHotel get(String id);
	
	public List<Object> listAll();
	
	public List<BnsHotel> search(String company);

}