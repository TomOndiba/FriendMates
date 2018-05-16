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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "likeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LikeTB.findAll", query = "SELECT l FROM LikeTB l"),
    @NamedQuery(name = "LikeTB.findById", query = "SELECT l FROM LikeTB l WHERE l.id = :id"),
    @NamedQuery(name = "LikeTB.findByStatus", query = "SELECT l FROM LikeTB l WHERE l.status = :status"),
    @NamedQuery(name = "LikeTB.findByCreatedDate", query = "SELECT l FROM LikeTB l WHERE l.createdDate = :createdDate")})
public class LikeTB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @JoinColumn(name = "postId", referencedColumnName = "id")
    @ManyToOne
    private PostTB postId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private UserTB userId;

    public LikeTB() {
    }

    public LikeTB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public PostTB getPostId() {
        return postId;
    }

    public void setPostId(PostTB postId) {
        this.postId = postId;
    }

    public UserTB getUserId() {
        return userId;
    }

    public void setUserId(UserTB userId) {
        this.userId = userId;
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
        if (!(object instanceof LikeTB)) {
            return false;
        }
        LikeTB other = (LikeTB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.LikeTB[ id=" + id + " ]";
    }
    
}
