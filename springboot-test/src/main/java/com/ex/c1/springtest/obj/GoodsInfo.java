package com.ex.c1.springtest.obj;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 库存商品
 *
 */
@TableName(value= "goods")
public class GoodsInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@TableField("")
	private String goodsUuid; //uuid
	@TableField("")
	private String goodsName; //商品名称
	@TableField("")
	private BigDecimal goodsPrice; //商品单价
	@TableField("")
	private Integer inventory; //商品库存 
	
	public String getGoodsUuid() {
		return goodsUuid;
	}
	public void setGoodsUuid(String goodsUuid) {
		this.goodsUuid = goodsUuid;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	
	
}
