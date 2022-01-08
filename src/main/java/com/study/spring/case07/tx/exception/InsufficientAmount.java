package com.study.spring.case07.tx.exception;

// 錢包 Wallet 餘額不足
public class InsufficientAmount extends Throwable {

	public InsufficientAmount() {
		super("Wallet 餘額不足");
	}
	
	public InsufficientAmount(String message) {
		super(message);
	}
	
}
