package EntityClasses;

import EntityClasses.CommentsTB;
import EntityClasses.CountryTB;
import EntityClasses.FriendRequestTB;
import EntityClasses.GroupChatTB;
import EntityClasses.GroupTB;
import EntityClasses.LikeTB;
import EntityClasses.MessageTB;
import EntityClasses.PostTB;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T11:33:39")
@StaticMetamodel(UserTB.class)
public class UserTB_ { 

    public static volatile SingularAttribute<UserTB, String> lName;
    public static volatile CollectionAttribute<UserTB, FriendRequestTB> friendRequestTBCollection;
    public static volatile CollectionAttribute<UserTB, GroupTB> groupTBCollection;
    public static volatile SingularAttribute<UserTB, String> gender;
    public static volatile CollectionAttribute<UserTB, MessageTB> messageTBCollection1;
    public static volatile SingularAttribute<UserTB, String> emailId;
    public static volatile SingularAttribute<UserTB, BigInteger> mobileNo;
    public static volatile SingularAttribute<UserTB, CountryTB> countryId;
    public static volatile CollectionAttribute<UserTB, PostTB> postTBCollection;
    public static volatile SingularAttribute<UserTB, String> profilePicture;
    public static volatile SingularAttribute<UserTB, String> password;
    public static volatile SingularAttribute<UserTB, String> fName;
    public static volatile SingularAttribute<UserTB, Date> createdDate;
    public static volatile SingularAttribute<UserTB, Date> dob;
    public static volatile CollectionAttribute<UserTB, LikeTB> likeTBCollection;
    public static volatile CollectionAttribute<UserTB, FriendRequestTB> friendRequestTBCollection1;
    public static volatile CollectionAttribute<UserTB, GroupChatTB> groupChatTBCollection;
    public static volatile CollectionAttribute<UserTB, GroupChatTB> groupChatTBCollection1;
    public static volatile SingularAttribute<UserTB, Integer> id;
    public static volatile CollectionAttribute<UserTB, MessageTB> messageTBCollection;
    public static volatile CollectionAttribute<UserTB, CommentsTB> commentsTBCollection;

}