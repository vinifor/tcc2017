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
@Table(name = "Cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 100)
    @Column(name = "nomecli")
    private String nomecli;
    @Size(max = 100)
    @Column(name = "emailcli")
    private String emailcli;
    @Size(max = 20)
    @Column(name = "cpfcli")
    private String cpfcli;
    @Size(max = 20)
    @Column(name = "telefonecli")
    private String telefonecli;
    @Size(max = 100)
    @Column(name = "ruacli")
    private String ruacli;
    @Size(max = 10)
    @Column(name = "numerocli")
    private String numerocli;
    @Size(max = 100)
    @Column(name = "bairrocli")
    private String bairrocli;
    @Column(name = "statuscli")
    private Boolean statuscli;
    @JoinColumn(name = "Cidade_Id", referencedColumnName = "Id")
    @ManyToOne
    private Cidade cidadeId;
    @OneToMany(mappedBy = "clienteId", cascade = CascadeType.ALL)
    private List<ContaReceber> contaReceberList;
    @OneToMany(mappedBy = "clienteId", cascade = CascadeType.ALL)
    private List<Venda> vendaList;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    public String getEmailcli() {
        return emailcli;
    }

    public void setEmailcli(String emailcli) {
        this.emailcli = emailcli;
    }

    public String getCpfcli() {
        return cpfcli;
    }

    public void setCpfcli(String cpfcli) {
        this.cpfcli = cpfcli;
    }

    public String getTelefonecli() {
        return telefonecli;
    }

    public void setTelefonecli(String telefonecli) {
        this.telefonecli = telefonecli;
    }

    public String getRuacli() {
        return ruacli;
    }

    public void setRuacli(String ruacli) {
        this.ruacli = ruacli;
    }

    public String getNumerocli() {
        return numerocli;
    }

    public void setNumerocli(String numerocli) {
        this.numerocli = numerocli;
    }

    public String getBairrocli() {
        return bairrocli;
    }

    public void setBairrocli(String bairrocli) {
        this.bairrocli = bairrocli;
    }

    public Boolean getStatuscli() {
        return statuscli;
    }

    public void setStatuscli(Boolean statuscli) {
        this.statuscli = statuscli;
    }

    @JsonIgnore
    public List<ContaReceber> getContaReceberList() {
        return contaReceberList;
    }

    public void setContaReceberList(List<ContaReceber> contaReceberList) {
        this.contaReceberList = contaReceberList;
    }

    @JsonIgnore
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    public Cidade getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Cidade cidadeId) {
        this.cidadeId = cidadeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nomecli=" + nomecli + ", emailcli=" + emailcli + ", cpfcli=" + cpfcli + ", telefonecli=" + telefonecli + ", ruacli=" + ruacli + ", numerocli=" + numerocli + ", bairrocli=" + bairrocli + ", statuscli=" + statuscli + ", cidadeId=" + cidadeId + '}';
    }
    
}
