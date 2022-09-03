package com.ndt.pojo;

import com.ndt.pojo.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-03T19:20:52")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, String> firstName;
    public static volatile SingularAttribute<Customers, String> lastName;
    public static volatile SingularAttribute<Customers, String> password;
    public static volatile SingularAttribute<Customers, String> phone;
    public static volatile SingularAttribute<Customers, Integer> id;
    public static volatile SingularAttribute<Customers, String> email;
    public static volatile ListAttribute<Customers, Orders> ordersList;
    public static volatile SingularAttribute<Customers, String> username;

}