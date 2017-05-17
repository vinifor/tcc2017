/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "Produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nomepro")
    private String nomepro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precopro")
    private BigDecimal precopro;
    @Column(name = "imprimepro")
    private Boolean imprimepro;
    @Column(name = "statuspro")
    private Boolean statuspro;
    @OneToMany(mappedBy = "produtoId", cascade = CascadeType.ALL)
    private List<ProGruObs> proGruObsList;
    @OneToMany(mappedBy = "produtoId", cascade = CascadeType.ALL)
    private List<ItemVenda> itemVendaList;
    @OneToMany(mappedBy = "produtoId", cascade = CascadeType.ALL)
    private List<ProGruIng> proGruIngList;
    @JoinColumn(name = "GrupoProduto_Id", referencedColumnName = "Id")
    @ManyToOne
    private GrupoProduto grupoProdutoId;

    public Produto() {
    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomepro() {
        return nomepro;
    }

    public void setNomepro(String nomepro) {
        this.nomepro = nomepro;
    }

    public BigDecimal getPrecopro() {
        return precopro;
    }

    public void setPrecopro(BigDecimal precopro) {
        this.precopro = precopro;
    }

    public Boolean getImprimepro() {
        return imprimepro;
    }

    public void setImprimepro(Boolean imprimepro) {
        this.imprimepro = imprimepro;
    }

    public Boolean getStatuspro() {
        return statuspro;
    }

    public void setStatuspro(Boolean statuspro) {
        this.statuspro = statuspro;
    }

    @JsonIgnore
    public List<ProGruObs> getProGruObsList() {
        return proGruObsList;
    }

    public void setProGruObsList(List<ProGruObs> proGruObsList) {
        this.proGruObsList = proGruObsList;
    }

    @JsonIgnore
    public List<ItemVenda> getItemVendaList() {
        return itemVendaList;
    }

    public void setItemVendaList(List<ItemVenda> itemVendaList) {
        this.itemVendaList = itemVendaList;
    }

    @JsonIgnore
    public List<ProGruIng> getProGruIngList() {
        return proGruIngList;
    }

    public void setProGruIngList(List<ProGruIng> proGruIngList) {
        this.proGruIngList = proGruIngList;
    }

    public GrupoProduto getGrupoProdutoId() {
        return grupoProdutoId;
    }

    public void setGrupoProdutoId(GrupoProduto grupoProdutoId) {
        this.grupoProdutoId = grupoProdutoId;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc2017.model.Produto[ id=" + id + " ]";
    }
    
}
