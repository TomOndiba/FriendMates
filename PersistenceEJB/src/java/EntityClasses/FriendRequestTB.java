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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "friendRequestTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FriendRequestTB.findAll", query = "SELECT f FROM FriendRequestTB f"),
    @NamedQuery(name = "FriendRequestTB.findById", query = "SELECT f FROM FriendRequestTB f WHERE f.id = :id"),
    @NamedQuery(name = "FriendRequestTB.findByStatus", query = "SELECT f FROM FriendRequestTB f WHERE f.status = :status"),
    @NamedQuery(name = "FriendRequestTB.findByCreatedDate", query = "SELECT f FROM FriendRequestTB f WHERE f.createdDate = :createdDate")})
public class FriendRequestTB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @JoinColumn(name = "fromUserId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserTB fromUserId;
    @JoinColumn(name = "toUserId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserTB toUserId;

    public FriendRequestTB() {
    }

    public FriendRequestTB(Integer id) {
        this.id = id;
    }

    public FriendRequestTB(Integer id, int status, Date createdDate) {
        this.id = id;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendRequestTB)) {
            return false;
        }
        FriendRequestTB other = (FriendRequestTB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.FriendRequestTB[ id=" + id + " ]";
    }
    
}
