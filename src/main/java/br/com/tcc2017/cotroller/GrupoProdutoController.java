/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.cotroller;

import br.com.tcc2017.dao.GrupoProdutoDao;
import br.com.tcc2017.model.GrupoProduto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 * @author Vinicius
 */
@ManagedBean
@SessionScoped
public class GrupoProdutoController implements Serializable {
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-VARIABLES=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    //--------------------------------EJB---------------------------------------
    /**
     * Persistence class of Pessoa
     */
    @EJB
    private GrupoProdutoDao grupoProdutoDao;

    //-------------------------------Entity-------------------------------------
    /**
     * Pessoa instance
     */
    private GrupoProduto grupoProduto = new GrupoProduto();

    //--------------------------------List--------------------------------------
    private List<GrupoProduto> grupoProdutos = new ArrayList<>();
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=METHODS=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

    //--------------------------------CRUD--------------------------------------
    /**
     * Save a Pessoa on database
     */
    public void save() {
        grupoProdutoDao.save(grupoProduto);
        read();
    }

    /**
     * Creates a new Pessoa instance
     */
    public void create() {
        grupoProduto = new GrupoProduto();
        grupoProduto.setStatusgrupo(true);
    }

    /**
     * Retrieve a list of pessoas
     */
    public void read() {
        grupoProdutos = grupoProdutoDao.filter(null, new String[]{"id"}, null);
    }

    /**
     * Retrieves a Pessoa for edit
     *
     * @param grupoProduto
     */
    public void edit(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    /**
     * Retrieves a Pessoa for remove
     *
     * @param actionEvent ActionEvent: Event from the view
     */
    public void remove(ActionEvent actionEvent) {
        grupoProduto = (GrupoProduto) actionEvent.getComponent().getAttributes().get("grupoProduto");
        grupoProdutoDao.remove(grupoProduto);
        read();
    }

    /**
     * Cancel and clear the Pessoa instance
     */
    public void cancel() {
        grupoProduto = null;
    }

    public void changeStatus(ActionEvent actionEvent) {
        grupoProduto = (GrupoProduto) actionEvent.getComponent().getAttributes().get("grupoProduto");
        grupoProduto.setStatusgrupo(!grupoProduto.getStatusgrupo());
        save();
    }

    //------------------------------Business------------------------------------
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=GETTERS & SETTERS=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    //-------------------------------Entity-------------------------------------
    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    //--------------------------------List--------------------------------------
    public List<GrupoProduto> getGrupoProdutos() {
        return grupoProdutos;
    }

    public void setGrupoProdutos(List<GrupoProduto> grupoProdutos) {
        this.grupoProdutos = grupoProdutos;
    }

    //------------------------------Atributes-----------------------------------
}
