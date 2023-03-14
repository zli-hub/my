package com.ex.c1.springtest.obj;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.json.JsonObject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 余额变动详情Obj
 *
 */
@TableName("user_balance_detail")
public class BalanceDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户uuid
	@TableField("user_uuid")
	private String userUuid;
	//收入
	@TableField("incoming")
	private BigDecimal incoming;
	//支出
	@TableField("outgoing")
	private BigDecimal outgoing;
	//余额
	@TableField("user_balance")
	private BigDecimal userBalance;
	
	//创建时间
	@TableField("create_time")
	private Date createTime;
	//变动原因
	@TableField("change_type")
	private String changeType;
	//变动明细
	@TableField("detail")
	private String detail;
	
	public String getUserUuid() {
		return userUuid;
	}
	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}
	public BigDecimal getIncoming() {
		return incoming;
	}
	public void setIncoming(BigDecimal incoming) {
		this.incoming = incoming;
	}
	public BigDecimal getOutgoing() {
		return outgoing;
	}
	public void setOutgoing(BigDecimal outgoing) {
		this.outgoing = outgoing;
	}
	public BigDecimal getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(BigDecimal userBalance) {
		this.userBalance = userBalance;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
