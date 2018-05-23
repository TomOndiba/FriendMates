/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import EntityClasses.FriendRequestTB;
import EntityClasses.UserTB;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class FriendRequestBean implements FriendRequestBeanLocal {

    @PersistenceContext(unitName = "PersistenceEJBPU")
    EntityManager em;
    
    @Override
    public void sendFriendRequest(Integer fromUserId, Integer toUserId) {
        UserTB fromUser = em.find(UserTB.class, fromUserId);
        UserTB toUser=em.find(UserTB.class, toUserId);
        
        Collection<FriendRequestTB> fromUserCollection=fromUser.getFriendRequestTBCollection();
        Collection<FriendRequestTB> toUserCollection=toUser.getFriendRequestTBCollection1();

        FriendRequestTB friendRequest=new FriendRequestTB();
        
        friendRequest.setFromUserId(fromUser);
        friendRequest.setToUserId(toUser);
        
        fromUserCollection.add(friendRequest);
        toUserCollection.add(friendRequest);
        
        fromUser.setFriendRequestTBCollection(fromUserCollection);
        toUser.setFriendRequestTBCollection1(fromUserCollection);
        
        em.persist(friendRequest);
    }

    @Override
    public void deleteFriendRequest(Integer id) {
        
        FriendRequestTB friendRequest=em.find(FriendRequestTB.class, id);
        
        em.remove(friendRequest);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<FriendRequestTB> getAllFriendRequests(Integer userId) {
        
        return em.createNamedQuery("FriendRequestTB.findByToUserId").setParameter("userId", userId).getResultList();
        
    }

    @Override
    public List<FriendRequestTB> getFriendRequestsByToUserIdAndFromUserId(Integer fromUserId, Integer toUserId) {
        
        return em.createNamedQuery("FriendRequestTB.findByToUserIdAndFromUserId").setParameter("fromuserId", fromUserId).setParameter("touserId", toUserId).getResultList();
    }

}
