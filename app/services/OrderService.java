package services;

import java.util.List;

import entities.BnsOrder;

public interface OrderService {
	
	public BnsOrder saveOrder(BnsOrder args);
	
	public BnsOrder get(String args);
	
	public Iterable<BnsOrder> listAll();
	
	public BnsOrder findByCode(String code);

	public List<BnsOrder> listByHost(String userId);

	public List<BnsOrder> listByServer(String userId);
	
}
