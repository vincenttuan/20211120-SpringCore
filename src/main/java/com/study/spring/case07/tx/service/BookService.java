package com.study.spring.case07.tx.service;

public interface BookService {
	void buyOne(Integer wid, Integer bid);
	void buyMany(Integer wid, Integer... bids);
}
