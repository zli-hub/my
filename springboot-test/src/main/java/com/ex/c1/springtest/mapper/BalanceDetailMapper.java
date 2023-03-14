package com.ex.c1.springtest.mapper;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ex.c1.springtest.obj.BalanceDetail;

public interface BalanceDetailMapper extends BaseMapper<BalanceDetail>{
	void insertBalanceDetail(@Param("bd")BalanceDetail bd);
}
