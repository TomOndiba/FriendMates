/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "messageTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessageTB.findAll", query = "SELECT m FROM MessageTB m"),
    @NamedQuery(name = "MessageTB.findById", query = "SELECT m FROM MessageTB m WHERE m.id = :id"),
    @NamedQuery(name = "MessageTB.findByTime", query = "SELECT m FROM MessageTB m WHERE m.time = :time"),
    @NamedQuery(name = "MessageTB.findByMessageText", query = "SELECT m FROM MessageTB m WHERE m.messageText = :messageText"),
    @NamedQuery(name = "MessageTB.findByIsFile", query = "SELECT m FROM MessageTB m WHERE m.isFile = :isFile"),
    @NamedQuery(name = "MessageTB.findByFileUrl", query = "SELECT m FROM MessageTB m WHERE m.fileUrl = :fileUrl"),
    @NamedQuery(name = "MessageTB.findByCreatedDate", query = "SELECT m FROM MessageTB m WHERE m.createdDate = :createdDate")})
public class MessageTB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Size(max = 255)
    @Column(name = "messageText")
    private String messageText;
    @Column(name = "isFile")
    private Boolean isFile;
    @Size(max = 255)
    @Column(name = "fileUrl")
    private String fileUrl;
    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @JoinColumn(name = "fromUserId", referencedColumnName = "id")
    @ManyToOne
    private UserTB fromUserId;
    @JoinColumn(name = "toUserId", referencedColumnName = "id")
    @ManyToOne
    private UserTB toUserId;
    @JoinColumn(name = "groupId", referencedColumnName = "id")
    @ManyToOne
    private GroupChatTB groupId;

    public MessageTB() {
    }

    public MessageTB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Boolean getIsFile() {
        return isFile;
    }

    public void setIsFile(Boolean isFile) {
        this.isFile = isFile;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserTB getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(UserTB fromUserId) {
        this.fromUserId = fromUserId;
    }

    public UserTB getToUserId() {
        return toUserId;
    }

    public void setToUserId(UserTB toUserId) {
        this.toUserId = toUserId;
    }

    public GroupChatTB getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupChatTB groupId) {
        this.groupId = groupId;
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
        if (!(object instanceof MessageTB)) {
            return false;
        }
        MessageTB other = (MessageTB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.MessageTB[ id=" + id + " ]";
    }
    
}
