package com.ex.c1.springtest.service;

import java.util.Map;
import javax.json.Json;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ex.c1.springtest.mapper.BalanceDetailMapper;
import com.ex.c1.springtest.mapper.GoodsMapper;
import com.ex.c1.springtest.mapper.UserMapper;
import com.ex.c1.springtest.obj.OrderDetail;
import com.ex.c1.springtest.obj.ResponseResult;
import com.ex.c1.springtest.obj.UserInfo;
import com.ex.c1.springtest.obj.BalanceDetail;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private BalanceDetailMapper bdMapper;
	
	//手动事务支持
	@Autowired
	private DataSourceTransactionManager dstm;
	
	@Autowired
	private TransactionDefinition td;
	
	public ResponseResult<Map<String,?>> selectUserInfo() {
		//用户uuid可通过内部安全框架或者redis等获取，作为这个方法的参数传递进来也可以
		String userUuid = "";  
		QueryWrapper<UserInfo> qw = new QueryWrapper<>();
		qw.eq("user_uuid", userUuid);
		UserInfo userInfo = null;
		try {
			userInfo = userMapper.selectOne(qw);
		} catch (Exception e) {

		}
		if(userInfo == null) {
			//插入一个余额为0的新用户
		}
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("userInfo",userInfo);
		return new ResponseResult<>(resultMap,ResponseResult.Status.SUCCESS,"");
	}

	@Override
	public ResponseResult<?> userConsume(OrderDetail order) {
		ResponseResult<Void> rr = new ResponseResult<>(null,ResponseResult.Status.FAILED,"");
		//创建事务
		TransactionStatus consumeTS = dstm.getTransaction(td);
		try {
			//用户uuid可通过内部安全框架或者redis等获取，作为这个方法的参数传递进来也可以
			String userUuid = "";  
			QueryWrapper<UserInfo> qw = new QueryWrapper<>();
			qw.eq("user_uuid", userUuid);
			UserInfo userInfo = userMapper.selectOne(qw);
			//如果商品价格不大于用户余额
			BigDecimal goodsSumPrice = new BigDecimal(order.getSumPrice()).setScale(2);
			//这里可以从数据库查询商品价格 x 数量得出总价 和前端传过来的数值做对比，如果不相等可以返回错误信息
			if(goodsSumPrice.compareTo(userInfo.getBalance()) <= 0) {
				//商品之类的操作。。。
				//用户余额减去消费金额，取两位小数
				BigDecimal currBalance = userInfo.getBalance().subtract(goodsSumPrice).setScale(2, RoundingMode.HALF_UP);
				BalanceDetail bd = new BalanceDetail();
				bd.setUserUuid(userUuid);
				bd.setOutgoing(goodsSumPrice);
				bd.setIncoming(new BigDecimal(0));
				bd.setUserBalance(currBalance);
				//假设一个消费类型
				bd.setChangeType("00");
				//detail详细描述消费项目
				bd.setDetail(Json.createObjectBuilder().build().toString());
				//插入用户余额变动明细表
				bdMapper.insertBalanceDetail(bd);
				userInfo.setBalance(currBalance);
				//修改用户信息表里余额
				userMapper.update(userInfo, qw);
				rr.setStatus(ResponseResult.Status.SUCCESS);
			}
			//提交事务
			dstm.commit(consumeTS);
			return rr;
		}catch(Exception e) {
			//记录日志
			//事务回滚
			dstm.rollback(consumeTS);
		}
		return rr;
	}

	@Override
	public ResponseResult<?> userRefund() {
		
		return null;
	}

	@Override
	public ResponseResult<Map<String,?>> queryBalanceDetail() {
		//用户uuid可通过内部安全框架或者redis等获取，作为这个方法的参数传递进来也可以
		String userUuid = "";
		QueryWrapper<BalanceDetail> qw = new QueryWrapper<>();
		qw.eq("user_uuid", userUuid);
		//结果较多可考虑使用分页插件
		List<BalanceDetail> detailList =  bdMapper.selectList(qw);
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("detailList",detailList);
		return new ResponseResult<>(resultMap,ResponseResult.Status.SUCCESS,"");
	}

}
