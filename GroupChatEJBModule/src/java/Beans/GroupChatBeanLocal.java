/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import EntityClasses.GroupChatTB;
import EntityClasses.UserTB;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface GroupChatBeanLocal {
    
    void insertGroupChat(Integer createdUserId,String name,Date createdDate);
    void updateGroupChat(Integer id, Integer createdUserId,String name);
    void deleteGroupChat(Integer id);
    List<GroupChatTB> getAllGroupChat(Integer createdUserId);
}
