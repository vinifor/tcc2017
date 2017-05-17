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
@Table(name = "ParcelaReceber")
public class ParcelaReceber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "dataparrec")
    @Temporal(TemporalType.DATE)
    private Date dataparrec;
    @Column(name = "juroparrec")
    private BigDecimal juroparrec;
    @Column(name = "descontoparrec")
    private BigDecimal descontoparrec;
    @Column(name = "multaparrec")
    private BigDecimal multaparrec;
    @Column(name = "valorparrec")
    private BigDecimal valorparrec;
    @JoinColumn(name = "ContaReceber_Id", referencedColumnName = "Id")
    @ManyToOne
    private ContaReceber contaReceberId;
    @OneToMany(mappedBy = "parcelaReceberId", cascade = CascadeType.ALL)
    private List<Recebimento> recebimentoList;

    public ParcelaReceber() {
    }

    public ParcelaReceber(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataparrec() {
        return dataparrec;
    }

    public void setDataparrec(Date dataparrec) {
        this.dataparrec = dataparrec;
    }

    public BigDecimal getJuroparrec() {
        return juroparrec;
    }

    public void setJuroparrec(BigDecimal juroparrec) {
        this.juroparrec = juroparrec;
    }

    public BigDecimal getDescontoparrec() {
        return descontoparrec;
    }

    public void setDescontoparrec(BigDecimal descontoparrec) {
        this.descontoparrec = descontoparrec;
    }

    public BigDecimal getMultaparrec() {
        return multaparrec;
    }

    public void setMultaparrec(BigDecimal multaparrec) {
        this.multaparrec = multaparrec;
    }

    public BigDecimal getValorparrec() {
        return valorparrec;
    }

    public void setValorparrec(BigDecimal valorparrec) {
        this.valorparrec = valorparrec;
    }

    public ContaReceber getContaReceberId() {
        return contaReceberId;
    }

    public void setContaReceberId(ContaReceber contaReceberId) {
        this.contaReceberId = contaReceberId;
    }

    @JsonIgnore
    public List<Recebimento> getRecebimentoList() {
        return recebimentoList;
    }

    public void setRecebimentoList(List<Recebimento> recebimentoList) {
        this.recebimentoList = recebimentoList;
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
        if (!(object instanceof ParcelaReceber)) {
            return false;
        }
        ParcelaReceber other = (ParcelaReceber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ParcelaReceber{" + "id=" + id + ", dataparrec=" + dataparrec + ", juroparrec=" + juroparrec + ", descontoparrec=" + descontoparrec + ", multaparrec=" + multaparrec + ", valorparrec=" + valorparrec + ", contaReceberId=" + contaReceberId + '}';
    }
    
}
