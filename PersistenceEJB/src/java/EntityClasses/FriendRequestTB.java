/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
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
    @NamedQuery(name = "FriendRequestTB.findByFromUserId", query = "SELECT f FROM FriendRequestTB f WHERE f.fromUserId.id = :userId"),
    @NamedQuery(name = "FriendRequestTB.findByToUserId", query = "SELECT f FROM FriendRequestTB f WHERE f.toUserId.id = :userId"),
    @NamedQuery(name = "FriendRequestTB.findByToUserIdAndFromUserId", query = "SELECT f FROM FriendRequestTB f WHERE f.toUserId.id = :touserId AND f.fromUserId.id = :fromuserId")})
public class FriendRequestTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
