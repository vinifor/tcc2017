/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.controller;

import br.com.tcc2017.dao.GrupoIngDao;
import br.com.tcc2017.dao.IngredienteDao;
import br.com.tcc2017.model.GrupoIng;
import br.com.tcc2017.model.Ingrediente;
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
public class IngredienteController implements Serializable {
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-VARIABLES=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    //--------------------------------EJB---------------------------------------
    /**
     * Persistence class of Pessoa
     */
    @EJB
    private IngredienteDao ingredienteDao;
    @EJB
    private GrupoIngDao grupoIngDao;

    //-------------------------------Entity-------------------------------------
    /**
     * Pessoa instance
     */
    private Ingrediente ingrediente = new Ingrediente();

    //--------------------------------List--------------------------------------
    private List<Ingrediente> ingredientes = new ArrayList<>();

    //--------------------------------Util--------------------------------------
    private final Redirect redirect = new Redirect();
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=METHODS=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

    //--------------------------------CRUD--------------------------------------
    /**
     * Save a Pessoa on database
     */
    public void save() {
        ingredienteDao.save(ingrediente);
        read();
        redirect.goTo("ingrediente/list.xhtml");
    }

    /**
     * Creates a new Pessoa instance
     */
    public void create() {
        ingrediente = new Ingrediente();
        ingrediente.setStatusing(true);
        redirect.goTo("ingrediente/edit.xhtml");
    }

    /**
     * Retrieve a list of pessoas
     */
    public void read() {
        ingredientes = ingredienteDao.filter(null, new String[]{"id"}, null);
    }

    /**
     * Retrieves a Pessoa for edit
     *
     * @param ingrediente
     */
    public void edit(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
        redirect.goTo("ingrediente/edit.xhtml");
    }

    /**
     * Retrieves a Pessoa for remove
     *
     * @param ingrediente
     */
    public void remove(Ingrediente ingrediente) {
        ingredienteDao.remove(ingrediente);
        read();
    }

    /**
     * Cancel and clear the Pessoa instance
     */
    public void cancel() {
        ingrediente = null;
        redirect.goTo("ingrediente/list.xhtml");
    }

    //------------------------------Business------------------------------------
    public void changeStatus(Ingrediente ingrediente) {
        ingrediente.setStatusing(!ingrediente.getStatusing());
        ingredienteDao.save(ingrediente);
        read();
    }

    public void open() {
        read();
        redirect.goTo("ingrediente/list.xhtml");
    }
    
    public List<GrupoIng> getGrupoIngs(){
        return grupoIngDao.filter(new String[]{"statusgruing = 'true'"}, new String[]{"descgruing"}, null);
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=GETTERS & SETTERS=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    //-------------------------------Entity-------------------------------------

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    //--------------------------------List--------------------------------------
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    //------------------------------Atributes-----------------------------------
}
