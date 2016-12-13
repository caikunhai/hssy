package services;

import entities.BnsWallet;

public interface WalletService {
	
	public BnsWallet save(BnsWallet obj);
	
	public BnsWallet get(String id);

}
