package com.study.spring.case07.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.spring.case07.tx.exception.InsufficientAmount;
import com.study.spring.case07.tx.exception.InsufficientQuantity;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer getPrice(Integer bid) {
		String sql = "select price from book where bid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, bid);
	}

	@Override
	public Integer getStockAmount(Integer bid) {
		String sql = "select amount from stock where bid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, bid);
	}
	
	@Override
	public Integer getWalletMoney(Integer wid) {
		String sql = "select money from wallet where wid=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, wid);
	}
	
	@Override
	public Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity {
		// 先確認書最新庫存量
		Integer new_amount = getStockAmount(bid);
		if(new_amount <= 0) {
			throw new InsufficientQuantity("此書目前沒有庫存, 目前數量:" + new_amount);
		} else if(new_amount < amount) {
			throw new InsufficientQuantity("庫存不足, 目前數量:" + new_amount);
		}
		// 修改庫存
		String sql = "update stock set amount = amount - ? where bid=?";
		return jdbcTemplate.update(sql, amount, bid);
	}
	
	@Override
	public Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount {
		// 先確認錢包裡的錢
		Integer new_money = getWalletMoney(wid);
		if(new_money <= 0) {
			throw new InsufficientAmount("錢包沒錢了, 目前餘額:" + new_money);
		} else if(new_money < money) {
			throw new InsufficientAmount("錢包餘額不足, 目前餘額:" + new_money);
		}
		// 修改金額
		String sql = "update wallet set money = money - ? where wid=?";
		return jdbcTemplate.update(sql, money, wid);
	}

	
	
}
