package services;

import java.util.List;

import entities.BnsOrder;
import entities.BnsOrderChild;
import entities.BnsOrderTemp;

public interface OrderService {
	
	public BnsOrder saveOrder(BnsOrder args);
	
	public BnsOrderChild saveOrderChildren(BnsOrderChild children);
	
	public BnsOrder get(String args);
	
	public BnsOrderChild detail(String id);
	
	public BnsOrder findByCode(String code);

	public List<BnsOrder> listByHostToken(String token);

	public List<BnsOrder> listByServerToken(String token);
	
	public BnsOrderTemp saveOrderTemp(BnsOrderTemp temp);
	
	public BnsOrderTemp getOrderTemp(String id);
	
	public void delOrderTemp(String id);

	public List<BnsOrder> findByCompanyAndTime(String company, String time);

}
