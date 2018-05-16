/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "groupTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupTB.findAll", query = "SELECT g FROM GroupTB g"),
    @NamedQuery(name = "GroupTB.findByEmailId", query = "SELECT g FROM GroupTB g WHERE g.groupTBPK.emailId = :emailId"),
    @NamedQuery(name = "GroupTB.findByGroupName", query = "SELECT g FROM GroupTB g WHERE g.groupTBPK.groupName = :groupName")})
public class GroupTB implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GroupTBPK groupTBPK;
    @JoinColumn(name = "emailId", referencedColumnName = "emailId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserTB userTB;

    public GroupTB() {
    }

    public GroupTB(GroupTBPK groupTBPK) {
        this.groupTBPK = groupTBPK;
    }

    public GroupTB(String emailId, String groupName) {
        this.groupTBPK = new GroupTBPK(emailId, groupName);
    }

    public GroupTBPK getGroupTBPK() {
        return groupTBPK;
    }

    public void setGroupTBPK(GroupTBPK groupTBPK) {
        this.groupTBPK = groupTBPK;
    }

    public UserTB getUserTB() {
        return userTB;
    }

    public void setUserTB(UserTB userTB) {
        this.userTB = userTB;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupTBPK != null ? groupTBPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupTB)) {
            return false;
        }
        GroupTB other = (GroupTB) object;
        if ((this.groupTBPK == null && other.groupTBPK != null) || (this.groupTBPK != null && !this.groupTBPK.equals(other.groupTBPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.GroupTB[ groupTBPK=" + groupTBPK + " ]";
    }
    
}
