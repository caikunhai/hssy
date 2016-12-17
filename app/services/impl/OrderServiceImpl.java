package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.BnsOrderChildRepository;
import repositories.BnsOrderRepository;
import services.OrderService;
import entities.BnsOrder;
import entities.BnsOrderChild;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private BnsOrderRepository orderRepository;
	
	@Autowired
	private BnsOrderChildRepository orderChildRepository;
	
	
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
	public BnsOrder findByCode(String code) {
		// TODO Auto-generated method stub
		return orderRepository.findByCode(code);
	}

	@Override
	public List<BnsOrder> listByHostToken(String token) {
		// TODO Auto-generated method stub
		return orderRepository.findByHostToken(token);
	}

	@Override
	public List<BnsOrder> listByServerToken(String token) {
		// TODO Auto-generated method stub
		return orderRepository.findByServerToken(token);
	}

	@Override
	public BnsOrderChild detail(String orderId) {
		// TODO 自动生成的方法存根
		return orderChildRepository.findByOrderId(orderId);
	}

	@Override
	public BnsOrderChild saveOrderChildren(BnsOrderChild children) {
		// TODO 自动生成的方法存根
		return orderChildRepository.save(children);
	}

}
