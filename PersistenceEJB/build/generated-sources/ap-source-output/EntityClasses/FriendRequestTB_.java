package EntityClasses;

import EntityClasses.UserTB;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T23:41:54")
@StaticMetamodel(FriendRequestTB.class)
public class FriendRequestTB_ { 

    public static volatile SingularAttribute<FriendRequestTB, UserTB> fromUserId;
    public static volatile SingularAttribute<FriendRequestTB, Integer> id;
    public static volatile SingularAttribute<FriendRequestTB, UserTB> toUserId;

}