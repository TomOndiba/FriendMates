/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import EntityClasses.PostTB;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PostBeanLocal {
    void insertPost(String heading,String description,Boolean isImage,String imageUrl,Boolean isVideo,String videoUrl,Integer userId,String location,Date createdDate);
    void updatePost(Integer id,String heading,String description,Boolean isImage,String imageUrl,Boolean isVideo,String videoUrl,Integer userId,String location);
    void deletePost(Integer id);
    List<PostTB> getAllPosts(Integer userId);
}
