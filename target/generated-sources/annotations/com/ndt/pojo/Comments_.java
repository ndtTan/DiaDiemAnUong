package com.ndt.pojo;

import com.ndt.pojo.Foods;
import com.ndt.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-05T16:09:38")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, Date> createdDate;
    public static volatile SingularAttribute<Comments, User> cmtUserId;
    public static volatile SingularAttribute<Comments, Integer> id;
    public static volatile SingularAttribute<Comments, String> content;
    public static volatile SingularAttribute<Comments, Foods> cmtFoodId;

}