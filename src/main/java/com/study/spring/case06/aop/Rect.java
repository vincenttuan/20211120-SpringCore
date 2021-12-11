package com.study.spring.case06.aop;

import org.springframework.stereotype.Component;

@Component
public class Rect implements Area {

	@Override
	public Integer getValue(Integer h, Integer w) {
		if(h < 0 || w < 0 ) {
			throw new RuntimeException("參數錯誤");
		}
		return h * w;
	}

}
