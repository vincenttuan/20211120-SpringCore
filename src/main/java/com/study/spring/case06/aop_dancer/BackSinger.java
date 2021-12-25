package com.study.spring.case06.aop_dancer;

public class BackSinger implements Singer {

	@Override
	public void sing() {
		System.out.println("幕後歌者: 啦啦啦~~~");
	}
	
}
