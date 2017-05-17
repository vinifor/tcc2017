/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "ItemVenda")
public class ItemVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "dataitven")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataitven;
    @Column(name = "qtditven")
    private Integer qtditven;
    @Column(name = "vlrunitven")
    private BigDecimal vlrunitven;
    @Column(name = "vlracresitven")
    private BigDecimal vlracresitven;
    @Column(name = "vlrsubtotitven")
    private BigDecimal vlrsubtotitven;
    @Column(name = "vlrtotalitven")
    private BigDecimal vlrtotalitven;
    @Column(name = "statusitven")
    private Boolean statusitven;
    @JoinColumn(name = "Produto_Id", referencedColumnName = "Id")
    @ManyToOne
    private Produto produtoId;
    @JoinColumn(name = "Venda_Id", referencedColumnName = "Id")
    @ManyToOne
    private Venda vendaId;
    @OneToMany(mappedBy = "itemVendaId", cascade = CascadeType.ALL)
    private List<IngItVenda> ingItVendaList;
    @OneToMany(mappedBy = "itemVendaId", cascade = CascadeType.ALL)
    private List<ObsItVenda> obsItVendaList;

    public ItemVenda() {
    }

    public ItemVenda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataitven() {
        return dataitven;
    }

    public void setDataitven(Date dataitven) {
        this.dataitven = dataitven;
    }

    public Integer getQtditven() {
        return qtditven;
    }

    public void setQtditven(Integer qtditven) {
        this.qtditven = qtditven;
    }

    public BigDecimal getVlrunitven() {
        return vlrunitven;
    }

    public void setVlrunitven(BigDecimal vlrunitven) {
        this.vlrunitven = vlrunitven;
    }

    public BigDecimal getVlracresitven() {
        return vlracresitven;
    }

    public void setVlracresitven(BigDecimal vlracresitven) {
        this.vlracresitven = vlracresitven;
    }

    public BigDecimal getVlrsubtotitven() {
        return vlrsubtotitven;
    }

    public void setVlrsubtotitven(BigDecimal vlrsubtotitven) {
        this.vlrsubtotitven = vlrsubtotitven;
    }

    public BigDecimal getVlrtotalitven() {
        return vlrtotalitven;
    }

    public void setVlrtotalitven(BigDecimal vlrtotalitven) {
        this.vlrtotalitven = vlrtotalitven;
    }

    public Boolean getStatusitven() {
        return statusitven;
    }

    public void setStatusitven(Boolean statusitven) {
        this.statusitven = statusitven;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    public Venda getVendaId() {
        return vendaId;
    }

    public void setVendaId(Venda vendaId) {
        this.vendaId = vendaId;
    }

    @JsonIgnore
    public List<IngItVenda> getIngItVendaList() {
        return ingItVendaList;
    }

    public void setIngItVendaList(List<IngItVenda> ingItVendaList) {
        this.ingItVendaList = ingItVendaList;
    }

    @JsonIgnore
    public List<ObsItVenda> getObsItVendaList() {
        return obsItVendaList;
    }

    public void setObsItVendaList(List<ObsItVenda> obsItVendaList) {
        this.obsItVendaList = obsItVendaList;
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
        if (!(object instanceof ItemVenda)) {
            return false;
        }
        ItemVenda other = (ItemVenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "id=" + id + ", dataitven=" + dataitven + ", qtditven=" + qtditven + ", vlrunitven=" + vlrunitven + ", vlracresitven=" + vlracresitven + ", vlrsubtotitven=" + vlrsubtotitven + ", vlrtotalitven=" + vlrtotalitven + ", statusitven=" + statusitven + ", produtoId=" + produtoId + ", vendaId=" + vendaId + '}';
    }
    
}
