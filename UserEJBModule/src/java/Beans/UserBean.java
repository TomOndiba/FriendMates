/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import EntityClasses.CountryTB;
import EntityClasses.GroupTB;
import EntityClasses.GroupTBPK;
import EntityClasses.UserTB;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class UserBean implements UserBeanLocal {

    @PersistenceContext(unitName = "PersistenceEJBPU")
    EntityManager em;

    @Override
    public void insertUser(String fName, String lName, BigInteger mobileNo, String emailId, String password, Date dob, String gender, Integer countryId, Date createdDate) {

        try {
            CountryTB country = (CountryTB) em.find(CountryTB.class, countryId);

            UserTB user = new UserTB();

            user.setFName(fName);
            user.setLName(lName);
            user.setMobileNo(mobileNo);
            user.setEmailId(emailId);
            user.setPassword(password);
            user.setDob(dob);
            user.setGender(gender);
            user.setCreatedDate(createdDate);
            user.setCountryId(country);

            GroupTBPK grpPK = new GroupTBPK();

            grpPK.setEmailId(emailId);
            grpPK.setGroupName("UserGroup");

            GroupTB grp = new GroupTB();

            grp.setGroupTBPK(grpPK);
            grp.setUserTB(user);

            em.persist(user);
            em.persist(grp);

        } catch (Exception ex) {

        }

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void updateUser(Integer id, String fName, String lName, BigInteger mobileNo, String emailId, String password, Date dob, Integer countryId, String gender) {

        try {

            CountryTB country = (CountryTB) em.find(CountryTB.class, countryId);

            UserTB user = em.find(UserTB.class, id);

            user.setFName(fName);
            user.setLName(lName);
            user.setMobileNo(mobileNo);
            user.setEmailId(emailId);
            user.setPassword(password);
            user.setDob(dob);
            user.setGender(gender);
            user.setCountryId(country);

            em.merge(user);

        } catch (Exception ex) {

        }
    }

    @Override
    public void deleteUser(Integer id) {

        try {

            UserTB user = em.find(UserTB.class, id);

            em.remove(user);

        } catch (Exception ex) {
        }
    }

    @Override
    public List<UserTB> getAllUsers() {

        return em.createNamedQuery("UserTB.findAll").getResultList();

    }

    @Override
    public List<UserTB> getUserByEmailId(String emailId) {

        return em.createNamedQuery("UserTB.findByEmailId").setParameter("emailId", emailId).getResultList();

    }
}
