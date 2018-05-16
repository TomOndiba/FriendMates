/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "groupChatTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupChatTB.findAll", query = "SELECT g FROM GroupChatTB g"),
    @NamedQuery(name = "GroupChatTB.findById", query = "SELECT g FROM GroupChatTB g WHERE g.id = :id"),
    @NamedQuery(name = "GroupChatTB.findByName", query = "SELECT g FROM GroupChatTB g WHERE g.name = :name"),
    @NamedQuery(name = "GroupChatTB.findByCreatedDate", query = "SELECT g FROM GroupChatTB g WHERE g.createdDate = :createdDate")})
public class GroupChatTB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @JoinTable(name = "groupChatXuserTB", joinColumns = {
        @JoinColumn(name = "groupChatId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "userId", referencedColumnName = "id")})
    @ManyToMany
    private Collection<UserTB> userTBCollection;
    @JoinColumn(name = "createdUserId", referencedColumnName = "id")
    @ManyToOne
    private UserTB createdUserId;
    @OneToMany(mappedBy = "groupId")
    private Collection<MessageTB> messageTBCollection;

    public GroupChatTB() {
    }

    public GroupChatTB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Collection<UserTB> getUserTBCollection() {
        return userTBCollection;
    }

    public void setUserTBCollection(Collection<UserTB> userTBCollection) {
        this.userTBCollection = userTBCollection;
    }

    public UserTB getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(UserTB createdUserId) {
        this.createdUserId = createdUserId;
    }

    @XmlTransient
    public Collection<MessageTB> getMessageTBCollection() {
        return messageTBCollection;
    }

    public void setMessageTBCollection(Collection<MessageTB> messageTBCollection) {
        this.messageTBCollection = messageTBCollection;
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
        if (!(object instanceof GroupChatTB)) {
            return false;
        }
        GroupChatTB other = (GroupChatTB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.GroupChatTB[ id=" + id + " ]";
    }
    
}
