package com.ndt.pojo;

import com.ndt.pojo.Foods;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T16:09:38")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile ListAttribute<Category, Foods> foodsList;
    public static volatile SingularAttribute<Category, Integer> id;
    public static volatile SingularAttribute<Category, String> categoryName;

}