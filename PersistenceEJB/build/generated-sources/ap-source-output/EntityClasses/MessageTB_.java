package EntityClasses;

import EntityClasses.GroupChatTB;
import EntityClasses.UserTB;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T23:41:54")
@StaticMetamodel(MessageTB.class)
public class MessageTB_ { 

    public static volatile SingularAttribute<MessageTB, String> messageText;
    public static volatile SingularAttribute<MessageTB, Date> createdDate;
    public static volatile SingularAttribute<MessageTB, Boolean> isFile;
    public static volatile SingularAttribute<MessageTB, UserTB> fromUserId;
    public static volatile SingularAttribute<MessageTB, GroupChatTB> groupId;
    public static volatile SingularAttribute<MessageTB, String> fileUrl;
    public static volatile SingularAttribute<MessageTB, Integer> id;
    public static volatile SingularAttribute<MessageTB, Date> time;
    public static volatile SingularAttribute<MessageTB, UserTB> toUserId;

}