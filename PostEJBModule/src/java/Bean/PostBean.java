/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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
public class PostBean implements PostBeanLocal {

    @PersistenceContext(unitName = "PersistenceEJBPU")
    EntityManager em;
    
    @Override
    public void insertPost(String heading, String description, Boolean isImage, String imageUrl, Boolean isVideo, String videoUrl, Integer userId, String location, Date createdDate) {
        UserTB user=(UserTB)em.find(UserTB.class, userId);
        Collection<PostTB> postList=user.getPostTBCollection();
        
        PostTB post=new PostTB();
        post.setHeading(heading);
        post.setDescription(description);
        post.setIsImage(isImage);
        post.setImageUrl(imageUrl);
        post.setIsVideo(isVideo);
        post.setVideoUrl(videoUrl);
        post.setUserId(user);
        post.setLocation(location);
        post.setCreatedDate(createdDate);
        
        user.setPostTBCollection(postList);
        
        em.persist(post);
        
    }

    @Override
    public void updatePost(Integer id, String heading, String description, Boolean isImage, String imageUrl, Boolean isVideo, String videoUrl, Integer userId, String location) {
        UserTB user = (UserTB) em.find(UserTB.class, userId);
        
        Collection<PostTB> postList=user.getPostTBCollection();
        
        PostTB post=(PostTB)em.find(PostTB.class, id);
        
        post.setHeading(heading);
        post.setDescription(description);
        post.setIsImage(isImage);
        post.setImageUrl(imageUrl);
        post.setIsVideo(isVideo);
        post.setVideoUrl(videoUrl);
        post.setUserId(user);
        post.setLocation(location);
        user.setPostTBCollection(postList);
        em.merge(post);
    }

    @Override
    public void deletePost(Integer id) {
        PostTB post=(PostTB)em.find(PostTB.class, id);
        em.remove(post);
    }

    @Override
    public List<PostTB> getAllPosts(Integer userId) {
        
        UserTB user=(UserTB)em.find(UserTB.class,userId );
        List<PostTB> post=(List<PostTB>)user.getPostTBCollection();
        return post;
    }

    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
