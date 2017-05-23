/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "ProGruObs")
public class ProGruObs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "GrupoObs_Id", referencedColumnName = "Id")
    @ManyToOne
    private GrupoObs grupoObsId;
    @JoinColumn(name = "Produto_Id", referencedColumnName = "Id")
    @ManyToOne
    private Produto produtoId;

    public ProGruObs() {
        //TODO teste de to do
    }

    public ProGruObs(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GrupoObs getGrupoObsId() {
        return grupoObsId;
    }

    public void setGrupoObsId(GrupoObs grupoObsId) {
        this.grupoObsId = grupoObsId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProGruObs)) {
            return false;
        }
        ProGruObs other = (ProGruObs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProGruObs{" + "id=" + id + ", grupoObsId=" + grupoObsId + ", produtoId=" + produtoId + '}';
    }
    
}
