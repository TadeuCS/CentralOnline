/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tadeu
 */
@Entity
@Table(name = "aplicativo_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AplicativoCliente.findAll", query = "SELECT a FROM AplicativoCliente a"),
    @NamedQuery(name = "AplicativoCliente.findByCodclienteapp", query = "SELECT a FROM AplicativoCliente a WHERE a.codclienteapp = :codclienteapp"),
    @NamedQuery(name = "AplicativoCliente.findByQuantidade", query = "SELECT a FROM AplicativoCliente a WHERE a.quantidade = :quantidade")})
public class AplicativoCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODCLIENTEAPP")
    private Integer codclienteapp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE")
    private int quantidade;
    @JoinColumn(name = "CODCLIENTE", referencedColumnName = "CODCLIENTE")
    @ManyToOne(optional = false)
    private Cliente codcliente;
    @JoinColumn(name = "CODAPLICATIVO", referencedColumnName = "CODAPLICATIVO")
    @ManyToOne(optional = false)
    private Aplicativo codaplicativo;

    public AplicativoCliente() {
    }

    public AplicativoCliente(Integer codclienteapp) {
        this.codclienteapp = codclienteapp;
    }

    public AplicativoCliente(Integer codclienteapp, int quantidade) {
        this.codclienteapp = codclienteapp;
        this.quantidade = quantidade;
    }

    public Integer getCodclienteapp() {
        return codclienteapp;
    }

    public void setCodclienteapp(Integer codclienteapp) {
        this.codclienteapp = codclienteapp;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(Cliente codcliente) {
        this.codcliente = codcliente;
    }

    public Aplicativo getCodaplicativo() {
        return codaplicativo;
    }

    public void setCodaplicativo(Aplicativo codaplicativo) {
        this.codaplicativo = codaplicativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codclienteapp != null ? codclienteapp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplicativoCliente)) {
            return false;
        }
        AplicativoCliente other = (AplicativoCliente) object;
        if ((this.codclienteapp == null && other.codclienteapp != null) || (this.codclienteapp != null && !this.codclienteapp.equals(other.codclienteapp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.AplicativoCliente[ codclienteapp=" + codclienteapp + " ]";
    }
    
}
