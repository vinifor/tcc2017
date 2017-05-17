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

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "Recebimento")
public class Recebimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "valorfinalrec")
    private BigDecimal valorfinalrec;
    @Column(name = "jurorec")
    private BigDecimal jurorec;
    @Column(name = "multarec")
    private BigDecimal multarec;
    @Column(name = "desconrec")
    private BigDecimal desconrec;
    @OneToMany(mappedBy = "recebimentoId", cascade = CascadeType.ALL)
    private List<MovCaixa> movCaixaList;
    @JoinColumn(name = "ContaReceber_Id", referencedColumnName = "Id")
    @ManyToOne
    private ContaReceber contaReceberId;
    @JoinColumn(name = "ParcelaReceber_Id", referencedColumnName = "Id")
    @ManyToOne
    private ParcelaReceber parcelaReceberId;

    public Recebimento() {
    }

    public Recebimento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorfinalrec() {
        return valorfinalrec;
    }

    public void setValorfinalrec(BigDecimal valorfinalrec) {
        this.valorfinalrec = valorfinalrec;
    }

    public BigDecimal getJurorec() {
        return jurorec;
    }

    public void setJurorec(BigDecimal jurorec) {
        this.jurorec = jurorec;
    }

    public BigDecimal getMultarec() {
        return multarec;
    }

    public void setMultarec(BigDecimal multarec) {
        this.multarec = multarec;
    }

    public BigDecimal getDesconrec() {
        return desconrec;
    }

    public void setDesconrec(BigDecimal desconrec) {
        this.desconrec = desconrec;
    }

    @JsonIgnore
    public List<MovCaixa> getMovCaixaList() {
        return movCaixaList;
    }

    public void setMovCaixaList(List<MovCaixa> movCaixaList) {
        this.movCaixaList = movCaixaList;
    }

    public ContaReceber getContaReceberId() {
        return contaReceberId;
    }

    public void setContaReceberId(ContaReceber contaReceberId) {
        this.contaReceberId = contaReceberId;
    }

    public ParcelaReceber getParcelaReceberId() {
        return parcelaReceberId;
    }

    public void setParcelaReceberId(ParcelaReceber parcelaReceberId) {
        this.parcelaReceberId = parcelaReceberId;
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
        if (!(object instanceof Recebimento)) {
            return false;
        }
        Recebimento other = (Recebimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recebimento{" + "id=" + id + ", valorfinalrec=" + valorfinalrec + ", jurorec=" + jurorec + ", multarec=" + multarec + ", desconrec=" + desconrec + ", contaReceberId=" + contaReceberId + ", parcelaReceberId=" + parcelaReceberId + '}';
    }
    
}
