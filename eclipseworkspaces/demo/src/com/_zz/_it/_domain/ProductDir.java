package com._zz._it._domain;

import lombok.Data;
/**
 * 商品分类对象
 * @author HJT
 *
 */
@Data
public class ProductDir {
	private Long id;
	private String dirName;
	private Long parent_id;
}
