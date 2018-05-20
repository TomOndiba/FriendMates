package EntityClasses;

import EntityClasses.UserTB;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-20T01:39:26")
@StaticMetamodel(FriendRequestTB.class)
public class FriendRequestTB_ { 

    public static volatile SingularAttribute<FriendRequestTB, Date> createdDate;
    public static volatile SingularAttribute<FriendRequestTB, UserTB> fromUserId;
    public static volatile SingularAttribute<FriendRequestTB, Integer> id;
    public static volatile SingularAttribute<FriendRequestTB, UserTB> toUserId;
    public static volatile SingularAttribute<FriendRequestTB, Integer> status;

}