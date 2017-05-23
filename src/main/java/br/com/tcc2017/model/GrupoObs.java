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
@Table(name = "GrupoObs")
public class GrupoObs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 50)
    @Column(name = "descgruobs")
    private String descgruobs;
    @Column(name = "statusgruobs")
    private Boolean statusgruobs;
    @OneToMany(mappedBy = "grupoObsId", cascade = CascadeType.ALL)
    private List<ProGruObs> proGruObsList;
    @OneToMany(mappedBy = "grupoObsId", cascade = CascadeType.ALL)
    private List<Observacao> observacaoList;

    public GrupoObs() {
    }

    public GrupoObs(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescgruobs() {
        return descgruobs;
    }

    public void setDescgruobs(String descgruobs) {
        this.descgruobs = descgruobs;
    }

    public Boolean getStatusgruobs() {
        return statusgruobs;
    }

    public void setStatusgruobs(Boolean statusgruobs) {
        this.statusgruobs = statusgruobs;
    }

    @JsonIgnore
    public List<ProGruObs> getProGruObsList() {
        return proGruObsList;
    }

    public void setProGruObsList(List<ProGruObs> proGruObsList) {
        this.proGruObsList = proGruObsList;
    }

    @JsonIgnore
    public List<Observacao> getObservacaoList() {
        return observacaoList;
    }

    public void setObservacaoList(List<Observacao> observacaoList) {
        this.observacaoList = observacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GrupoObs)) {
            return false;
        }
        GrupoObs other = (GrupoObs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GrupoObs{" + "id=" + id + ", descgruobs=" + descgruobs + ", statusgruobs=" + statusgruobs + '}';
    }
    
}
