/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "aplicativo_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AplicativoClientes.findAll", query = "SELECT a FROM AplicativoClientes a"),
    @NamedQuery(name = "AplicativoClientes.findByCodaplicativo", query = "SELECT a FROM AplicativoClientes a WHERE a.aplicativoClientesPK.codaplicativo = :codaplicativo"),
    @NamedQuery(name = "AplicativoClientes.findByCodcliente", query = "SELECT a FROM AplicativoClientes a WHERE a.aplicativoClientesPK.codcliente = :codcliente"),
    @NamedQuery(name = "AplicativoClientes.findByQuantidade", query = "SELECT a FROM AplicativoClientes a WHERE a.quantidade = :quantidade")})
public class AplicativoClientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AplicativoClientesPK aplicativoClientesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE")
    private int quantidade;
    @JoinColumn(name = "CODCLIENTE", referencedColumnName = "CODCLIENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente clientes;
    @JoinColumn(name = "CODAPLICATIVO", referencedColumnName = "CODAPLICATIVO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicativo aplicativo;

    public AplicativoClientes() {
    }

    public AplicativoClientes(AplicativoClientesPK aplicativoClientesPK) {
        this.aplicativoClientesPK = aplicativoClientesPK;
    }

    public AplicativoClientes(AplicativoClientesPK aplicativoClientesPK, int quantidade) {
        this.aplicativoClientesPK = aplicativoClientesPK;
        this.quantidade = quantidade;
    }

    public AplicativoClientes(int codaplicativo, int codcliente) {
        this.aplicativoClientesPK = new AplicativoClientesPK(codaplicativo, codcliente);
    }

    public AplicativoClientesPK getAplicativoClientesPK() {
        return aplicativoClientesPK;
    }

    public void setAplicativoClientesPK(AplicativoClientesPK aplicativoClientesPK) {
        this.aplicativoClientesPK = aplicativoClientesPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aplicativoClientesPK != null ? aplicativoClientesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplicativoClientes)) {
            return false;
        }
        AplicativoClientes other = (AplicativoClientes) object;
        if ((this.aplicativoClientesPK == null && other.aplicativoClientesPK != null) || (this.aplicativoClientesPK != null && !this.aplicativoClientesPK.equals(other.aplicativoClientesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.AplicativoClientes[ aplicativoClientesPK=" + aplicativoClientesPK + " ]";
    }
    
}
