/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import EntityClasses.CommentsTB;
import EntityClasses.LikeTB;
import EntityClasses.PostTB;
import EntityClasses.UserTB;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class CommentsBean implements CommentsBeanLocal {

    @PersistenceContext(unitName = "PersistenceEJBPU")
    EntityManager em;
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void insertComment(Integer postId, Integer userId, Integer parentCommentId, String comment) {
        
        CommentsTB cmt=new CommentsTB();
        UserTB user=(UserTB)em.find(UserTB.class, userId);
        PostTB post=(PostTB)em.find(PostTB.class,postId);
        CommentsTB parentComment=(CommentsTB)em.find(CommentsTB.class, parentCommentId);
        
        Collection<CommentsTB> userCommentCollection=user.getCommentsTBCollection();
        Collection<CommentsTB> postCommentCollection=post.getCommentsTBCollection();
        
        postCommentCollection.add(cmt);
        userCommentCollection.add(cmt);
        
        cmt.setPostId(post);
        cmt.setUserId(user);
        cmt.setParentCommentId(parentComment);
        cmt.setComment(comment);
        em.persist(cmt);
        em.merge(post);
        em.merge(user);
        
    }

    @Override
    public void updateComment(Integer id, Integer postId, Integer userId, Integer parentCommentId, String comment) {
        UserTB user = (UserTB) em.find(UserTB.class, userId);
        PostTB post = (PostTB) em.find(PostTB.class, postId);
        CommentsTB parentComment=(CommentsTB)em.find(CommentsTB.class, parentCommentId);
        
        Collection<CommentsTB> userCommentCollection=user.getCommentsTBCollection();
        Collection<CommentsTB> postCommentCollection=post.getCommentsTBCollection();

        CommentsTB cmt=(CommentsTB)em.find(CommentsTB.class, id);
        
        postCommentCollection.add(cmt);
        userCommentCollection.add(cmt);
        
        cmt.setPostId(post);
        cmt.setUserId(user);
        cmt.setParentCommentId(parentComment);
        cmt.setComment(comment);
        em.merge(post);
        em.merge(user);
        em.merge(cmt);
    }

    @Override
    public void deleteComment(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommentsTB> getAllComments(Integer userId, Integer postId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
