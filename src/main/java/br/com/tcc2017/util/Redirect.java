/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author Mario Feles dos Santos Jr 19/08/2015 Projeto NFC-e
 */
@ManagedBean
@SessionScoped
public class Redirect implements Serializable {
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=AFA-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    public void home() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/TCC2017/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Redirect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goTo(String where) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/TCC2017/pages/" + where);
        } catch (IOException ex) {
            Logger.getLogger(Redirect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
