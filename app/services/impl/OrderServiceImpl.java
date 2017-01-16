package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsOrder;
import entities.BnsOrderChild;
import entities.BnsOrderTemp;
import repositories.BnsOrderChildRepository;
import repositories.BnsOrderRepository;
import repositories.BnsOrderTempRepository;
import services.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private BnsOrderRepository orderRepository;
	
	@Autowired
	private BnsOrderChildRepository orderChildRepository;
	
	@Autowired
	private BnsOrderTempRepository orderTempRepository;
	
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
		return orderChildRepository.findOne(orderId);
	}

	@Override
	public BnsOrderChild saveOrderChildren(BnsOrderChild children) {
		// TODO 自动生成的方法存根
		return orderChildRepository.save(children);
	}

	@Override
	public BnsOrderTemp saveOrderTemp(BnsOrderTemp temp) {
		// TODO Auto-generated method stub
		return orderTempRepository.save(temp);
	}

	@Override
	public BnsOrderTemp getOrderTemp(String id) {
		// TODO Auto-generated method stub
		return orderTempRepository.findOne(id);
	}

	@Override
	public void delOrderTemp(String id) {
		// TODO Auto-generated method stub
		orderTempRepository.delete(id);
	}

	@Override
	public List<BnsOrder> findByCompanyAndTime(String company, String time) {
		// TODO Auto-generated method stub
		return orderRepository.findByCompanyAndTime(company, time);
	}

}
