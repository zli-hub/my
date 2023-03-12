package com.ex.c1.springtest.service;


import java.util.Map;

import com.ex.c1.springtest.obj.OrderDetail;
import com.ex.c1.springtest.obj.ResponseResult;


public interface UserService {
	ResponseResult<Map<String,?>> selectUserInfo();
	ResponseResult<?> userConsume(OrderDetail order);
	ResponseResult<?> userRefund();
	ResponseResult<Map<String,?>> queryBalanceDetail();
}
