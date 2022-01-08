package com.study.spring.case07.tx.dao;

public interface BookDao {
	Integer getPrice(Integer bid);
	Integer getStockAmount(Integer bid);
	Integer getWalletMoney(Integer wid);
	Integer updateStock(Integer bid, Integer amount);
	Integer updateWallet(Integer wid, Integer money);
}
