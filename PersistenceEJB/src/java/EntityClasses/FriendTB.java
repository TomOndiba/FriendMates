/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "friendTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FriendTB.findAll", query = "SELECT f FROM FriendTB f"),
    @NamedQuery(name = "FriendTB.findByUserId1", query = "SELECT f FROM FriendTB f WHERE f.friendTBPK.userId1 = :userId1"),
    @NamedQuery(name = "FriendTB.findByUserId2", query = "SELECT f FROM FriendTB f WHERE f.friendTBPK.userId2 = :userId2"),
    @NamedQuery(name = "FriendTB.findByUserId1AndUserId2", query = "SELECT f FROM FriendTB f WHERE f.friendTBPK.userId1 = :userId1 AND f.friendTBPK.userId2 = :userId2"),
    @NamedQuery(name = "FriendTB.findByPriorityOrder", query = "SELECT f FROM FriendTB f WHERE f.priorityOrder = :priorityOrder")})
public class FriendTB implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FriendTBPK friendTBPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "priorityOrder")
    private long priorityOrder;
    @JoinColumn(name = "userId1", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserTB userTB;
    @JoinColumn(name = "userId2", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserTB userTB1;

    public FriendTB() {
    }

    public FriendTB(FriendTBPK friendTBPK) {
        this.friendTBPK = friendTBPK;
    }

    public FriendTB(FriendTBPK friendTBPK, long priorityOrder) {
        this.friendTBPK = friendTBPK;
        this.priorityOrder = priorityOrder;
    }

    public FriendTB(int userId1, int userId2) {
        this.friendTBPK = new FriendTBPK(userId1, userId2);
    }

    public FriendTBPK getFriendTBPK() {
        return friendTBPK;
    }

    public void setFriendTBPK(FriendTBPK friendTBPK) {
        this.friendTBPK = friendTBPK;
    }

    public long getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(long priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    public UserTB getUserTB() {
        return userTB;
    }

    public void setUserTB(UserTB userTB) {
        this.userTB = userTB;
    }

    public UserTB getUserTB1() {
        return userTB1;
    }

    public void setUserTB1(UserTB userTB1) {
        this.userTB1 = userTB1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendTBPK != null ? friendTBPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendTB)) {
            return false;
        }
        FriendTB other = (FriendTB) object;
        if ((this.friendTBPK == null && other.friendTBPK != null) || (this.friendTBPK != null && !this.friendTBPK.equals(other.friendTBPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.FriendTB[ friendTBPK=" + friendTBPK + " ]";
    }
    
}
