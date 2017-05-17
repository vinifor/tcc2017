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
@Table(name = "ProGruIng")
public class ProGruIng implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "GrupoIng_Id", referencedColumnName = "Id")
    @ManyToOne
    private GrupoIng grupoIngId;
    @JoinColumn(name = "Produto_Id", referencedColumnName = "Id")
    @ManyToOne
    private Produto produtoId;

    public ProGruIng() {
    }

    public ProGruIng(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GrupoIng getGrupoIngId() {
        return grupoIngId;
    }

    public void setGrupoIngId(GrupoIng grupoIngId) {
        this.grupoIngId = grupoIngId;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProGruIng)) {
            return false;
        }
        ProGruIng other = (ProGruIng) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProGruIng{" + "id=" + id + ", grupoIngId=" + grupoIngId + ", produtoId=" + produtoId + '}';
    }
    
}
