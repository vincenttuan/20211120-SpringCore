package com.study.spring.case06.aop_dancer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 使用 Java 配置替代 aop-dancer.xml
@Configuration // 宣告 AOPConfig 是一個配置檔程式
@EnableAspectJAutoProxy // 對應 <context:component-scan base-package="com.study.spring.case06.aop_dancer" />
@ComponentScan // 對應 <aop:aspectj-autoproxy />
public class AOPConfig {
	
	@Bean(name = "dancer")
	public Performance dancer() {
		return new Dancer();
	}
	
	//@Bean(name = "audience")
	@Bean
	public Audience audience() {
		return new Audience();
	}
	
	@Bean
	public Introductor getIntroductor() {
		return new Introductor();
	}
	
}
