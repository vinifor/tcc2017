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
@Table(name = "Ingrediente")
public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "descing")
    private String descing;
    @Column(name = "statusing")
    private Boolean statusing;
    @JoinColumn(name = "GrupoIng_Id", referencedColumnName = "Id")
    @ManyToOne
    private GrupoIng grupoIngId;
    @OneToMany(mappedBy = "ingredienteId", cascade = CascadeType.ALL)
    private List<IngItVenda> ingItVendaList;

    public Ingrediente() {
    }

    public Ingrediente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescing() {
        return descing;
    }

    public void setDescing(String descing) {
        this.descing = descing;
    }

    public Boolean getStatusing() {
        return statusing;
    }

    public void setStatusing(Boolean statusing) {
        this.statusing = statusing;
    }

    public GrupoIng getGrupoIngId() {
        return grupoIngId;
    }

    public void setGrupoIngId(GrupoIng grupoIngId) {
        this.grupoIngId = grupoIngId;
    }

    @JsonIgnore
    public List<IngItVenda> getIngItVendaList() {
        return ingItVendaList;
    }

    public void setIngItVendaList(List<IngItVenda> ingItVendaList) {
        this.ingItVendaList = ingItVendaList;
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
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", descing=" + descing + ", statusing=" + statusing + ", grupoIngId=" + grupoIngId + '}';
    }
    
}
