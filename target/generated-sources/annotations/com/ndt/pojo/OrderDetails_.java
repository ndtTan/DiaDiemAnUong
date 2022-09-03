package com.ndt.pojo;

import com.ndt.pojo.Foods;
import com.ndt.pojo.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-03T19:20:52")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Integer> amount;
    public static volatile SingularAttribute<OrderDetails, Orders> orderId;
    public static volatile SingularAttribute<OrderDetails, Foods> foodId;
    public static volatile SingularAttribute<OrderDetails, Integer> id;
    public static volatile SingularAttribute<OrderDetails, Long> subTotal;

}