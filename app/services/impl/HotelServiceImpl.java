package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsHotel;
import repositories.BnsHotelRepository;
import services.HotelService;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private BnsHotelRepository hotelRepository;

	@Override
	public BnsHotel save(BnsHotel obj) {
		// TODO Auto-generated method stub
		return hotelRepository.save(obj);
	}

	@Override
	public BnsHotel get(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findOne(id);
	}

	@Override
	public List<BnsHotel> listAll() {
		// TODO Auto-generated method stub
		return hotelRepository.listAll();
	}

	@Override
	public List<BnsHotel> search(String company) {
		// TODO Auto-generated method stub
		return hotelRepository.findByCompany(company);
	}

}
