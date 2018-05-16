/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import EntityClasses.CommentsTB;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface CommentsBeanLocal {
    void insertComment(Integer postId,Integer userId,Integer parentCommentId,String comment);
    void updateComment(Integer id,Integer postId,Integer userId,Integer parentCommentId,String comment);
    void deleteComment(Integer id);
    List<CommentsTB> getAllComments(Integer userId,Integer postId);
}
