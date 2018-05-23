/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import EntityClasses.FriendTB;
import EntityClasses.FriendTBPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class FriendBean implements FriendBeanLocal {
    
    @PersistenceContext(unitName = "PersistenceEJBPU")
    EntityManager em;
    
    @Override
    public List<FriendTB> getFriendByUser1AndUser2(Integer User1, Integer User2) {
        
        return em.createNamedQuery("FriendTB.findByUserId1AndUserId2").setParameter("userId1", User1).setParameter("userId2", User2).getResultList();
    }

    @Override
    public void insertFriends(Integer User1, Integer User2) {
        
        FriendTBPK frnd=new FriendTBPK(User1, User2);
        FriendTB friendTB=new FriendTB(frnd);
        em.persist(friendTB);

        FriendTBPK frnd2=new FriendTBPK(User2 , User1);
        FriendTB friendTB2=new FriendTB(frnd2);
        em.persist(friendTB2);
    }
}
