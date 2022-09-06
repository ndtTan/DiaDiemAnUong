package com.ndt.pojo;

import com.ndt.pojo.Category;
import com.ndt.pojo.Comments;
import com.ndt.pojo.ReceiptDetail;
import com.ndt.pojo.Stores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T16:09:38")
@StaticMetamodel(Foods.class)
public class Foods_ { 

    public static volatile ListAttribute<Foods, Comments> commentsList;
    public static volatile SingularAttribute<Foods, Long> price;
    public static volatile SingularAttribute<Foods, String> name;
    public static volatile SingularAttribute<Foods, String> imgFood;
    public static volatile SingularAttribute<Foods, Integer> id;
    public static volatile ListAttribute<Foods, ReceiptDetail> receiptDetailList;
    public static volatile SingularAttribute<Foods, Stores> storeId;
    public static volatile SingularAttribute<Foods, Date> sellTime;
    public static volatile SingularAttribute<Foods, Category> categoryId;

}