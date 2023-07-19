package com.jdbc.springdemo.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jdbc.springdemo.order.entity.ChannelTradeOrderReportEvent;
import com.jdbc.springdemo.order.mapper.ChannelTradeOrderReportEventMapper;
import com.jdbc.springdemo.order.service.ChannelTradeOrderReportEventService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网关系统贸易订单报送事件表 服务实现类
 * </p>
 *
 * @author liu.huan
 * @since 2022-04-18
 */
@Service
public class ChannelTradeOrderReportEventServiceImpl extends ServiceImpl<ChannelTradeOrderReportEventMapper, ChannelTradeOrderReportEvent> implements ChannelTradeOrderReportEventService {

}
