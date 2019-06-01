package com.extend;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BookProduct extends Product{
	private String isbn;
	private String author;
	@Override
	public String toString() {
		return "BookProduct [isbn=" + isbn + ", author=" + author + "]";
	}
	
	
}
