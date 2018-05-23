package EntityClasses;

import EntityClasses.FriendTBPK;
import EntityClasses.UserTB;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T23:41:54")
@StaticMetamodel(FriendTB.class)
public class FriendTB_ { 

    public static volatile SingularAttribute<FriendTB, UserTB> userTB;
    public static volatile SingularAttribute<FriendTB, UserTB> userTB1;
    public static volatile SingularAttribute<FriendTB, FriendTBPK> friendTBPK;
    public static volatile SingularAttribute<FriendTB, Long> priorityOrder;

}