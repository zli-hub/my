package com.ex.c1.springtest.obj;

/**
 * 交易商品详情
 */
public class OrderDetail {
	// 商品id
	private String itemId; 
	//商品名称
	private String itemName; 
	//商品数量
	private Integer itemNum; 
	//商品单价
	private Double itemPrice; 
	//商品总价
	private Double sumPrice; 
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemNum() {
		return itemNum;
	}
	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}
	
	
}
