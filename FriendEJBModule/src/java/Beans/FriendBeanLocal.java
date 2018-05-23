/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import EntityClasses.FriendTB;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface FriendBeanLocal {
    
    List<FriendTB> getFriendByUser1AndUser2(Integer User1,Integer User2);
    void insertFriends(Integer User1,Integer User2);
}
