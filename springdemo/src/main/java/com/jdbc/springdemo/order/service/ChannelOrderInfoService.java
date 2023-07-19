package com.jdbc.springdemo.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jdbc.springdemo.order.entity.ChannelOrderInfo;
import com.jdbc.springdemo.order.entity.ChannelTradeOrder;
import com.microsoft.azure.storage.StorageException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liu.huan
 * @since 2022-04-14
 */
public interface ChannelOrderInfoService extends IService<ChannelOrderInfo> {

    void dealAndSaveData(ChannelTradeOrder channelTradeOrder);

    void batchNoAndGenerate(String batchNo) throws Exception;

}
