package com.study.spring.case02.pagers;

public class Pager {
	private Integer id;
	private Color color;
	private Size size;
	
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
		return "Pager [id=" + id + ", color=" + color + ", size=" + size + "]";
	}
	
	
}
