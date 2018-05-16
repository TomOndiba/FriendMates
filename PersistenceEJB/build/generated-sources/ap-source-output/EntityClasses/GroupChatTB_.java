package EntityClasses;

import EntityClasses.MessageTB;
import EntityClasses.UserTB;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-16T10:50:21")
@StaticMetamodel(GroupChatTB.class)
public class GroupChatTB_ { 

    public static volatile SingularAttribute<GroupChatTB, Date> createdDate;
    public static volatile SingularAttribute<GroupChatTB, UserTB> createdUserId;
    public static volatile SingularAttribute<GroupChatTB, String> name;
    public static volatile SingularAttribute<GroupChatTB, Integer> id;
    public static volatile CollectionAttribute<GroupChatTB, UserTB> userTBCollection;
    public static volatile CollectionAttribute<GroupChatTB, MessageTB> messageTBCollection;

}