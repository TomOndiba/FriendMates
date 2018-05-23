/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import EntityClasses.FriendRequestTB;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface FriendRequestBeanLocal {
    void sendFriendRequest(Integer fromUserId,Integer toUserId);
    void deleteFriendRequest(Integer id);
    List<FriendRequestTB> getAllFriendRequests(Integer userId);
    List<FriendRequestTB> getFriendRequestsByToUserIdAndFromUserId(Integer fromUserId,Integer toUserId);
}
