package com.study.spring.case03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.study.spring.case03.Cash;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ExchangeHandler implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof Cash) {
			Cash cash = (Cash)bean;
			System.out.println("ExchangeHandler begin: " + cash);
			// 換匯
			String symbol = cash.getCurrency().concat("TWD=x"); // Ex: USDTWD=x
			try {
				Stock stock = YahooFinance.get(symbol); // 取得換匯標的物件
				double price = stock.getQuote().getPrice().doubleValue(); // 取得價格
				int twd = (int)(cash.getAmount() * price); // 匯率計算
				cash.setTwd(twd); // 儲存匯率計算台幣後的結果
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("ExchangeHandler end: " + cash);
			return cash;
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

}
