/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import EntityClasses.UserTB;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface UserBeanLocal {
    
    void insertUser(String fName,String lName,BigInteger mobileNo,String emailId,String password,Date dob,String gender,Integer countryId,Date createdDate);
    void updateUser(Integer id,String fName,String lName,BigInteger mobileNo,String emailId,String password,Date dob,Integer countryId,String gender);
    void deleteUser(Integer id);
    List<UserTB> getAllUsers();
    List<UserTB> getUserByEmailId(String emailId);
}
