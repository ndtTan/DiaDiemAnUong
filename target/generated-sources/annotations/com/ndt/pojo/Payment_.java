package com.ndt.pojo;

import com.ndt.pojo.Orders;
import com.ndt.pojo.PaymentMethod;
import com.ndt.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-03T08:11:07")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, Long> amount;
    public static volatile SingularAttribute<Payment, PaymentMethod> paymentMethodId;
    public static volatile SingularAttribute<Payment, Orders> pmOrderId;
    public static volatile SingularAttribute<Payment, Integer> id;
    public static volatile SingularAttribute<Payment, User> receiveBy;

}