package com.study.spring.case07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.case07.tx.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	public void buyOne(Integer wid, Integer bid) {
		// 消耗一本庫存
		bookDao.updateStock(bid, 1);
		// 取得書籍價格
		Integer price = bookDao.getPrice(bid);
		// 減去錢包裡的金額
		bookDao.updateWallet(wid, price);
	}

	@Override
	public void buyMany(Integer wid, Integer... bids) {
		for(Integer bid : bids) {
			buyOne(wid, bid);
		}
	}
	
	
}
