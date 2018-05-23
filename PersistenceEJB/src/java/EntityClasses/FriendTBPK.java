/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class FriendTBPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "userId1")
    private int userId1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userId2")
    private int userId2;

    public FriendTBPK() {
    }

    public FriendTBPK(int userId1, int userId2) {
        this.userId1 = userId1;
        this.userId2 = userId2;
    }

    public int getUserId1() {
        return userId1;
    }

    public void setUserId1(int userId1) {
        this.userId1 = userId1;
    }

    public int getUserId2() {
        return userId2;
    }

    public void setUserId2(int userId2) {
        this.userId2 = userId2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId1;
        hash += (int) userId2;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendTBPK)) {
            return false;
        }
        FriendTBPK other = (FriendTBPK) object;
        if (this.userId1 != other.userId1) {
            return false;
        }
        if (this.userId2 != other.userId2) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.FriendTBPK[ userId1=" + userId1 + ", userId2=" + userId2 + " ]";
    }
    
}
