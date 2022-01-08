package com.study.spring.case07.tx.dao;

import com.study.spring.case07.tx.exception.InsufficientAmount;
import com.study.spring.case07.tx.exception.InsufficientQuantity;

public interface BookDao {
	Integer getPrice(Integer bid);
	Integer getStockAmount(Integer bid);
	Integer getWalletMoney(Integer wid);
	Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity;
	Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount;
}
