/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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
public class LikeBean implements LikeBeanLocal {

    @PersistenceContext(unitName = "PersistenceEJBPU")
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void insertLike(Integer postId, Integer userId, Boolean status, Date createdDate) {

        UserTB user = (UserTB) em.find(UserTB.class, userId);
        PostTB post = (PostTB) em.find(PostTB.class, postId);

        Collection<LikeTB> userLikeCollection = user.getLikeTBCollection();
        Collection<LikeTB> postLikeCollection = post.getLikeTBCollection();

        
            //System.out.println(listOfLikes.toString());
        
//        if (!(userLikeCollection.contains(user) && postLikeCollection.contains(post))) {
//
//            LikeTB l = new LikeTB();
//
//            l.setPostId(post);
//            l.setUserId(user);
//            l.setStatus(status);
//            l.setCreatedDate(createdDate);
//
//            user.setLikeTBCollection(userLikeCollection);
//            post.setLikeTBCollection(postLikeCollection);
//
//            em.persist(l);
//        } else {
//
//        }
    }

    @Override
    public void updateLike(Integer id, Boolean status, Integer postId, Integer userId) {

        UserTB user = (UserTB) em.find(UserTB.class, userId);
        PostTB post = (PostTB) em.find(PostTB.class, postId);

        Collection<LikeTB> userLikeCollection = user.getLikeTBCollection();
        Collection<LikeTB> postLikeCollection = post.getLikeTBCollection();

        LikeTB like = (LikeTB) em.find(LikeTB.class, id);

        like.setStatus(status);

        user.setLikeTBCollection(userLikeCollection);
        post.setLikeTBCollection(postLikeCollection);

        em.merge(like);
    }

    @Override
    public void deleteLike(Integer id) {

        LikeTB likes = (LikeTB) em.find(LikeTB.class, id);

        em.remove(likes);
    }

    @Override
    public List<Object []> getAllLikes(Integer userId, Integer postId) {
        List<Object []> listOfLikes = em.createNamedQuery("LikeTB.findByPostAndUser").setParameter("postId", postId).setParameter("userId", userId).getResultList();

        for (Object[] listOfLike : listOfLikes) {
          
            System.out.println(listOfLike[1].toString());
           // System.out.println(listOfLike.getHeading());
//          UserTB u=(UserTB)listOfLike;
//            System.out.println(u.getFName());
        }
        
        return listOfLikes;
    }

}
