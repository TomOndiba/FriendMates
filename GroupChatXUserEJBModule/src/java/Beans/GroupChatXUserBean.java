/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import EntityClasses.GroupChatTB;
import EntityClasses.UserTB;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class GroupChatXUserBean implements GroupChatXUserBeanLocal {

    @PersistenceContext(unitName = "PersistenceEJBPU")
    EntityManager em;

    @Override
    public void insertUserToGroup(Integer groupChatId, Integer userId) {

        GroupChatTB groupChat = (GroupChatTB) em.find(GroupChatTB.class, groupChatId);
        UserTB user = (UserTB) em.find(UserTB.class, userId);

        Collection<UserTB> userCollection = groupChat.getUserTBCollection();
        Collection<GroupChatTB> groupChatCollection = user.getGroupChatTBCollection();

        if (!(userCollection.contains(user))) {
            userCollection.add(user);
            groupChatCollection.add(groupChat);
        }
        
        em.merge(groupChat);
    }

    @Override
    public void deleteUserFromGroup(Integer groupChatId, Integer userId) {
        
        GroupChatTB groupChat = (GroupChatTB) em.find(GroupChatTB.class, groupChatId);
        UserTB user = (UserTB) em.find(UserTB.class, userId);

        Collection<UserTB> userCollection = groupChat.getUserTBCollection();
        Collection<GroupChatTB> groupChatCollection = user.getGroupChatTBCollection();

        if (userCollection.contains(user)) {
            userCollection.remove(user);
            groupChatCollection.remove(groupChat);
        }
        
        em.merge(groupChat);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
