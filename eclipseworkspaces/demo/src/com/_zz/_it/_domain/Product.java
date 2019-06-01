package com._zz._it._domain;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 商品对象
 * @author HJT
 *
 */
@Data
public class Product {
	private Long id;
	private String productName;
	private String brand;
	private String supplier;
	private BigDecimal salePrice;
	private BigDecimal costPrice;
	private Double cutoff;
	private Long dir_id;
	
}
