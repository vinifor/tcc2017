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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "ContaReceber")
public class ContaReceber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "dataconrec")
    @Temporal(TemporalType.DATE)
    private Date dataconrec;
    @Column(name = "vlrsubtotconrec")
    private BigDecimal vlrsubtotconrec;
    @Column(name = "vlrdescontoconrec")
    private BigDecimal vlrdescontoconrec;
    @Column(name = "vlrtotalconrec")
    private BigDecimal vlrtotalconrec;
    @JoinColumn(name = "Cliente_Id", referencedColumnName = "Id")
    @ManyToOne
    private Cliente clienteId;
    @JoinColumn(name = "Usuario_Id", referencedColumnName = "Id")
    @ManyToOne
    private Usuario usuarioId;
    @JoinColumn(name = "Venda_Id", referencedColumnName = "Id")
    @ManyToOne
    private Venda vendaId;
    @OneToMany(mappedBy = "contaReceberId", cascade = CascadeType.ALL)
    private List<Recebimento> recebimentoList;
    @OneToMany(mappedBy = "contaReceberId", cascade = CascadeType.ALL)
    private List<ParcelaReceber> parcelaReceberList;

    public ContaReceber() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataconrec() {
        return dataconrec;
    }

    public void setDataconrec(Date dataconrec) {
        this.dataconrec = dataconrec;
    }

    public BigDecimal getVlrsubtotconrec() {
        return vlrsubtotconrec;
    }

    public void setVlrsubtotconrec(BigDecimal vlrsubtotconrec) {
        this.vlrsubtotconrec = vlrsubtotconrec;
    }

    public BigDecimal getVlrdescontoconrec() {
        return vlrdescontoconrec;
    }

    public void setVlrdescontoconrec(BigDecimal vlrdescontoconrec) {
        this.vlrdescontoconrec = vlrdescontoconrec;
    }

    public BigDecimal getVlrtotalconrec() {
        return vlrtotalconrec;
    }

    public void setVlrtotalconrec(BigDecimal vlrtotalconrec) {
        this.vlrtotalconrec = vlrtotalconrec;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Venda getVendaId() {
        return vendaId;
    }

    public void setVendaId(Venda vendaId) {
        this.vendaId = vendaId;
    }

    @JsonIgnore
    public List<Recebimento> getRecebimentoList() {
        return recebimentoList;
    }

    public void setRecebimentoList(List<Recebimento> recebimentoList) {
        this.recebimentoList = recebimentoList;
    }

    @JsonIgnore
    public List<ParcelaReceber> getParcelaReceberList() {
        return parcelaReceberList;
    }

    public void setParcelaReceberList(List<ParcelaReceber> parcelaReceberList) {
        this.parcelaReceberList = parcelaReceberList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ContaReceber)) {
            return false;
        }
        ContaReceber other = (ContaReceber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContaReceber{" + "id=" + id + ", dataconrec=" + dataconrec + ", vlrsubtotconrec=" + vlrsubtotconrec + ", vlrdescontoconrec=" + vlrdescontoconrec + ", vlrtotalconrec=" + vlrtotalconrec + ", clienteId=" + clienteId + ", usuarioId=" + usuarioId + ", vendaId=" + vendaId + '}';
    }

}
