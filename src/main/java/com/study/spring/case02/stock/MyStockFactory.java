package com.study.spring.case02.stock;

import org.springframework.beans.factory.FactoryBean;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MyStockFactory implements FactoryBean<MyStock> {

	@Override
	public MyStock getObject() throws Exception {
		Stock stock = YahooFinance.get("INTC");
		Double price = stock.getQuote().getPrice().doubleValue();
		MyStock myStock = new MyStock();
		myStock.setSymbol("0050.TW");
		myStock.setPrice(price);
		return myStock;
	}

	@Override
	public Class<?> getObjectType() {
		return MyStock.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
