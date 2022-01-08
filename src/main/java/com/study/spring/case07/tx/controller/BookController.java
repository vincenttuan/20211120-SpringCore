package com.study.spring.case07.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.spring.case07.tx.exception.InsufficientAmount;
import com.study.spring.case07.tx.exception.InsufficientQuantity;
import com.study.spring.case07.tx.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	public void buyBook(Integer wid, Integer bid) {
		try {
			bookService.buyOne(wid, bid);
			System.out.println("單筆 buyBook OK!");
		} catch (InsufficientAmount e) {
			System.out.println(e);
		} catch (InsufficientQuantity e) {
			System.out.println(e);
		}
	}
	
	public void buyBooks(Integer wid, Integer... bid) {
		try {
			bookService.buyMany(wid, bid);
			System.out.println("多筆 buyBooks OK!");
		} catch (InsufficientAmount e) {
			System.out.println(e);
		} catch (InsufficientQuantity e) {
			System.out.println(e);
		}
		
	}
	
}
