package com.study.spring.case02.pagers;

public class Pager2 {
	private Integer id;
	private Color redColor;
	private Size b5Size;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Color getRedColor() {
		return redColor;
	}
	public void setRedColor(Color redColor) {
		this.redColor = redColor;
	}
	public Size getB5Size() {
		return b5Size;
	}
	public void setB5Size(Size b5Size) {
		this.b5Size = b5Size;
	}
	@Override
	public String toString() {
		return "Pager2 [id=" + id + ", redColor=" + redColor + ", b5Size=" + b5Size + "]";
	}
		
	
}
