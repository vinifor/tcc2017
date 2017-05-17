/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "MovCaixa")
public class MovCaixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "datamovcai")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datamovcai;
    @Column(name = "tipomovcai")
    private Boolean tipomovcai;
    @Column(name = "vlrmovcai")
    private BigDecimal vlrmovcai;
    @Size(max = 50)
    @Column(name = "descmovcaixa")
    private String descmovcaixa;
    @Column(name = "tiporecmovcai")
    private Integer tiporecmovcai;
    @JoinColumn(name = "Caixa_Id", referencedColumnName = "Id")
    @ManyToOne
    private Caixa caixaId;
    @JoinColumn(name = "Recebimento_Id", referencedColumnName = "Id")
    @ManyToOne
    private Recebimento recebimentoId;

    public MovCaixa() {
    }

    public MovCaixa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatamovcai() {
        return datamovcai;
    }

    public void setDatamovcai(Date datamovcai) {
        this.datamovcai = datamovcai;
    }

    public Boolean getTipomovcai() {
        return tipomovcai;
    }

    public void setTipomovcai(Boolean tipomovcai) {
        this.tipomovcai = tipomovcai;
    }

    public BigDecimal getVlrmovcai() {
        return vlrmovcai;
    }

    public void setVlrmovcai(BigDecimal vlrmovcai) {
        this.vlrmovcai = vlrmovcai;
    }

    public String getDescmovcaixa() {
        return descmovcaixa;
    }

    public void setDescmovcaixa(String descmovcaixa) {
        this.descmovcaixa = descmovcaixa;
    }

    public Integer getTiporecmovcai() {
        return tiporecmovcai;
    }

    public void setTiporecmovcai(Integer tiporecmovcai) {
        this.tiporecmovcai = tiporecmovcai;
    }

    public Caixa getCaixaId() {
        return caixaId;
    }

    public void setCaixaId(Caixa caixaId) {
        this.caixaId = caixaId;
    }

    public Recebimento getRecebimentoId() {
        return recebimentoId;
    }

    public void setRecebimentoId(Recebimento recebimentoId) {
        this.recebimentoId = recebimentoId;
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
        if (!(object instanceof MovCaixa)) {
            return false;
        }
        MovCaixa other = (MovCaixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovCaixa{" + "id=" + id + ", datamovcai=" + datamovcai + ", tipomovcai=" + tipomovcai + ", vlrmovcai=" + vlrmovcai + ", descmovcaixa=" + descmovcaixa + ", tiporecmovcai=" + tiporecmovcai + ", caixaId=" + caixaId + ", recebimentoId=" + recebimentoId + '}';
    }
    
}
