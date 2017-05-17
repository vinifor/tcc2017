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
@Table(name = "Mesas")
public class Mesas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 20)
    @Column(name = "descmesa")
    private String descmesa;
    @Column(name = "statusmesa")
    private Integer statusmesa;
    @OneToMany(mappedBy = "mesasId", cascade = CascadeType.ALL)
    private List<Venda> vendaList;

    public Mesas() {
    }

    public Mesas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescmesa() {
        return descmesa;
    }

    public void setDescmesa(String descmesa) {
        this.descmesa = descmesa;
    }

    public Integer getStatusmesa() {
        return statusmesa;
    }

    public void setStatusmesa(Integer statusmesa) {
        this.statusmesa = statusmesa;
    }

    @JsonIgnore
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
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
        if (!(object instanceof Mesas)) {
            return false;
        }
        Mesas other = (Mesas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mesas{" + "id=" + id + ", descmesa=" + descmesa + ", statusmesa=" + statusmesa + '}';
    }
    
}
