package com.study.spring.case07.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.spring.case07.tx.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	public void buyBook(Integer wid, Integer bid) {
		bookService.buyOne(wid, bid);
		System.out.println("單筆 buyBook OK!");
	}
	
	public void buyBooks(Integer wid, Integer... bid) {
		bookService.buyMany(wid, bid);
		System.out.println("多筆 buyBooks OK!");
	}
	
}
