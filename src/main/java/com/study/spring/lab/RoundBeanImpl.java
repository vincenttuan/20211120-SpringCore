package com.study.spring.lab;

public class RoundBeanImpl implements RoundBean {
	private double r;
	@Override
	public double getRoundArea() {
		return Math.pow(r, 2) * Math.PI;
	}

	@Override
	public void setRadius(double r) {
		this.r = r;
	}

	@Override
	public double getRadius() {
		return r;
	}
	
}
