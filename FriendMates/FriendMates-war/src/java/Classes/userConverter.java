/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Beans.UserBeanLocal;
import EntityClasses.UserTB;
import ManagedBeans.UserManagedBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author root
 */
@FacesConverter("userConverter")
public class userConverter implements Converter {
    
    @EJB
    private UserBeanLocal ubean;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if (value != null && value.trim().length() > 0) {
            try {
                List<UserTB> temp = ubean.getUserById(Integer.parseInt(value));
                UserTB u = new UserTB();
                for (UserTB usr : temp) {
                    u=usr;
                }

                int in = ubean.getAllUsers().indexOf(u);
                return ubean.getAllUsers().get(in);

            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid User."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {

            UserManagedBean u = new UserManagedBean();
            u.setSelected((UserTB) value);
            return String.valueOf(((UserTB) value).getId());
        } else {
            return null;
        }
    }

}
