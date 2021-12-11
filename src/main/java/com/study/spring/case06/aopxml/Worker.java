package com.study.spring.case06.aopxml;

import org.springframework.stereotype.Component;

@Component
public class Worker {
	public void job() {
		System.out.println("工作");
	}
}
