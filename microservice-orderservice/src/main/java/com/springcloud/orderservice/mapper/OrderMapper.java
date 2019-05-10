package com.springcloud.orderservice.mapper;

import com.springcloud.orderservice.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from tb_order where userid=#{userid}")
    List<Order> getOrder(Integer userid);

}
