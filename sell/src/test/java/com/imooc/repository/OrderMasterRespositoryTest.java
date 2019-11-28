package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRespositoryTest {
    @Autowired
    private OrderMasterRespository respository;
    private final  String OPENID="110110";
    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("12345678909");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster result = respository.save(orderMaster);
        Assert.assertNotEquals(null,result);
    }
    @Test
    public void findByBuyerOpenid(){
        PageRequest request=PageRequest.of(0,2);
        Page<OrderMaster> result = respository.findByBuyerOpenid(OPENID, request);
        System.out.println(result.getTotalElements());
        System.out.println(result.getTotalPages());
        Assert.assertNotEquals(0,result.getTotalElements());

    }

}