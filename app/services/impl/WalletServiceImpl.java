package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsWallet;
import repositories.BnsWalletRepository;
import services.WalletService;

@Service("walletService")
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private BnsWalletRepository walletRepository;

	@Override
	public BnsWallet save(BnsWallet obj) {
		// TODO Auto-generated method stub
		return walletRepository.save(obj);
	}

	@Override
	public BnsWallet get(String id) {
		// TODO Auto-generated method stub
		return walletRepository.findOne(id);
	}

	@Override
	public BnsWallet getWalletByToken(String token) {
		// TODO 自动生成的方法存根
		return walletRepository.findWalletByToken(token);
	}

}
