package com.one2one;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QQZone {
	private Long id;
	private String title;
	private QQNumber number;
	public String toString() {
		return "QQZone [id=" + id + ", title=" + title + "]";
	}
	
}
