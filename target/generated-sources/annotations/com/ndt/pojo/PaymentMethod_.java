package com.ndt.pojo;

import com.ndt.pojo.Payment;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-03T08:11:07")
@StaticMetamodel(PaymentMethod.class)
public class PaymentMethod_ { 

    public static volatile SingularAttribute<PaymentMethod, String> method;
    public static volatile SingularAttribute<PaymentMethod, Integer> id;
    public static volatile ListAttribute<PaymentMethod, Payment> paymentList;

}