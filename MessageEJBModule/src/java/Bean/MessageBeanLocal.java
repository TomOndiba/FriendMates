/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import EntityClasses.MessageTB;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface MessageBeanLocal {
    void insertMessage(Integer fromUserId,Integer toUserId,Integer groupId,Date time,String messageText,Boolean isFile,String fileUrl,Date createdDate);
    void updateMessage(Integer id,Integer fromUserId,Integer toUserId,Integer groupId,Date time,String messageText,Boolean isFile,String fileUrl);
    void deleteMessage(Integer id);
    //List<MessageTB> getAllMessages(Integer userId);
}
