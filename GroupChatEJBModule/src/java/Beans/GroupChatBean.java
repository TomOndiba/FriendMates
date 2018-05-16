/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import EntityClasses.GroupChatTB;
import EntityClasses.UserTB;
import java.util.Date;
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
public class GroupChatBean implements GroupChatBeanLocal {

    @PersistenceContext(unitName = "PersistenceEJBPU")
    EntityManager em;

    @Override
    public void insertGroupChat(Integer createdUserId, String name, Date createdDate) {

        UserTB user = (UserTB) em.find(UserTB.class, createdUserId);

        Collection<GroupChatTB> groupChatCollection = user.getGroupChatTBCollection1();

        GroupChatTB groupChat = new GroupChatTB();

        groupChat.setCreatedUserId(user);
        groupChat.setName(name);
        groupChat.setCreatedDate(createdDate);

        groupChatCollection.add(groupChat);
        user.setGroupChatTBCollection1(groupChatCollection);
        em.persist(groupChat);
        em.merge(user);
    }

    @Override
    public void updateGroupChat(Integer id, Integer createdUserId, String name) {

        UserTB user = (UserTB) em.find(UserTB.class, createdUserId);

        Collection<GroupChatTB> groupChatCollection = user.getGroupChatTBCollection1();

        GroupChatTB groupChat = (GroupChatTB) em.find(GroupChatTB.class, id);

        groupChat.setCreatedUserId(user);
        groupChat.setName(name);

        user.setGroupChatTBCollection1(groupChatCollection);
        em.merge(groupChat);
        em.merge(user);
    }

    @Override
    public void deleteGroupChat(Integer id) {

        GroupChatTB groupChat = (GroupChatTB) em.find(GroupChatTB.class, id);

        em.remove(groupChat);
    }

    @Override
    public List<GroupChatTB> getAllGroupChat(Integer createdUserId) {
        
        UserTB user=(UserTB)em.find(UserTB.class, createdUserId);
        List<GroupChatTB> groupChats=(List<GroupChatTB>)user.getGroupChatTBCollection1();
        return groupChats;
    }
   
}
