/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.controller;

import br.com.tcc2017.dao.GrupoIngDao;
import br.com.tcc2017.model.GrupoIng;
import br.com.tcc2017.util.Redirect;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Vinicius
 */
@ManagedBean
@SessionScoped
public class GrupoIngController implements Serializable {
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-VARIABLES=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    //--------------------------------EJB---------------------------------------
    /**
     * Persistence class of Pessoa
     */
    @EJB
    private GrupoIngDao grupoIngDao;

    //-------------------------------Entity-------------------------------------
    /**
     * Pessoa instance
     */
    private GrupoIng grupoIng = new GrupoIng();

    //--------------------------------List--------------------------------------
    private List<GrupoIng> grupoIngs = new ArrayList<>();

    //--------------------------------Util--------------------------------------
    private final Redirect redirect = new Redirect();
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=METHODS=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

    //--------------------------------CRUD--------------------------------------
    /**
     * Save a Pessoa on database
     */
    public void save() {
        grupoIngDao.save(grupoIng);
        read();
        redirect.goTo("grupoingrediente/list.xhtml");
    }

    /**
     * Creates a new Pessoa instance
     */
    public void create() {
        grupoIng = new GrupoIng();
        grupoIng.setStatusgruing(true);
        redirect.goTo("grupoingrediente/edit.xhtml");
    }

    /**
     * Retrieve a list of pessoas
     */
    public void read() {
        grupoIngs = grupoIngDao.filter(null, new String[]{"id"}, null);
    }

    /**
     * Retrieves a Pessoa for edit
     *
     * @param grupoIng
     */
    public void edit(GrupoIng grupoIng) {
        this.grupoIng = grupoIng;
        redirect.goTo("grupoingrediente/edit.xhtml");
    }

    /**
     * Retrieves a Pessoa for remove
     *
     * @param grupoIng
     */
    public void remove(GrupoIng grupoIng) {
        grupoIngDao.remove(grupoIng);
        read();
    }

    /**
     * Cancel and clear the Pessoa instance
     */
    public void cancel() {
        grupoIng = null;
        redirect.goTo("grupoingrediente/list.xhtml");
    }

    //------------------------------Business------------------------------------
    public void changeStatus(GrupoIng grupoIng) {
        grupoIng.setStatusgruing(!grupoIng.getStatusgruing());
        grupoIngDao.save(grupoIng);
        read();
    }

    public void open() {
        read();
        redirect.goTo("grupoingrediente/list.xhtml");
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=GETTERS & SETTERS=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    //-------------------------------Entity-------------------------------------

    public GrupoIng getGrupoIng() {
        return grupoIng;
    }

    public void setGrupoIng(GrupoIng grupoIng) {
        this.grupoIng = grupoIng;
    }

    //--------------------------------List--------------------------------------
    public List<GrupoIng> getGrupoIngs() {
        return grupoIngs;
    }

    public void setGrupoIngs(List<GrupoIng> grupoIngs) {
        this.grupoIngs = grupoIngs;
    }

    //------------------------------Atributes-----------------------------------
}
