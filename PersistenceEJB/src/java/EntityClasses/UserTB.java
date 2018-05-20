/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "userTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTB.findAll", query = "SELECT u FROM UserTB u"),
    @NamedQuery(name = "UserTB.findById", query = "SELECT u FROM UserTB u WHERE u.id = :id"),
    @NamedQuery(name = "UserTB.findByFName", query = "SELECT u FROM UserTB u WHERE u.fName = :fName"),
    @NamedQuery(name = "UserTB.findByLName", query = "SELECT u FROM UserTB u WHERE u.lName = :lName"),
    @NamedQuery(name = "UserTB.findByMobileNo", query = "SELECT u FROM UserTB u WHERE u.mobileNo = :mobileNo"),
    @NamedQuery(name = "UserTB.findByEmailId", query = "SELECT u FROM UserTB u WHERE u.emailId = :emailId"),
    @NamedQuery(name = "UserTB.findByPassword", query = "SELECT u FROM UserTB u WHERE u.password = :password"),
    @NamedQuery(name = "UserTB.findByDob", query = "SELECT u FROM UserTB u WHERE u.dob = :dob"),
    @NamedQuery(name = "UserTB.findByGender", query = "SELECT u FROM UserTB u WHERE u.gender = :gender"),
    @NamedQuery(name = "UserTB.findByProfilePicture", query = "SELECT u FROM UserTB u WHERE u.profilePicture = :profilePicture"),
    @NamedQuery(name = "UserTB.findByIsVerified", query = "SELECT u FROM UserTB u WHERE u.isVerified = :isVerified"),
    @NamedQuery(name = "UserTB.findByVerificationCode", query = "SELECT u FROM UserTB u WHERE u.verificationCode = :verificationCode"),
    @NamedQuery(name = "UserTB.findByVerificationCodeAndEmailId", query = "SELECT u FROM UserTB u WHERE u.verificationCode = :verificationCode AND u.emailId = :emailId"),
    @NamedQuery(name = "UserTB.findByCreatedDate", query = "SELECT u FROM UserTB u WHERE u.createdDate = :createdDate")})
public class UserTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "fName")
    private String fName;
    @Size(max = 255)
    @Column(name = "lName")
    private String lName;
    @Column(name = "mobileNo")
    private BigInteger mobileNo;
    @Size(max = 255)
    @Column(name = "emailId")
    private String emailId;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 6)
    @Column(name = "gender")
    private String gender;
    @Size(max = 255)
    @Column(name = "profilePicture")
    private String profilePicture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isVerified")
    private int isVerified;
    @Size(max = 255)
    @Column(name = "verificationCode")
    private String verificationCode;
    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @ManyToMany(mappedBy = "userTBCollection")
    private Collection<GroupChatTB> groupChatTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userTB")
    private Collection<GroupTB> groupTBCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<LikeTB> likeTBCollection;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne
    private CountryTB countryId;
    @OneToMany(mappedBy = "createdUserId")
    private Collection<GroupChatTB> groupChatTBCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromUserId")
    private Collection<FriendRequestTB> friendRequestTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toUserId")
    private Collection<FriendRequestTB> friendRequestTBCollection1;
    @OneToMany(mappedBy = "userId")
    private Collection<CommentsTB> commentsTBCollection;
    @OneToMany(mappedBy = "fromUserId")
    private Collection<MessageTB> messageTBCollection;
    @OneToMany(mappedBy = "toUserId")
    private Collection<MessageTB> messageTBCollection1;
    @OneToMany(mappedBy = "userId")
    private Collection<PostTB> postTBCollection;

    public UserTB() {
    }

    public UserTB(Integer id) {
        this.id = id;
    }

    public UserTB(Integer id, int isVerified) {
        this.id = id;
        this.isVerified = isVerified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public BigInteger getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(BigInteger mobileNo) {
        this.mobileNo = mobileNo;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public int getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(int isVerified) {
        this.isVerified = isVerified;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Collection<GroupChatTB> getGroupChatTBCollection() {
        return groupChatTBCollection;
    }

    public void setGroupChatTBCollection(Collection<GroupChatTB> groupChatTBCollection) {
        this.groupChatTBCollection = groupChatTBCollection;
    }

    @XmlTransient
    public Collection<GroupTB> getGroupTBCollection() {
        return groupTBCollection;
    }

    public void setGroupTBCollection(Collection<GroupTB> groupTBCollection) {
        this.groupTBCollection = groupTBCollection;
    }

    @XmlTransient
    public Collection<LikeTB> getLikeTBCollection() {
        return likeTBCollection;
    }

    public void setLikeTBCollection(Collection<LikeTB> likeTBCollection) {
        this.likeTBCollection = likeTBCollection;
    }

    public CountryTB getCountryId() {
        return countryId;
    }

    public void setCountryId(CountryTB countryId) {
        this.countryId = countryId;
    }

    @XmlTransient
    public Collection<GroupChatTB> getGroupChatTBCollection1() {
        return groupChatTBCollection1;
    }

    public void setGroupChatTBCollection1(Collection<GroupChatTB> groupChatTBCollection1) {
        this.groupChatTBCollection1 = groupChatTBCollection1;
    }

    @XmlTransient
    public Collection<FriendRequestTB> getFriendRequestTBCollection() {
        return friendRequestTBCollection;
    }

    public void setFriendRequestTBCollection(Collection<FriendRequestTB> friendRequestTBCollection) {
        this.friendRequestTBCollection = friendRequestTBCollection;
    }

    @XmlTransient
    public Collection<FriendRequestTB> getFriendRequestTBCollection1() {
        return friendRequestTBCollection1;
    }

    public void setFriendRequestTBCollection1(Collection<FriendRequestTB> friendRequestTBCollection1) {
        this.friendRequestTBCollection1 = friendRequestTBCollection1;
    }

    @XmlTransient
    public Collection<CommentsTB> getCommentsTBCollection() {
        return commentsTBCollection;
    }

    public void setCommentsTBCollection(Collection<CommentsTB> commentsTBCollection) {
        this.commentsTBCollection = commentsTBCollection;
    }

    @XmlTransient
    public Collection<MessageTB> getMessageTBCollection() {
        return messageTBCollection;
    }

    public void setMessageTBCollection(Collection<MessageTB> messageTBCollection) {
        this.messageTBCollection = messageTBCollection;
    }

    @XmlTransient
    public Collection<MessageTB> getMessageTBCollection1() {
        return messageTBCollection1;
    }

    public void setMessageTBCollection1(Collection<MessageTB> messageTBCollection1) {
        this.messageTBCollection1 = messageTBCollection1;
    }

    @XmlTransient
    public Collection<PostTB> getPostTBCollection() {
        return postTBCollection;
    }

    public void setPostTBCollection(Collection<PostTB> postTBCollection) {
        this.postTBCollection = postTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTB)) {
            return false;
        }
        UserTB other = (UserTB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.UserTB[ id=" + id + " ]";
    }

}
