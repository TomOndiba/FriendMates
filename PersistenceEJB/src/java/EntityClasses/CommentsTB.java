/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "commentsTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommentsTB.findAll", query = "SELECT c FROM CommentsTB c"),
    @NamedQuery(name = "CommentsTB.findById", query = "SELECT c FROM CommentsTB c WHERE c.id = :id"),
    @NamedQuery(name = "CommentsTB.findByComment", query = "SELECT c FROM CommentsTB c WHERE c.comment = :comment")})
public class CommentsTB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "postId", referencedColumnName = "id")
    @ManyToOne
    private PostTB postId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private UserTB userId;
    @OneToMany(mappedBy = "parentCommentId")
    private Collection<CommentsTB> commentsTBCollection;
    @JoinColumn(name = "parentCommentId", referencedColumnName = "id")
    @ManyToOne
    private CommentsTB parentCommentId;

    public CommentsTB() {
    }

    public CommentsTB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    @XmlTransient
    public Collection<CommentsTB> getCommentsTBCollection() {
        return commentsTBCollection;
    }

    public void setCommentsTBCollection(Collection<CommentsTB> commentsTBCollection) {
        this.commentsTBCollection = commentsTBCollection;
    }

    public CommentsTB getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(CommentsTB parentCommentId) {
        this.parentCommentId = parentCommentId;
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
        if (!(object instanceof CommentsTB)) {
            return false;
        }
        CommentsTB other = (CommentsTB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.CommentsTB[ id=" + id + " ]";
    }
    
}
