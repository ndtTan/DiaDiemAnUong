package com.ndt.pojo;

import com.ndt.pojo.Foods;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T16:09:38")
@StaticMetamodel(Stores.class)
public class Stores_ { 

    public static volatile SingularAttribute<Stores, String> address;
    public static volatile ListAttribute<Stores, Foods> foodsList;
    public static volatile SingularAttribute<Stores, String> name;
    public static volatile SingularAttribute<Stores, Long> shipFee;
    public static volatile SingularAttribute<Stores, Integer> id;

}