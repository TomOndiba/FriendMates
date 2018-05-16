/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.CommentsBeanLocal;
import Bean.LikeBeanLocal;
import Bean.MessageBeanLocal;
import Bean.PostBeanLocal;
import Beans.GroupChatBeanLocal;
import Beans.GroupChatXUserBeanLocal;
import Beans.UserBean;
import Beans.UserBeanLocal;
import EntityClasses.GroupChatTB;
import EntityClasses.LikeTB;
import EntityClasses.PostTB;
import EntityClasses.UserTB;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

/**
 *
 * @author root
 */
public class TestServlet extends HttpServlet {

    @EJB
    UserBeanLocal ubl;
    @EJB
    GroupChatBeanLocal gcbl;
    @EJB
    LikeBeanLocal lbl;
    @EJB
    PostBeanLocal pbl;
    @EJB
    MessageBeanLocal mbl;
    @EJB
    GroupChatXUserBeanLocal gcxubl;
    @EJB
    CommentsBeanLocal cmbl;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");

            lbl.getAllLikes(2, 1);
            //cmbl.updateComment(2, 1, 2, null, "None of your business");
            //lbl.getAllLikes(2, 1);
//            out.println("<h2>UserTB</h2>");
//            out.println("<hr>");
//            
//            //Date date = Date.valueOf("1997-02-22");
//            //ubl.insertUser("Mansi", "Modi", new BigInteger("9428923522"), "mansimmodi22@gmail.com", "Password" , date , "Female", new java.util.Date());
//            //ubl.updateUser(1,"Harsh", "Jariwala", new BigInteger("9924324178"), "hjariwala130896@gmail.com", "Smarty" , date , "Male");
//            //ubl.deleteUser(4);
//            List<UserTB> users = ubl.getAllUsers();
//
//            out.println("<table border=1>");
//            out.println("<tr>");
//            out.println("<th>Sr. No.</th>");
//            out.println("<th>First Name</th>");
//            out.println("<th>Last Name</th>");
//            out.println("<th>Mobile No.</th>");
//            out.println("<th>E-mail ID</th>");
//            out.println("<th>Date of Birth</th>");
//            out.println("<th>Gender</th>");
//            out.println("</tr>");
//
//            int i = 1;
//            for (UserTB user : users) {
//
//                SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
//
//                String dob = dtf.format(user.getDob());
//
//                out.println("<tr>");
//                out.println("<td>" + i++ + "</td>");
//                out.println("<td>" + user.getFName() + "</td>");
//                out.println("<td>" + user.getLName() + "</td>");
//                out.println("<td>" + user.getMobileNo() + "</td>");
//                out.println("<td>" + user.getEmailId() + "</td>");
//                out.println("<td>" + dob + "</td>");
//                out.println("<td>" + user.getGender() + "</td>");
//                out.println("</tr>");
//            }
//            out.println("</table>");
//            out.println("<hr>");
//
////         ================================================================
//            out.println("<h2>GroupChatTB</h2>");
//            out.println("<hr>");
//
//            //gcbl.insertGroupChat(2, "Friends", new java.util.Date());
//            //gcbl.updateGroupChat(1, 1, "UnStoppable");
//            //gcbl.deleteGroupChat(2);
//            List<UserTB> groupChatUsers = ubl.getAllUsers();
//
//            out.println("<table border=1>");
//            out.println("<tr>");
//            out.println("<th>Sr. No.</th>");
//            out.println("<th>Created By</th>");
//            out.println("<th>Name</th>");
//            out.println("</tr>");
//
//            int j = 1;
//            for (UserTB groupChatUser : groupChatUsers) {
//
//                List<GroupChatTB> groupChats = gcbl.getAllGroupChat(groupChatUser.getId());
//                out.println("<tr>");
//                if (!groupChats.isEmpty()) {
//                    out.println("<td rowspan='" + groupChats.size() + "'>" + j++ + "</td>");
//                    out.println("<td rowspan='" + groupChats.size() + "'>" + groupChatUser.getFName() + " " + groupChatUser.getLName() + "</td>");
//
//                    for (GroupChatTB groupChat : groupChats) {
//                        out.println("<td>" + groupChat.getName() + "</td>");
//                        out.println("</tr>");
//                    }
//                } else {
//                    out.println("<td>" + j++ + "</td>");
//                    out.println("<td>" + groupChatUser.getFName() + " " + groupChatUser.getLName() + "</td>");
//                    out.println("<td>Not Created Any Group Chat</td></tr>");
//                }
//            }
//            out.println("</table>");
//            out.println("<hr>");
////         ================================================================
//            
//            out.println("<h2>PostTB</h2>");
//            out.println("<hr>");
//
//            //pbl.insertPost("Demo3", "DemoDesc3", false, null, false, null, 5, "Bharuch", new java.util.Date());
//            //pbl.updatePost(3,"Demo2", "DemoDescription2", false, null , false, null, 5, "Surat");
//            //pbl.deletePost(5);
//            List<UserTB> postUsers = ubl.getAllUsers();
//
//            out.println("<table border=1>");
//            out.println("<tr>");
//            out.println("<th>Sr. No.</th>");
//            out.println("<th>User Name</th>");
//            out.println("<th>Heading</th>");
//            out.println("<th>Description</th>");
//            out.println("<th>IsImage</th>");
//            out.println("<th>ImageUrl</th>");
//            out.println("<th>IsVideo</th>");
//            out.println("<th>VideoUrl</th>");
//            out.println("<th>Location</th>");
//            out.println("</tr>");
//
//            int k = 1;
//            for (UserTB postUser : postUsers) {
//
//                List<PostTB> posts = pbl.getAllPosts(postUser.getId());
//                out.println("<tr>");
//                if (!posts.isEmpty()) {
//                    out.println("<td rowspan='" + posts.size() + "'>" + k++ + "</td>");
//                    out.println("<td rowspan='" + posts.size() + "'>" + postUser.getFName() + " " + postUser.getLName() + "</td>");
//
//                    for (PostTB post : posts) {
//                        out.println("<td>" + post.getHeading()+ "</td>");
//                        out.println("<td>" + post.getDescription()+ "</td>");
//                        out.println("<td>" + post.getIsImage()+ "</td>");
//                        out.println("<td>" + post.getImageUrl()+ "</td>");
//                        out.println("<td>" + post.getIsVideo()+ "</td>");
//                        out.println("<td>" + post.getVideoUrl()+ "</td>");
//                        out.println("<td>" + post.getLocation()+ "</td>");
//                       
//                        out.println("</tr>");
//                    }
//                } else {
//                    out.println("<td>" + k++ + "</td>");
//                    out.println("<td>" + postUser.getFName() + " " + postUser.getLName() + "</td>");
//                    out.println("<td align='center' colspan='7'>No Post Yet</td></tr>");
//                }
//            }
//            out.println("</table>");
//            out.println("<hr>");
////         ================================================================
//            
//            out.println("<h2>LikeTB</h2>");
//            out.println("<hr>");
//            
//            lbl.insertLike(1, 2, true, new java.util.Date());
//            //lbl.updateLike(1, false, 1, 2);
//            //lbl.deleteLike(2);
//            
//            out.println("Insert, Update and Delete Done.");
//                out.println("<hr>");
////         ================================================================   
//            out.println("<h2>MessageTB</h2>");
//            out.println("<hr>");
//            
//            DateFormat df=new SimpleDateFormat("HH:mm:ss");
//            String time=df.format(new java.util.Date());
//            Date msgTime=null;
//
//            try
//            {
//                msgTime = df.parse(time);
//                
//            }catch(Exception e)
//            {
//                System.out.println(e.getMessage());
//            }
//            
//            //mbl.insertMessage(1, 2, 1, msgTime, "Hiiii", false, null, new java.util.Date());
//            
//            out.println("Insert Done");
////         ================================================================   
//            
//            out.println("<h2>GroupChatXUserTB</h2>");
//            out.println("<hr>");
//            
//            //gcxubl.insertUserToGroup(3, 1);
//            //gcxubl.deleteUserFromGroup(1, 2);
//            
//            out.println("Insert and Delete Done.");
//            out.println("<hr>");
////         ================================================================   
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
