package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.NotifyAlipay;
import repositories.NotifyAlipayRepository;
import services.NotifyService;

@Service("notifyService")
public class NotifyServiceImpl implements NotifyService {
	
	@Autowired
	private NotifyAlipayRepository alipayRepository;

	@Override
	public NotifyAlipay saveDirect(NotifyAlipay arg0) {
		// TODO Auto-generated method stub
		return alipayRepository.save(arg0);
	}

}
