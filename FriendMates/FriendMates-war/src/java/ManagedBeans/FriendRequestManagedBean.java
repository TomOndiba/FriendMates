/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import Beans.FriendBeanLocal;
import Beans.FriendRequestBeanLocal;
import Beans.UserBeanLocal;
import EntityClasses.FriendRequestTB;
import EntityClasses.FriendTB;
import EntityClasses.UserTB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@Named(value = "friendRequestManagedBean")
@SessionScoped
public class FriendRequestManagedBean implements Serializable {

    @EJB
    private FriendBeanLocal friendBean;

    @EJB
    private FriendRequestBeanLocal friendRequestBean;

    @EJB
    private UserBeanLocal userBean;

    Integer frienRequestId;
    Integer toUserId;
    Integer fromUserId;
    Integer countRequest;
    Boolean isRequestSent = false;
    Boolean isRequestAccepted = false;
    Boolean isRequestReceived = false;

    UserTB reqestFrom = new UserTB();

    public Integer getCountRequest() {
        return countRequest;
    }

    public Boolean getIsRequestSent() {
        return isRequestSent;
    }

    public void setIsRequestSent(Boolean isRequestSent) {
        this.isRequestSent = isRequestSent;
    }

    public void setCountRequest(Integer countRequest) {
        this.countRequest = countRequest;
    }

    public Boolean getIsRequestAccepted() {
        return isRequestAccepted;
    }

    public void setIsRequestAccepted(Boolean isRequestAccepted) {
        this.isRequestAccepted = isRequestAccepted;
    }

    public Boolean getIsRequestReceived() {
        return isRequestReceived;
    }

    public void setIsRequestReceived(Boolean isRequestReceived) {
        this.isRequestReceived = isRequestReceived;
    }

    public void sendFriendRequest(UserTB selectedUser) {

        HttpSession mainUserSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        List<UserTB> lstFromUser = userBean.getUserByEmailId(mainUserSession.getAttribute("userEmail").toString());

        for (UserTB fromUser : lstFromUser) {
            fromUserId = fromUser.getId();
        }

        toUserId = selectedUser.getId();

        friendRequestBean.sendFriendRequest(fromUserId, toUserId);
    }

    public List<FriendRequestTB> lstFriendRequests() {

        HttpSession mainUserSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        List<UserTB> lstFromUser = userBean.getUserByEmailId(mainUserSession.getAttribute("userEmail").toString());

        for (UserTB fromUser : lstFromUser) {
            toUserId = fromUser.getId();
        }

        List<FriendRequestTB> lstRequests = friendRequestBean.getAllFriendRequests(toUserId);

        countRequest = lstRequests.size();

        return lstRequests;
    }

    public void acceptFriendRequest(UserTB fromUser) {

        HttpSession mainUserSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        List<UserTB> lstToUser = userBean.getUserByEmailId(mainUserSession.getAttribute("userEmail").toString());

        for (UserTB user : lstToUser) {
            toUserId = user.getId();
        }

        fromUserId = fromUser.getId();

        List<FriendRequestTB> lstRequests = friendRequestBean.getFriendRequestsByToUserIdAndFromUserId(fromUserId, toUserId);

        for (FriendRequestTB request : lstRequests) {

            frienRequestId = request.getId();
        }

        friendRequestBean.deleteFriendRequest(frienRequestId);

        friendBean.insertFriends(fromUserId, toUserId);

        isRequestSent = false;
        isRequestAccepted = true;
        isRequestReceived = false;

    }

    public void deleteFriendRequest(UserTB fromUser) {

        HttpSession mainUserSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        List<UserTB> lstToUser = userBean.getUserByEmailId(mainUserSession.getAttribute("userEmail").toString());

        for (UserTB user : lstToUser) {
            toUserId = user.getId();
        }

        fromUserId = fromUser.getId();

        List<FriendRequestTB> lstRequests = friendRequestBean.getFriendRequestsByToUserIdAndFromUserId(fromUserId, toUserId);

        for (FriendRequestTB request : lstRequests) {

            frienRequestId = request.getId();
        }

        friendRequestBean.deleteFriendRequest(frienRequestId);
    }

    public void checkRequestStatus(UserTB selectedUser) {
        HttpSession mainUserSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        List<UserTB> lstFromUser = userBean.getUserByEmailId(mainUserSession.getAttribute("userEmail").toString());

        for (UserTB fromUser : lstFromUser) {
            fromUserId = fromUser.getId();
        }

        toUserId = selectedUser.getId();

        List<FriendTB> lstFriends = friendBean.getFriendByUser1AndUser2(fromUserId, toUserId);
        List<FriendRequestTB> lstRequestSent = new ArrayList<FriendRequestTB>();
        List<FriendRequestTB> lstRequestReceived = new ArrayList<FriendRequestTB>();

        if (lstFriends.size() == 0) {
            lstRequestSent = friendRequestBean.getFriendRequestsByToUserIdAndFromUserId(fromUserId, toUserId);
            lstRequestReceived = friendRequestBean.getFriendRequestsByToUserIdAndFromUserId(toUserId, fromUserId);
        }

        if (lstRequestSent.size() == 1) {

            isRequestSent = true;
            isRequestAccepted = false;
            isRequestReceived = false;

        } else if (lstFriends.size() == 1) {

            isRequestSent = false;
            isRequestAccepted = true;
            isRequestReceived = false;

        } else if (lstRequestReceived.size() == 1) {

            isRequestSent = false;
            isRequestAccepted = false;
            isRequestReceived = true;

        } else {

            isRequestSent = false;
            isRequestAccepted = false;
            isRequestReceived = false;

        }
    }

    public FriendRequestManagedBean() {

    }

}
