package com.jdbc.springdemo.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jdbc.springdemo.order.entity.ChannelOrderInfo;
import com.jdbc.springdemo.order.entity.ChannelTradeOrder;
import com.jdbc.springdemo.order.mapper.ChannelOrderInfoMapper;
import com.jdbc.springdemo.order.service.ChannelOrderInfoService;
import com.jdbc.springdemo.order.util.AzureStorageUtils;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlobDirectory;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liu.huan
 * @since 2022-04-14
 */

@Slf4j
@Service
public class ChannelOrderInfoServiceImpl extends ServiceImpl<ChannelOrderInfoMapper, ChannelOrderInfo> implements ChannelOrderInfoService {

    public static final List<String> specifyField = new ArrayList<>();

    static {
        specifyField.add("orderId");
        specifyField.add("tradeDate");
        specifyField.add("oppUser");
        specifyField.add("oppCode");
        specifyField.add("tranCcy");
        specifyField.add("tranAmount");
        specifyField.add("countryCode");
        specifyField.add("custnm");
        specifyField.add("payAccNum");
        specifyField.add("traSurplus");
        specifyField.add("tradeName");
        specifyField.add("tradeNum");
        specifyField.add("unitPrice");
        specifyField.add("logTrackNum");
        specifyField.add("carrier");
        specifyField.add("tradeId");
        specifyField.add("batchNo");
        specifyField.add("convRate");
        specifyField.add("rmk1");
        specifyField.add("rmk2");
        specifyField.add("rmk3");
    }

    @Override
    public void dealAndSaveData(ChannelTradeOrder channelTradeOrder) {
        convertOrderInfoData(channelTradeOrder);

    }

    /**
     * 转换订单数据
     */
    public void convertOrderInfoData(ChannelTradeOrder channelTradeOrder){
        ChannelOrderInfo channelOrderInfo = new ChannelOrderInfo();
        channelOrderInfo.setId(channelTradeOrder.getId());
        channelOrderInfo.setOrderId(channelTradeOrder.getOutOrderNo());
        channelOrderInfo.setTradeDate(channelTradeOrder.getTradeTime());
        channelOrderInfo.setOppUser("account.1");
        channelOrderInfo.setOppCode("account");
        channelOrderInfo.setTranCcy("CNY");
        channelOrderInfo.setTranAmount(new BigDecimal(3023));
        channelOrderInfo.setCountryCode("12");
        channelOrderInfo.setCustnm("abc");
        channelOrderInfo.setPayAccNum("32");
        channelOrderInfo.setTraSurplus("bac");
        channelOrderInfo.setTradeName("he");
        channelOrderInfo.setTradeNum("5");
        channelOrderInfo.setUnitPrice("453");
        channelOrderInfo.setLogTrackNum("3");
        channelOrderInfo.setCarrier("abc");
        channelOrderInfo.setTradeId("bne");
        channelOrderInfo.setBatchNo("123");
        channelOrderInfo.setConvRate(new BigDecimal(3.3));
        this.baseMapper.insert(channelOrderInfo);
    }

    @Override
    public void batchNoAndGenerate(String batchNo) throws Exception {
        CloudBlobContainer cloudBlobContainer = AzureStorageUtils.getCloudBlobContainer();
        CloudBlobDirectory reference = cloudBlobContainer.getDirectoryReference("20211204");
        CloudBlockBlob blob = reference.getBlockBlobReference("XFTORDER101-20211204-0001-001.del");
        List<ChannelOrderInfo> channelOrderInfos = this.baseMapper
                .selectList(new LambdaQueryWrapper<ChannelOrderInfo>().eq(ChannelOrderInfo::getBatchNo, batchNo));
        String value = convertData(channelOrderInfos);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(value);
        blob.uploadText(toUtf8String(stringBuffer.toString()));
    }

    /**
     * 表数据转换
     *
     * @param channelOrderInfos
     * @return
     * @throws Exception
     */
    public String convertData(List<ChannelOrderInfo> channelOrderInfos) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        for (ChannelOrderInfo channelOrderInfo : channelOrderInfos) {
            List<Object> list = dataToLine(channelOrderInfo, specifyField);
            String join = StringUtils.join(list, "\t") + "\r\n";
            stringBuffer.append(toUtf8String(join));
        }
        return stringBuffer.toString();
    }

    /**
     * 转换UTF-8
     *
     * @param string
     * @return
     */
    public static String toUtf8String(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 0 && c <= 255) {
                stringBuffer.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) k += 256;
                    stringBuffer.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 根据字段组装行数据
     *
     * @param t
     * @param specifyField 指定字段
     * @param <T>
     * @return
     */
    private <T> List<Object> dataToLine(T t, List<String> specifyField) throws Exception {
        List<Object> list = new ArrayList<>();
        Class<?> aClass = t.getClass();
        for (String fieldCode : specifyField) {
            Field field = aClass.getDeclaredField(fieldCode);
            field.setAccessible(true);
            String name = field.getName();
            log.info("field name:{}", name);
            if (name.equals("tradeDate")) {
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
                LocalDate localDate = (LocalDate) field.get(t);
                String localDateStr = localDate.format(fmt);
                log.info("field value:{}", list.add(localDateStr));
            } else {
                log.info("field value:{}", list.add(field.get(t)));
            }
        }
        return list;
    }
}
