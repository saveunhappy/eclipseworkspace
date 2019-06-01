package com.extend;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ClothProduct extends Product{
	private String size;

	@Override
	public String toString() {
		return "ClothProduct [size=" + size + "]";
	}
	
}
