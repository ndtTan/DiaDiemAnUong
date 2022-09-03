package com.ndt.pojo;

import com.ndt.pojo.Category;
import com.ndt.pojo.ConditionDetails;
import com.ndt.pojo.Stores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-03T19:20:52")
@StaticMetamodel(Foods.class)
public class Foods_ { 

    public static volatile SingularAttribute<Foods, ConditionDetails> conditionDetailsId;
    public static volatile SingularAttribute<Foods, Long> price;
    public static volatile SingularAttribute<Foods, Stores> storesId;
    public static volatile SingularAttribute<Foods, String> name;
    public static volatile SingularAttribute<Foods, String> imgFood;
    public static volatile SingularAttribute<Foods, Integer> id;
    public static volatile SingularAttribute<Foods, Date> sellTime;
    public static volatile SingularAttribute<Foods, Category> categoryId;

}