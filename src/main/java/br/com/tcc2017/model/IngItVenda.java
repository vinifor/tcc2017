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
@Table(name = "IngItVenda")
public class IngItVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "Ingrediente_Id", referencedColumnName = "Id")
    @ManyToOne
    private Ingrediente ingredienteId;
    @JoinColumn(name = "ItemVenda_Id", referencedColumnName = "Id")
    @ManyToOne
    private ItemVenda itemVendaId;

    public IngItVenda() {
    }

    public IngItVenda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ingrediente getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(Ingrediente ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    public ItemVenda getItemVendaId() {
        return itemVendaId;
    }

    public void setItemVendaId(ItemVenda itemVendaId) {
        this.itemVendaId = itemVendaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IngItVenda)) {
            return false;
        }
        IngItVenda other = (IngItVenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IngItVenda{" + "id=" + id + ", ingredienteId=" + ingredienteId + ", itemVendaId=" + itemVendaId + '}';
    }
    
}
