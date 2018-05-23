/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Beans.UserBeanLocal;
import EntityClasses.UserTB;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author root
 */
@Named(value = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable {

    @EJB
    private UserBeanLocal userBean;

    Integer userId;
    String firstName, lastName, emailId, password, gender = "Male", profilePicture;
    BigInteger mobileNo;
    Date dob;
    Integer countryId;
    Map<String, Integer> lstCountry;
    String uploadPath = getPath(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/Uploads/"));
    List<UserTB> lstUsers;
    UserTB user = new UserTB();
    UserTB selected;
    Boolean blnIsDialogOpen = false;
    Boolean isVerified = false;
    Boolean isMailSent = false;
    String theme = "delta";

    Cipher ecipher;
    Cipher dcipher;
    int iterationCount = 19;
    // 8-byte Salt
    byte[] salt = {
        (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
        (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    };

    public UserTB getUser() {
        return user;
    }

    public void setUser(UserTB user) {
        this.user = user;
    }

    public UserTB getSelected() {
        return selected;
    }

    public void setSelected(UserTB selected) {
        this.selected = selected;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public List<UserTB> getLstUsers() {
        return lstUsers;
    }

    public void setLstUsers(List<UserTB> lstUsers) {
        this.lstUsers = lstUsers;
    }

    public Boolean getBlnIsDialogOpen() {
        return blnIsDialogOpen;
    }

    public void setBlnIsDialogOpen(Boolean blnIsDialogOpen) {
        this.blnIsDialogOpen = blnIsDialogOpen;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public Boolean getIsMailSent() {
        return isMailSent;
    }

    public void setIsMailSent(Boolean isMailSent) {
        this.isMailSent = isMailSent;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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

        userId = null;
        firstName = null;
        lastName = null;
        mobileNo = null;
        emailId = null;
        password = null;
        countryId = null;
        dob = null;
        gender = "Male";
        profilePicture = null;
        blnIsDialogOpen = false;
        isVerified = false;
    }

    public String insertUser() {
        try {
            String pwdenc = sha256(password);
            userBean.insertUser(firstName, lastName, mobileNo, emailId, pwdenc, dob, gender, countryId, new java.util.Date());
            isMailSent = false;
            sendActivationMail();
            clearText();
            return "/LoginRegistration.xhtml?faces-redirect=true";

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void sendActivationMail() {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("friendmates8141@gmail.com", "Viharsh1234");
                    }
                });

        try {

            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("friendmates8141@gmail.com", "Friend Mates"));
            msg.setRecipients(Message.RecipientType.TO, emailId);
            msg.setSubject("FriendMates Activation");
            msg.setSentDate(new Date());

            String code = RandomStringUtils.randomAlphanumeric(12);
            String varificationCode = encrypt(code);
            String email = encrypt(emailId);
            Multipart multipart = new MimeMultipart();

            //String textContent = "<a href='http://localhost:8080/FriendMates-war/faces/VerifyUser.xhtml?code=" + varificationCode + "&emailId=" + email + "'>Verify your self</a>";
            String textContent = "<html xmlns=\"http://www.w3.org/1999/xhtml\" style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">"
                    + "<head>"
                    + "<meta name=\"viewport\" content=\"width=device-width\" />"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />"
                    + "<title>Actionable emails e.g. reset password</title>"
                    + "<style type=\"text/css\">"
                    + "img {"
                    + "max-width: 100%;"
                    + "}"
                    + "body {"
                    + "-webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; width: 100% !important; height: 100%; line-height: 1.6em;"
                    + "}"
                    + "body {"
                    + "background-color: #F8F8F8;"
                    + "  color: #222F33;"
                    + "}"
                    + "@media only screen and (max-width: 640px) {"
                    + "  body {"
                    + "    padding: 0 !important;"
                    + "  }"
                    + "  h1 {"
                    + "    font-weight: 800 !important; margin: 20px 0 5px !important;"
                    + "  }"
                    + "  h2 {"
                    + "    font-weight: 800 !important; margin: 20px 0 5px !important;"
                    + "  }"
                    + "  h3 {"
                    + "    font-weight: 800 !important; margin: 20px 0 5px !important;"
                    + "  }"
                    + "  h4 {"
                    + "    font-weight: 800 !important; margin: 20px 0 5px !important;"
                    + "  }"
                    + "  h1 {"
                    + "    font-size: 22px !important;"
                    + "    line-height: 150%; !important;"
                    + "  }"
                    + "  h2 {"
                    + "    font-size: 18px !important;"
                    + "    line-height: 2.0em; !important;"
                    + "  }"
                    + "  h3 {"
                    + "    font-size: 16px !important;"
                    + "    line-height: 150%; !important;"
                    + "  }"
                    + "  .container {"
                    + "    padding: 0 !important; width: 100% !important;"
                    + "  }"
                    + "  .content {"
                    + "    padding: 0 !important;"
                    + "  }"
                    + "  .content-wrap {"
                    + "    padding: 10px !important;"
                    + "  }"
                    + "  .invoice {"
                    + "    width: 100% !important;"
                    + "  }"
                    + "}"
                    + "</style>"
                    + "</head>"
                    + ""
                    + "<body itemscope itemtype=\"http://schema.org/EmailMessage\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; width: 100% !important; height: 100%; line-height: 1.6em; background-color: #F8F8F8; margin: 0;\" bgcolor=\"#F8F8F8\">"
                    + ""
                    + "<table class=\"body-wrap\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; width: 100%; background-color: #F8F8F8; margin: 0;\" bgcolor=\"#F8F8F8\"><tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\"><td style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0;\" valign=\"top\"></td>"
                    + "		<td class=\"container\" width=\"600\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; display: block !important; max-width: 600px !important; clear: both !important; margin: 0 auto;\" valign=\"top\">"
                    + "			<div class=\"content\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; max-width: 600px; display: block; margin: 0 auto; padding: 20px;\">"
                    + "				<table class=\"main\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" itemprop=\"action\" itemscope itemtype=\"http://schema.org/ConfirmAction\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; border-radius: 3px; background-color: #fff; margin: 0; border: 1px solid #e9e9e9;\" bgcolor=\"#fff\"><tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\"><td class=\"content-wrap\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 20px;\" valign=\"top\">"
                    + "							<meta itemprop=\"name\" content=\"Confirm Email\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\" /><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\"><tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\"><td class=\"content-block\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 0 0 20px;\" valign=\"top\">"
                    + "          <h2>										Please confirm your email address by clicking the link below.</h2>"
                    + "									</td>"
                    + "								</tr><tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\"><td class=\"content-block\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 0 0 20px;\" valign=\"top\">"
                    + "Welcome to FriendMates! <br><br> Your account is almost set up. All you need to do is verify your email address by clicking on the button below so that we know it is really you."
                    + "									</td>"
                    + "								</tr><tr style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\"><td class=\"content-block\" itemprop=\"handler\" itemscope itemtype=\"http://schema.org/HttpActionHandler\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 0 0 20px;\" valign=\"top\">"
                    + "										<a href='http://localhost:8080/FriendMates-war/faces/VerifyUser.xhtml?code=" + varificationCode + "&emailId=" + email + "' class=\"btn-primary\" itemprop=\"url\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; color: #FFF; text-decoration: none; line-height: 2em; font-weight: bold; text-align: center; cursor: pointer; display: inline-block; border-radius: 5px; text-transform: capitalize; background-color: #FF691C; margin: 0; border-color: #FF691C; border-style: solid; border-width: 10px 20px;\">Confirm my Email Address</a>"
                    + "									</td>"
                    + "								</tr>"
                    + "          </table></td>"
                    + "					</tr></table><div class=\"footer\" style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; width: 100%; clear: both; color: #999; margin: 0; padding: 20px;\">"
                    + "					</body>"
                    + "</html>";
            msg.setContent(textContent, "text/html");
            Transport.send(msg);

            List<UserTB> users = userBean.getUserByEmailId(emailId);

            for (UserTB user : users) {

                userId = user.getId();
            }

            userBean.updateVerificationCode(userId, code);

            isMailSent = true;

            FacesMessage success = new FacesMessage("Verification Email sent to your registered Email-ID...!!!");
            success.setSeverity(success.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, success);
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        } catch (UnsupportedEncodingException | MessagingException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
            ex.printStackTrace();
        }
    }

    public String encrypt(String plainText) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {

        String secretKey = "FriendMatesViHarsh";
        //Key generation for enc and desc
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        // Prepare the parameter to the ciphers
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

        //Enc process
        ecipher = Cipher.getInstance(key.getAlgorithm());
        ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        String charSet = "UTF-8";
        byte[] in = plainText.getBytes(charSet);
        byte[] out = ecipher.doFinal(in);
        String encStr = new String(Base64.getEncoder().encode(out));
        return encStr;
    }

    public String decrypt(String encryptedText) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {

        String secretKey = "FriendMatesViHarsh";
        //Key generation for enc and desc
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        // Prepare the parameter to the ciphers
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
        //Decryption process; same key will be used for decr
        dcipher = Cipher.getInstance(key.getAlgorithm());
        dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        byte[] enc = Base64.getDecoder().decode(encryptedText);
        byte[] utf8 = dcipher.doFinal(enc);
        String charSet = "UTF-8";
        String plainStr = new String(utf8, charSet);
        return plainStr;
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
            }

            if (request.isUserInRole("UserRole")) {
                isMailSent = false;
                List<UserTB> lstUser = userBean.getUserByEmailId(emailId);
                UserTB logdInUser = new UserTB();
                for (UserTB user : lstUser) {
                    logdInUser = user;
                }
                if (logdInUser.getIsVerified() == 1) {
                    HttpSession userSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    userSession.setAttribute("userEmail", emailId);
                    theme = "home";
                    return "/User/index.xhtml?faces-redirect=true";
                } else {
                    request.logout();
                    FacesMessage msg = new FacesMessage("Verify your Email Address first...!!!");
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    throw new ValidatorException(msg);
                }
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

    public String getPath(String path) {
        return path.replaceAll("build/", "");
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

        List<UserTB> lstUser = userBean.getUserByEmailId(email);

        if (!email.matches(pattern)) {

            FacesMessage message = new FacesMessage(
                    "Enter valid Email-ID");
            context.addMessage(comp.getClientId(context), message);

            throw new ValidatorException(message);
        } else if (lstUser.size() > 0) {
            FacesMessage message = new FacesMessage(
                    "Email-ID already in use");
            context.addMessage(comp.getClientId(context), message);

            throw new ValidatorException(message);
        }
    }

    public void validatePassword(FacesContext context, UIComponent comp,
            Object value) {
        String pass = value.toString();
        //String pattern = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
        String pattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        if (!pass.matches(pattern)) {

            FacesMessage message = new FacesMessage(
                    "Passwords must contain at least 1 upper case , 1 lower case , 1 number and atleast 8 characters in length ");
            context.addMessage(comp.getClientId(context), message);

            throw new ValidatorException(message);
        }
    }
    Boolean blnVisible = true;

    public Boolean getBlnVisible() {
        return blnVisible;
    }

    public void setBlnVisible(Boolean blnVisible) {
        this.blnVisible = blnVisible;
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
                userId = user.getId();
                profilePicture = user.getProfilePicture();
            }
            if (profilePicture == null) {
                if (blnIsDialogOpen == false) {

                    blnIsDialogOpen = true;
                } else {
                    blnVisible = false;
                }
            } else {
                blnVisible = false;
            }
        }
        //}
    }

    public String doLogout() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            try {

                request.logout();
                clearText();
                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/LoginRegistration.xhtml?faces-redirect=true";
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmssSSS");
            String format = sdf.format(new java.util.Date());
            profilePicture = format;

            Path folder = Paths.get(uploadPath);
            String filename = FilenameUtils.getBaseName(profilePicture);
            String extension = FilenameUtils.getExtension(event.getFile().getFileName());

            Path file = Files.createTempFile(folder, "", "." + extension);

            uploadFile(profilePicture, extension ,file, event.getFile().getInputstream());

            userBean.uploadPhoto(userId, profilePicture);
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void uploadFile(String fileName, String extenstion ,Path file, InputStream in) {
        try {

            try {
                Files.copy(in, file,StandardCopyOption.REPLACE_EXISTING);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            file.toFile().renameTo(new File(uploadPath + "/" + fileName + "." + extenstion));
            
            profilePicture=fileName + "." + extenstion;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<UserTB> searchUsers(String query) {
        List<UserTB> allUser = userBean.getAllUsers();
        lstUsers = allUser;
        List<UserTB> filteredUser = new ArrayList<UserTB>();
        for (int i = 0; i < allUser.size(); i++) {
            UserTB usr = allUser.get(i);
            if (usr.getFName().toLowerCase().startsWith(query)) {
                filteredUser.add(usr);
            }
        }
        return filteredUser;
    }

    public void selectedUser() throws IOException {

        selected = user;
        HttpSession selectedUserSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        selectedUserSession.setAttribute("selectedUserId", selected.getId());

        FacesContext.getCurrentInstance().getExternalContext().redirect("profilePage.xhtml?faces-redirect=true");
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void verifyUser(String code, String email) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {

        String verificationCode = decrypt(code);
        String mail = decrypt(email);
        List<UserTB> lstUser = userBean.getUserByVerificationCodeAndEmail(verificationCode, mail);

        List<UserTB> verifiedUser = userBean.getUserByEmailId(mail);
        int verified = 0;
        String VerifiedCode = null;

        for (UserTB user : verifiedUser) {

            userId = user.getId();
            verified = user.getIsVerified();
            VerifiedCode = user.getVerificationCode();
        }

        if (lstUser.size() == 1) {

            isVerified = true;

            userBean.updateVerificationCodeAndStatus(userId);

        } else {

            if (verified == 1 && VerifiedCode == null) {
                isVerified = true;
            } else {
                isVerified = false;
            }
        }

        isMailSent = false;
    }

    public void manageFriendRequest(UserTB fromUser) throws IOException
    {
        selected=fromUser;
        FacesContext.getCurrentInstance().getExternalContext().redirect("profilePage.xhtml?faces-redirect=true");
        FacesContext.getCurrentInstance().responseComplete();
    }
    public UserManagedBean() {

    }
}
