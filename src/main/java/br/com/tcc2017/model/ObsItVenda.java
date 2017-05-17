/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "ObsItVenda")
public class ObsItVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @JoinColumn(name = "ItemVenda_Id", referencedColumnName = "Id")
    @ManyToOne
    private ItemVenda itemVendaId;
    @JoinColumn(name = "Observacao_Id", referencedColumnName = "Id")
    @ManyToOne
    private Observacao observacaoId;

    public ObsItVenda() {
    }

    public ObsItVenda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemVenda getItemVendaId() {
        return itemVendaId;
    }

    public void setItemVendaId(ItemVenda itemVendaId) {
        this.itemVendaId = itemVendaId;
    }

    public Observacao getObservacaoId() {
        return observacaoId;
    }

    public void setObservacaoId(Observacao observacaoId) {
        this.observacaoId = observacaoId;
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
        if (!(object instanceof ObsItVenda)) {
            return false;
        }
        ObsItVenda other = (ObsItVenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ObsItVenda{" + "id=" + id + ", itemVendaId=" + itemVendaId + ", observacaoId=" + observacaoId + '}';
    }
    
}
