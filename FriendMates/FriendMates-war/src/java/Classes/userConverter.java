/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Beans.UserBeanLocal;
import EntityClasses.UserTB;
import ManagedBeans.UserManagedBean;
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
                // UserManagedBean uben=(UserManagedBean)context.getExternalContext().getApplicationMap().get("userManagedBean");
                return ubean.getAllUsers().get(Integer.parseInt(value));

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
            
            return String.valueOf(((UserTB)value).getId());
            //return ((UserTB) value).getId().toString();
        } else {
            return null;
        }
    }

}
