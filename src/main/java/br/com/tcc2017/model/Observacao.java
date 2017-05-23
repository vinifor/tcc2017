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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "Observacao")
public class Observacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 50)
    @Column(name = "descobs")
    private String descobs;
    @Column(name = "statusobs")
    private Boolean statusobs;
    @JoinColumn(name = "GrupoObs_Id", referencedColumnName = "Id")
    @ManyToOne
    private GrupoObs grupoObsId;
    @OneToMany(mappedBy = "observacaoId", cascade = CascadeType.ALL)
    private List<ObsItVenda> obsItVendaList;

    public Observacao() {
    }

    public Observacao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescobs() {
        return descobs;
    }

    public void setDescobs(String descobs) {
        this.descobs = descobs;
    }

    public Boolean getStatusobs() {
        return statusobs;
    }

    public void setStatusobs(Boolean statusobs) {
        this.statusobs = statusobs;
    }

    public GrupoObs getGrupoObsId() {
        return grupoObsId;
    }

    public void setGrupoObsId(GrupoObs grupoObsId) {
        this.grupoObsId = grupoObsId;
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
        if (!(object instanceof Observacao)) {
            return false;
        }
        Observacao other = (Observacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc2017.model.Observacao[ id=" + id + " ]";
    }
    
}
