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
@Table(name = "postTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostTB.findAll", query = "SELECT p FROM PostTB p"),
    @NamedQuery(name = "PostTB.findById", query = "SELECT p FROM PostTB p WHERE p.id = :id"),
    @NamedQuery(name = "PostTB.findByHeading", query = "SELECT p FROM PostTB p WHERE p.heading = :heading"),
    @NamedQuery(name = "PostTB.findByDescription", query = "SELECT p FROM PostTB p WHERE p.description = :description"),
    @NamedQuery(name = "PostTB.findByIsImage", query = "SELECT p FROM PostTB p WHERE p.isImage = :isImage"),
    @NamedQuery(name = "PostTB.findByImageUrl", query = "SELECT p FROM PostTB p WHERE p.imageUrl = :imageUrl"),
    @NamedQuery(name = "PostTB.findByIsVideo", query = "SELECT p FROM PostTB p WHERE p.isVideo = :isVideo"),
    @NamedQuery(name = "PostTB.findByVideoUrl", query = "SELECT p FROM PostTB p WHERE p.videoUrl = :videoUrl"),
    @NamedQuery(name = "PostTB.findByLocation", query = "SELECT p FROM PostTB p WHERE p.location = :location"),
    @NamedQuery(name = "PostTB.findByCreatedDate", query = "SELECT p FROM PostTB p WHERE p.createdDate = :createdDate")})
public class PostTB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "heading")
    private String heading;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "isImage")
    private Boolean isImage;
    @Size(max = 255)
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "isVideo")
    private Boolean isVideo;
    @Size(max = 255)
    @Column(name = "videoUrl")
    private String videoUrl;
    @Size(max = 255)
    @Column(name = "location")
    private String location;
    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @OneToMany(mappedBy = "postId")
    private Collection<LikeTB> likeTBCollection;
    @OneToMany(mappedBy = "postId")
    private Collection<CommentsTB> commentsTBCollection;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private UserTB userId;

    public PostTB() {
    }

    public PostTB(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsImage() {
        return isImage;
    }

    public void setIsImage(Boolean isImage) {
        this.isImage = isImage;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(Boolean isVideo) {
        this.isVideo = isVideo;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Collection<LikeTB> getLikeTBCollection() {
        return likeTBCollection;
    }

    public void setLikeTBCollection(Collection<LikeTB> likeTBCollection) {
        this.likeTBCollection = likeTBCollection;
    }

    @XmlTransient
    public Collection<CommentsTB> getCommentsTBCollection() {
        return commentsTBCollection;
    }

    public void setCommentsTBCollection(Collection<CommentsTB> commentsTBCollection) {
        this.commentsTBCollection = commentsTBCollection;
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
        if (!(object instanceof PostTB)) {
            return false;
        }
        PostTB other = (PostTB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.PostTB[ id=" + id + " ]";
    }
    
}
