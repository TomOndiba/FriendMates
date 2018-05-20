package EntityClasses;

import EntityClasses.CommentsTB;
import EntityClasses.PostTB;
import EntityClasses.UserTB;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-20T01:39:26")
@StaticMetamodel(CommentsTB.class)
public class CommentsTB_ { 

    public static volatile SingularAttribute<CommentsTB, CommentsTB> parentCommentId;
    public static volatile SingularAttribute<CommentsTB, String> comment;
    public static volatile SingularAttribute<CommentsTB, Integer> id;
    public static volatile SingularAttribute<CommentsTB, PostTB> postId;
    public static volatile SingularAttribute<CommentsTB, UserTB> userId;
    public static volatile CollectionAttribute<CommentsTB, CommentsTB> commentsTBCollection;

}