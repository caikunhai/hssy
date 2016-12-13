package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsOrder;
import repositories.BnsOrderRepository;
import services.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private BnsOrderRepository orderRepository;
	
	@Override
	public BnsOrder saveOrder(BnsOrder arg0) {
		// TODO Auto-generated method stub
		return orderRepository.save(arg0);
	}

	@Override
	public BnsOrder get(String arg0) {
		// TODO Auto-generated method stub
		return orderRepository.findOne(arg0);
	}

	@Override
	public Iterable<BnsOrder> listAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}


	@Override
	public BnsOrder findByCode(String code) {
		// TODO Auto-generated method stub
		return orderRepository.findByCode(code);
	}

	@Override
	public List<BnsOrder> listByHost(String userId) {
		// TODO Auto-generated method stub
		return orderRepository.listByHost(userId);
	}

	@Override
	public List<BnsOrder> listByServer(String userId) {
		// TODO Auto-generated method stub
		return orderRepository.listByServer(userId);
	}

}
