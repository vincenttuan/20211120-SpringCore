package com.study.spring.case07.tx.exception;

// 庫存數量不足
public class InsufficientQuantity extends Throwable {

	public InsufficientQuantity() {
		super("Book 庫存數量不足");
	}
	
	public InsufficientQuantity(String message) {
		super(message);
	}
	
}
