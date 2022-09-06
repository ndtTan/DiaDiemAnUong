package com.ndt.pojo;

import com.ndt.pojo.Foods;
import com.ndt.pojo.Receipt;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T16:09:38")
@StaticMetamodel(ReceiptDetail.class)
public class ReceiptDetail_ { 

    public static volatile SingularAttribute<ReceiptDetail, String> amount;
    public static volatile SingularAttribute<ReceiptDetail, Long> price;
    public static volatile SingularAttribute<ReceiptDetail, Foods> foodId;
    public static volatile SingularAttribute<ReceiptDetail, Integer> id;
    public static volatile SingularAttribute<ReceiptDetail, Receipt> receiptId;

}