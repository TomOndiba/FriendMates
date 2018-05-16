/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import EntityClasses.LikeTB;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface LikeBeanLocal {
    void insertLike(Integer postId,Integer userId,Boolean status,Date createdDate);
    void updateLike(Integer id,Boolean status,Integer postId, Integer userId);
    void deleteLike(Integer id);
    List<Object []> getAllLikes(Integer userId,Integer postId);
}
