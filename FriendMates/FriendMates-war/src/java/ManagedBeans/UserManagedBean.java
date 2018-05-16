/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Beans.UserBeanLocal;
import EntityClasses.UserTB;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@Named(value = "userManagedBean")
@RequestScoped
public class UserManagedBean {

    @EJB
    private UserBeanLocal userBean;

    String firstName, lastName, emailId, password, gender = "Male";
    BigInteger mobileNo;
    Date dob;
    Integer countryId;
    Map<String, Integer> lstCountry;
    Boolean isValid = false;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigInteger getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(BigInteger mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    
    public Map<String, Integer> getLstCountry() throws SQLException {
        Map<String, Integer> TemplstCountry = new LinkedHashMap<String, Integer>();
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/SocialNetworkDB", "root", "root");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from countryTB order by countryName");

            while (rs.next()) {
//                countryTB country = new countryTB();
//                country.setId(rs.getInt("id"));
//                country.setCountryName(rs.getString("countryName"));
                TemplstCountry.put(rs.getString("countryName"), rs.getInt("id"));
            }
            return TemplstCountry;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return null;
    }

    public void setLstCountry(Map<String, Integer> lstCountry) {
        this.lstCountry = lstCountry;
    }

    public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void clearText() {
        firstName = null;
        lastName = null;
        mobileNo = null;
        emailId = null;
        password = null;
        countryId = null;
        dob = null;
        gender = "Male";
    }

    public String insertUser() {
        try {
                String pwdenc = sha256(password);
                userBean.insertUser(firstName, lastName, mobileNo, emailId, pwdenc, dob, gender, countryId, new java.util.Date());
                clearText();
                return "/LoginRegistration.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public String doLogin() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            try {
                request.login(emailId, password);
            } catch (Exception e) {
                FacesMessage msg = new FacesMessage("Username or password is Incorrect");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage(null, msg);
                throw new ValidatorException(msg);
                //return "LoginRegistration.xhtml?faces-redirect=true";

            }

            if (request.isUserInRole("UserRole")) {
                HttpSession userSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                userSession.setAttribute("userEmail", emailId);
                return "/User/index.xhtml?faces-redirect=true";
            } else if (request.isUserInRole("AdminRole")) {
                return "/index.html?faces-redirect=true";
            } else {
                return "/LoginRegistration.xhtml?faces-redirect=true";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void validateFName(FacesContext context, UIComponent comp,
            Object value) {
        String name = value.toString();
        String pattern = "^[A-Za-z]+$";
        if (!name.matches(pattern)) {

            FacesMessage message = new FacesMessage(
                    "Enter valid first name");
            context.addMessage(comp.getClientId(context), message);                       
            
            throw new ValidatorException(message);
        }        
    }

    public void validateLName(FacesContext context, UIComponent comp,
            Object value) {
        String name = value.toString();
        String pattern = "^[A-Za-z]+$";
        if (!name.matches(pattern)) {

            FacesMessage message = new FacesMessage(
                    "Enter valid last name");
            context.addMessage(comp.getClientId(context), message);
            
            throw new ValidatorException(message);

        }
    }

    public void validateMobileNo(FacesContext context, UIComponent comp,
            Object value) {

        String mno = value.toString();
        String pattern = "^[0-9]{10}$";
        if (!mno.matches(pattern)) {

            FacesMessage message = new FacesMessage(
                    "Mobile number must be of 10 digits");
            context.addMessage(comp.getClientId(context), message);

            throw new ValidatorException(message);
        }
    }

    public void validateEmail(FacesContext context, UIComponent comp,
            Object value) {
        String email = value.toString();
        String pattern = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,4})+$";
        
        List<UserTB> lstUser=userBean.getUserByEmailId(email);
        
        if (!email.matches(pattern)) {

            FacesMessage message = new FacesMessage(
                    "Enter valid Email-ID");
            context.addMessage(comp.getClientId(context), message);

            throw new ValidatorException(message);
        }
        else if(lstUser.size() > 0)
        {
            FacesMessage message = new FacesMessage(
                    "Email-ID already in use");
            context.addMessage(comp.getClientId(context), message);
            
            throw new ValidatorException(message);
        }
    }

    public void validatePassword(FacesContext context, UIComponent comp,
            Object value) {
        String pass = value.toString();
        String pattern = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
        if (!pass.matches(pattern)) {

            FacesMessage message = new FacesMessage(
                    "Passwords must contain at least 1 upper case , 1 lower case , 1 number or special character and atleast 8 characters in length ");
            context.addMessage(comp.getClientId(context), message);

            throw new ValidatorException(message);
        }
    }

    public void checkLogin() {

        HttpSession userSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if (userSession.getAttribute("userEmail") == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../LoginRegistration.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String email = userSession.getAttribute("userEmail").toString();
            emailId = email;
            List<UserTB> userList = userBean.getUserByEmailId(emailId);

            for (UserTB user : userList) {

                firstName = user.getFName();
                lastName = user.getLName();

            }
        }
        //}
    }

    public String doLogout() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            try {
                request.logout();
                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/LoginRegistration.xhtml?faces-redirect=true";
    }

    public UserManagedBean() {
    }

}
