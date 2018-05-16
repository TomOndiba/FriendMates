/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import EntityClasses.GroupChatTB;
import EntityClasses.GroupTB;
import EntityClasses.MessageTB;
import EntityClasses.UserTB;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class MessageBean implements MessageBeanLocal {

    @PersistenceContext(unitName = "PersistenceEJBPU")
    EntityManager em;
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void insertMessage(Integer fromUserId, Integer toUserId, Integer groupId, Date time, String messageText, Boolean isFile, String fileUrl, Date createdDate) {
        UserTB fromUser=(UserTB)em.find(UserTB.class, fromUserId);
        UserTB toUser=(UserTB)em.find(UserTB.class, toUserId);
        GroupChatTB group=(GroupChatTB)em.find(GroupChatTB.class, groupId);
        
        Collection<MessageTB> fromUserCollection=fromUser.getMessageTBCollection();
        Collection<MessageTB> toUserCollection=toUser.getMessageTBCollection();
        Collection<MessageTB> groupCollection=group.getMessageTBCollection();
        
        MessageTB msg=new MessageTB();
        msg.setFromUserId(fromUser);
        msg.setToUserId(toUser);
        msg.setGroupId(group);
        msg.setTime(time);
        msg.setMessageText(messageText);
        msg.setIsFile(isFile);
        msg.setFileUrl(fileUrl);
        msg.setCreatedDate(createdDate);
        
        fromUserCollection.add(msg);
        toUserCollection.add(msg);
        groupCollection.add(msg);
        
        em.persist(msg);
        
    }

    @Override
    public void updateMessage(Integer id, Integer fromUserId, Integer toUserId, Integer groupId, Date time, String messageText, Boolean isFile, String fileUrl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMessage(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
