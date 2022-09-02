package com.ndt.pojo;

import com.ndt.pojo.Customers;
import com.ndt.pojo.OrderDetails;
import com.ndt.pojo.Payment;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T05:20:55")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Long> total;
    public static volatile SingularAttribute<Orders, Date> purchaseDate;
    public static volatile ListAttribute<Orders, OrderDetails> orderDetailsList;
    public static volatile SingularAttribute<Orders, Customers> customerId;
    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile ListAttribute<Orders, Payment> paymentList;

}