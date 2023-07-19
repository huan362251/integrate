package com.jdbc.springdemo.datademo.base;

import cn.hutool.core.collection.CollectionUtil;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class TestDemo {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        String message = "system_log info is error:SystemLog(id=1539867954209611776, serviceId=null, merchantOrderNumber=abc, threadId=null, merchantNo=123, oriServiceId=null, generateTime=null, details=123, requestId=null, systemSource=null)";
        boolean system_log_info_is_error = message.contains("system_log info is error");
        System.out.println(system_log_info_is_error);

    }

    public static void demo(){
        List<RefundInfoDTO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            RefundInfoDTO refundInfoDTO = new RefundInfoDTO();
            refundInfoDTO.setRefundAmount(new BigDecimal(i));
            refundInfoDTO.setTxnId(Long.valueOf(i));
            list.add(refundInfoDTO);
        }
        for (int i = 0; i < 5; i++) {
            RefundInfoDTO refundInfoDTO = new RefundInfoDTO();
            refundInfoDTO.setRefundAmount(new BigDecimal(i));
            refundInfoDTO.setTxnId(Long.valueOf(i));
            list.add(refundInfoDTO);
        }
        Set<RefundInfoDTO> refundInfoDTOSet = new HashSet<>();
        for (RefundInfoDTO refundInfoDTO : list) {
            System.out.println(refundInfoDTO);
            boolean add = refundInfoDTOSet.add(refundInfoDTO);
            if(!add){
                refundInfoDTOSet.remove(refundInfoDTO);
            }
            System.out.println("flag:"+add);
        }
        System.out.println(refundInfoDTOSet.size());
        refundInfoDTOSet.forEach(refundInfoDTO -> System.out.println(refundInfoDTO));
    }

    public void test1(){
        List<RefundInfoDTO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            RefundInfoDTO refundInfoDTO = new RefundInfoDTO();
            refundInfoDTO.setRefundAmount(new BigDecimal(i));
            refundInfoDTO.setTxnId(Long.valueOf(i));
            list.add(refundInfoDTO);
        }
        for (int i = 0; i < 5; i++) {
            RefundInfoDTO refundInfoDTO = new RefundInfoDTO();
            refundInfoDTO.setRefundAmount(new BigDecimal(i));
            refundInfoDTO.setTxnId(Long.valueOf(i));
            list.add(refundInfoDTO);
        }
        System.out.println("处理前报文：" + list);//15
        System.out.println("处理前报文长度：" + list.size());//15
        TestDemo testDemo = new TestDemo();
        List<RefundListResp> refundListResp = testDemo.repetitionRefundOrder(list);
        List list1 = testDemo.removeRepetitionRefundOrder(list,refundListResp.stream().map(refundInfos->refundInfos.getTxnId()).collect(Collectors.toList()));
        System.out.println(list1);
        System.out.println(list1.size());
    }

    /**
     * 获取重复订单
     * @param refundInfos
     * @return
     */
    public List<RefundListResp> repetitionRefundOrder(List<RefundInfoDTO> refundInfos){
        if(CollectionUtil.isEmpty(refundInfos)){
            return new ArrayList<>();
        }
        //重复订单响应
        List<RefundListResp> refundListRespList = new ArrayList<>();
        //非重复集合
        Set<RefundInfoDTO> refundInfoSet = new HashSet<>();
        for (RefundInfoDTO refundInfo : refundInfos) {
            boolean addFlag = refundInfoSet.add(refundInfo);
            if(!addFlag){
                RefundListResp refundListResp = new RefundListResp();
                refundListResp.setTxnId(refundInfo.getTxnId());
                refundListResp.setRefundAmount(refundInfo.getRefundAmount());
//                refundListResp.setErrorMessage(AcquiringRespEnum.ONLINE_REFUND_BATCH_REPEAT_ERROR.getMessage());
                refundListRespList.add(refundListResp);
            }
        }
        return refundListRespList;
    }

    /**
     * 过滤重复数据
     * @param refundInfos 拒付订单列表
     * @param repetitionIds 重复订单
     * @return
     */
    public List removeRepetitionRefundOrder(List<RefundInfoDTO> refundInfos,List<Long> repetitionIds){
         return refundInfos.stream().filter(refundInfoDTO -> !repetitionIds.contains(refundInfoDTO.getTxnId())).collect(Collectors.toList());
    }

}
