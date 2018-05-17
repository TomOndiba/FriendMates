package EntityClasses;

import EntityClasses.PostTB;
import EntityClasses.UserTB;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T11:33:39")
@StaticMetamodel(LikeTB.class)
public class LikeTB_ { 

    public static volatile SingularAttribute<LikeTB, Date> createdDate;
    public static volatile SingularAttribute<LikeTB, Integer> id;
    public static volatile SingularAttribute<LikeTB, PostTB> postId;
    public static volatile SingularAttribute<LikeTB, UserTB> userId;
    public static volatile SingularAttribute<LikeTB, Boolean> status;

}