/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface GroupChatXUserBeanLocal {
    
    void insertUserToGroup(Integer groupChatId,Integer userId);
    void deleteUserFromGroup(Integer groupChatId,Integer userId);
}
