package com.auto_hand_join;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Setter;

@Setter
public class CollectionBean {
	private Set<String> set;
	private List<String> list;
	private String[] arr;
	private Map<String,String> map;
	private Properties prop;
	@Override
	public String toString() {
		return "ConnectionBean [set=" + set + ", \nlist=" + list + ",\n arr=" + Arrays.toString(arr) + ",\n map=" + map
				+ ", \nprop=" + prop + "]";
	}
	
}
