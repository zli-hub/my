package com.ex.c1.springtest.api;

import com.ex.c1.springtest.obj.ResponseResult;

abstract class BaseController {
	
	public <T> ResponseResult<T> success(T data) {
		ResponseResult<T> rs = new ResponseResult<>();
		rs.setData(data);
		rs.setStatus(ResponseResult.Status.SUCCESS);
		return rs;
	}
	
	public <T> ResponseResult<T> success() {
		ResponseResult<T> rs = new ResponseResult<>();
		rs.setStatus(ResponseResult.Status.SUCCESS);
		return rs;
	}
}
