package com.study.spring.case03;

public class Cash {
	private int amount; // 金額
	private String currency; // 幣別
	private int twd; // 台幣價值(TWD)
	
	public Cash() {
		
	}
	
	public Cash(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public int getTwd() {
		return twd;
	}

	public void setTwd(int twd) {
		this.twd = twd;
	}

	@Override
	public String toString() {
		return "Cash [amount=" + amount + ", currency=" + currency + ", twd=" + twd + "]";
	}
	
	
}
