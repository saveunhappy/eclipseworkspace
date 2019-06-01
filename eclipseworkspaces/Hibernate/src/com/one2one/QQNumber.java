package com.one2one;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QQNumber {
	private Long id;
	private String number;
	private QQZone zone;
	public String toString() {
		return "QQNumber [id=" + id + ", number=" + number + "]";
	}
	
	
	
}
