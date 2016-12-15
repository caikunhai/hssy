package services;

import java.util.List;

import entities.BnsOrder;
import entities.BnsOrderChild;

public interface OrderService {
	
	public BnsOrder saveOrder(BnsOrder args);
	
	public BnsOrder get(String args);
	
	public BnsOrderChild detail(String orderId);
	
	public BnsOrder findByCode(String code);

	public List<BnsOrder> listByHostToken(String token);

	public List<BnsOrder> listByServerToken(String token);

	
}
