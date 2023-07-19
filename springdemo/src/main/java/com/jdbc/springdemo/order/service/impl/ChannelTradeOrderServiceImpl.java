package com.jdbc.springdemo.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jdbc.springdemo.order.entity.ChannelTradeOrder;
import com.jdbc.springdemo.order.mapper.ChannelTradeOrderMapper;
import com.jdbc.springdemo.order.service.ChannelTradeOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网关系统贸易订单表 服务实现类
 * </p>
 *
 * @author liu.huan
 * @since 2022-04-18
 */
@Service
public class ChannelTradeOrderServiceImpl extends ServiceImpl<ChannelTradeOrderMapper, ChannelTradeOrder> implements ChannelTradeOrderService {

}
