package EntityClasses;

import EntityClasses.CommentsTB;
import EntityClasses.LikeTB;
import EntityClasses.UserTB;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-16T10:50:21")
@StaticMetamodel(PostTB.class)
public class PostTB_ { 

    public static volatile SingularAttribute<PostTB, Boolean> isImage;
    public static volatile SingularAttribute<PostTB, Date> createdDate;
    public static volatile SingularAttribute<PostTB, String> videoUrl;
    public static volatile SingularAttribute<PostTB, String> heading;
    public static volatile SingularAttribute<PostTB, String> imageUrl;
    public static volatile CollectionAttribute<PostTB, LikeTB> likeTBCollection;
    public static volatile SingularAttribute<PostTB, String> description;
    public static volatile SingularAttribute<PostTB, Boolean> isVideo;
    public static volatile SingularAttribute<PostTB, String> location;
    public static volatile SingularAttribute<PostTB, Integer> id;
    public static volatile SingularAttribute<PostTB, UserTB> userId;
    public static volatile CollectionAttribute<PostTB, CommentsTB> commentsTBCollection;

}