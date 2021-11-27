package com.study.spring.case02.pagers;

public class Pager3 {
	private Integer id;
	private Color color;
	private Size size;
	
	public Pager3() {
		
	}

	public Pager3(Color redColor, Size size) {
		this.color = redColor;
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Pager3 [id=" + id + ", color=" + color + ", size=" + size + "]";
	}
	
	
	
}
