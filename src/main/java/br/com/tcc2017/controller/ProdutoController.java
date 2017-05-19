/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.controller;

import br.com.tcc2017.dao.GrupoProdutoDao;
import br.com.tcc2017.dao.ProdutoDao;
import br.com.tcc2017.model.GrupoProduto;
import br.com.tcc2017.model.Produto;
import br.com.tcc2017.util.Redirect;
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
public class ProdutoController implements Serializable {
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-VARIABLES=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    //--------------------------------EJB---------------------------------------
    /**
     * Persistence class of Pessoa
     */
    @EJB
    private ProdutoDao produtoDao;
    @EJB
    private GrupoProdutoDao grupoProdutoDao;

    //-------------------------------Entity-------------------------------------
    /**
     * Pessoa instance
     */
    private Produto produto = new Produto();

    //--------------------------------List--------------------------------------
    private List<Produto> produtos = new ArrayList<>();

    //--------------------------------Util--------------------------------------
    private final Redirect redirect = new Redirect();
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=METHODS=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

    //--------------------------------CRUD--------------------------------------
    /**
     * Save a Pessoa on database
     */
    public void save() {
        produtoDao.save(produto);
        read();
        redirect.goTo("produto/list.xhtml");
    }

    /**
     * Creates a new Pessoa instance
     */
    public void create() {
        produto = new Produto();
        produto.setStatuspro(true);
        produto.setImprimepro(true);
        redirect.goTo("produto/edit.xhtml");
    }

    /**
     * Retrieve a list of pessoas
     */
    public void read() {
        produtos = produtoDao.filter(null, new String[]{"id"}, null);
    }

    /**
     * Retrieves a Pessoa for edit
     *
     * @param produto
     */
    public void edit(Produto produto) {
        this.produto = produto;
        redirect.goTo("produto/edit.xhtml");
    }

    /**
     * Retrieves a Pessoa for remove
     *
     * @param produto
     */
    public void remove(Produto produto) {
        produtoDao.remove(produto);
        read();
    }

    /**
     * Cancel and clear the Pessoa instance
     */
    public void cancel() {
        produto = null;
        redirect.goTo("produto/list.xhtml");
    }

    //------------------------------Business------------------------------------
    public void changeStatus(Produto produto) {
        produto.setStatuspro(!produto.getStatuspro());
        produtoDao.save(produto);
        read();
    }

    public void open() {
        read();
        redirect.goTo("produto/list.xhtml");
    }
    
    public List<GrupoProduto> getGrupoProdutos(){
        return grupoProdutoDao.filter(new String[]{"statusgrupo = 'true'"}, new String[]{"descgrupo"}, null);
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=GETTERS & SETTERS=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    //-------------------------------Entity-------------------------------------

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    //--------------------------------List--------------------------------------
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    //------------------------------Atributes-----------------------------------
}
