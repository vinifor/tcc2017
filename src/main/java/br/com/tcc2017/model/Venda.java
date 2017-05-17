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
@Table(name = "Venda")
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "dataven")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataven;
    @Column(name = "vlrdescven")
    private BigDecimal vlrdescven;
    @Column(name = "vlracresven")
    private BigDecimal vlracresven;
    @Column(name = "vlrsubtotven")
    private BigDecimal vlrsubtotven;
    @Column(name = "vlrtotalven")
    private BigDecimal vlrtotalven;
    @Column(name = "statusven")
    private Boolean statusven;
    @OneToMany(mappedBy = "vendaId", cascade = CascadeType.ALL)
    private List<ItemVenda> itemVendaList;
    @OneToMany(mappedBy = "vendaId", cascade = CascadeType.ALL)
    private List<ContaReceber> contaReceberList;
    @JoinColumn(name = "Cliente_Id", referencedColumnName = "Id")
    @ManyToOne
    private Cliente clienteId;
    @JoinColumn(name = "Mesas_Id", referencedColumnName = "Id")
    @ManyToOne
    private Mesas mesasId;
    @JoinColumn(name = "Usuario_Id", referencedColumnName = "Id")
    @ManyToOne
    private Usuario usuarioId;

    public Venda() {
    }

    public Venda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataven() {
        return dataven;
    }

    public void setDataven(Date dataven) {
        this.dataven = dataven;
    }

    public BigDecimal getVlrdescven() {
        return vlrdescven;
    }

    public void setVlrdescven(BigDecimal vlrdescven) {
        this.vlrdescven = vlrdescven;
    }

    public BigDecimal getVlracresven() {
        return vlracresven;
    }

    public void setVlracresven(BigDecimal vlracresven) {
        this.vlracresven = vlracresven;
    }

    public BigDecimal getVlrsubtotven() {
        return vlrsubtotven;
    }

    public void setVlrsubtotven(BigDecimal vlrsubtotven) {
        this.vlrsubtotven = vlrsubtotven;
    }

    public BigDecimal getVlrtotalven() {
        return vlrtotalven;
    }

    public void setVlrtotalven(BigDecimal vlrtotalven) {
        this.vlrtotalven = vlrtotalven;
    }

    public Boolean getStatusven() {
        return statusven;
    }

    public void setStatusven(Boolean statusven) {
        this.statusven = statusven;
    }

    @JsonIgnore
    public List<ItemVenda> getItemVendaList() {
        return itemVendaList;
    }

    public void setItemVendaList(List<ItemVenda> itemVendaList) {
        this.itemVendaList = itemVendaList;
    }

    @JsonIgnore
    public List<ContaReceber> getContaReceberList() {
        return contaReceberList;
    }

    public void setContaReceberList(List<ContaReceber> contaReceberList) {
        this.contaReceberList = contaReceberList;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Mesas getMesasId() {
        return mesasId;
    }

    public void setMesasId(Mesas mesasId) {
        this.mesasId = mesasId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", dataven=" + dataven + ", vlrdescven=" + vlrdescven + ", vlracresven=" + vlracresven + ", vlrsubtotven=" + vlrsubtotven + ", vlrtotalven=" + vlrtotalven + ", statusven=" + statusven + ", clienteId=" + clienteId + ", mesasId=" + mesasId + ", usuarioId=" + usuarioId + '}';
    }
    
}
