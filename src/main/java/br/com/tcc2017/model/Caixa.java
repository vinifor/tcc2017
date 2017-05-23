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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "Caixa")
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "dataabcai")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataabcai;
    @Column(name = "datafccai")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafccai;
    @Column(name = "vlrabcai")
    private BigDecimal vlrabcai;
    @Column(name = "vlrfccai")
    private BigDecimal vlrfccai;
    @Column(name = "statuscai")
    private Boolean statuscai;
    @OneToMany(mappedBy = "caixaId", cascade = CascadeType.ALL)
    private List<MovCaixa> movCaixaList;

    public Caixa() {
    }

    public Caixa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataabcai() {
        return dataabcai;
    }

    public void setDataabcai(Date dataabcai) {
        this.dataabcai = dataabcai;
    }

    public Date getDatafccai() {
        return datafccai;
    }

    public void setDatafccai(Date datafccai) {
        this.datafccai = datafccai;
    }

    public BigDecimal getVlrabcai() {
        return vlrabcai;
    }

    public void setVlrabcai(BigDecimal vlrabcai) {
        this.vlrabcai = vlrabcai;
    }

    public BigDecimal getVlrfccai() {
        return vlrfccai;
    }

    public void setVlrfccai(BigDecimal vlrfccai) {
        this.vlrfccai = vlrfccai;
    }

    public Boolean getStatuscai() {
        return statuscai;
    }

    public void setStatuscai(Boolean statuscai) {
        this.statuscai = statuscai;
    }

    @JsonIgnore
    public List<MovCaixa> getMovCaixaList() {
        return movCaixaList;
    }

    public void setMovCaixaList(List<MovCaixa> movCaixaList) {
        this.movCaixaList = movCaixaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa{" + "id=" + id + ", dataabcai=" + dataabcai + ", datafccai=" + datafccai + ", vlrabcai=" + vlrabcai + ", vlrfccai=" + vlrfccai + ", statuscai=" + statuscai + '}';
    }

}
