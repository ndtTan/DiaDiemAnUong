package com.ndt.pojo;

import com.ndt.pojo.ReceiptDetail;
import com.ndt.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T16:09:38")
@StaticMetamodel(Receipt.class)
public class Receipt_ { 

    public static volatile SingularAttribute<Receipt, Long> total;
    public static volatile SingularAttribute<Receipt, Date> createdDate;
    public static volatile SingularAttribute<Receipt, User> odUserId;
    public static volatile SingularAttribute<Receipt, Integer> id;
    public static volatile ListAttribute<Receipt, ReceiptDetail> receiptDetailList;

}