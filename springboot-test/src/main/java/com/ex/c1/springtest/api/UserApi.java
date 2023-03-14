package com.ex.c1.springtest.api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex.c1.springtest.obj.OrderDetail;
import com.ex.c1.springtest.obj.ResponseResult;
import com.ex.c1.springtest.service.UserService;

/**
 * 用户相关api
 * 因为用户uuid是通过内部框架或者redis等查询的，所以这里只写了大概的流程，
 * 没有测试，如果有后续需要的话，我可以修改下让api可以跑通
 */
@RestController
public class UserApi extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(UserApi.class);
	@Autowired
	private UserService userService;
	/*
	 * 查询用户余额
	 */
	@PostMapping(value = "/userInfo")
	public ResponseResult<Map<String,?>> userInfo() {
		return userService.selectUserInfo();
	}
	/*
	 * 用户消费api
	 */
	@PostMapping(value = "/userConsume",consumes = "application/json")
	public ResponseResult<?> userConsume(@RequestBody OrderDetail order) {
		return userService.userConsume(order);
	}
	
	/*
	 * 用户退费api
	 * 这个api和消费api类似
	 */
	@PostMapping(value = "/userRefund")
	public ResponseResult<?> userRefund() {
		return userService.userRefund();
	}
	
	/*
	 * 查询用户钱包金额变动明细的接口
	 */
	@PostMapping(value = "/balanceDetail")
	public ResponseResult<Map<String,?>> balanceDetail() {
		return userService.queryBalanceDetail();
	}
}
