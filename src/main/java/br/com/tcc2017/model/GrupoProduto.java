/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "GrupoProduto")
public class GrupoProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "descgrupo")
    private String descgrupo;
    @Column(name = "statusgrupo")
    private Boolean statusgrupo;
    @OneToMany(mappedBy = "grupoProdutoId", cascade = CascadeType.ALL)
    private List<Produto> produtoList;

    public GrupoProduto() {
    }

    public GrupoProduto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescgrupo() {
        return descgrupo;
    }

    public void setDescgrupo(String descgrupo) {
        this.descgrupo = descgrupo;
    }

    public Boolean getStatusgrupo() {
        return statusgrupo;
    }

    public void setStatusgrupo(Boolean statusgrupo) {
        this.statusgrupo = statusgrupo;
    }

    @JsonIgnore
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
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
        if (!(object instanceof GrupoProduto)) {
            return false;
        }
        GrupoProduto other = (GrupoProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GrupoProduto{" + "id=" + id + ", descgrupo=" + descgrupo + ", statusgrupo=" + statusgrupo + '}';
    }
    
}
