package com.ex.c1.springtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ex.c1.springtest.obj.BalanceDetail;

public interface BalanceDetailMapper extends BaseMapper<BalanceDetail>{
	void insertBalanceDetail(BalanceDetail bd);
}
