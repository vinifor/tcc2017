/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "GrupoIng")
public class GrupoIng implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 50)
    @Column(name = "descgruing")
    private String descgruing;
    @Column(name = "statusgruing")
    private Boolean statusgruing;
    @OneToMany(mappedBy = "grupoIngId", cascade = CascadeType.ALL)
    private List<ProGruIng> proGruIngList;
    @OneToMany(mappedBy = "grupoIngId", cascade = CascadeType.ALL)
    private List<Ingrediente> ingredienteList;

    public GrupoIng() {
    }

    public GrupoIng(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescgruing() {
        return descgruing;
    }

    public void setDescgruing(String descgruing) {
        this.descgruing = descgruing;
    }

    public Boolean getStatusgruing() {
        return statusgruing;
    }

    public void setStatusgruing(Boolean statusgruing) {
        this.statusgruing = statusgruing;
    }

    @JsonIgnore
    public List<ProGruIng> getProGruIngList() {
        return proGruIngList;
    }

    public void setProGruIngList(List<ProGruIng> proGruIngList) {
        this.proGruIngList = proGruIngList;
    }

    @JsonIgnore
    public List<Ingrediente> getIngredienteList() {
        return ingredienteList;
    }

    public void setIngredienteList(List<Ingrediente> ingredienteList) {
        this.ingredienteList = ingredienteList;
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
        if (!(object instanceof GrupoIng)) {
            return false;
        }
        GrupoIng other = (GrupoIng) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GrupoIng{" + "id=" + id + ", descgruing=" + descgruing + ", statusgruing=" + statusgruing + '}';
    }
    
}
