package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsHotel;
import entities.BnsHotelImg;
import repositories.BnsHotelImgRepository;
import repositories.BnsHotelRepository;
import services.HotelService;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private BnsHotelRepository hotelRepository;
	
	@Autowired
	private BnsHotelImgRepository hotelImgRepository;
	
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
	public List<Object> listAll() {
		// TODO Auto-generated method stub
		return hotelRepository.listAll();
	}

	@Override
	public List<BnsHotel> search(String company) {
		// TODO Auto-generated method stub
		return hotelRepository.findByCompany(company);
	}

	@Override
	public List<BnsHotelImg> listHotelImg(String hotel) {
		// TODO Auto-generated method stub
		return hotelImgRepository.findByHotel(hotel);
	}

	@Override
	public BnsHotelImg saveImg(BnsHotelImg obj) {
		// TODO Auto-generated method stub
		return hotelImgRepository.save(obj);
	}

	@Override
	public void delImg(String id) {
		// TODO Auto-generated method stub
		hotelImgRepository.delete(id);
	}

}
