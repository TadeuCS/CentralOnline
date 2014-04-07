/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tadeu
 */
@Embeddable
public class AplicativoClientesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODAPLICATIVO")
    private int codaplicativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCLIENTE")
    private int codcliente;

    public AplicativoClientesPK() {
    }

    public AplicativoClientesPK(int codaplicativo, int codcliente) {
        this.codaplicativo = codaplicativo;
        this.codcliente = codcliente;
    }

    public int getCodaplicativo() {
        return codaplicativo;
    }

    public void setCodaplicativo(int codaplicativo) {
        this.codaplicativo = codaplicativo;
    }

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codaplicativo;
        hash += (int) codcliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplicativoClientesPK)) {
            return false;
        }
        AplicativoClientesPK other = (AplicativoClientesPK) object;
        if (this.codaplicativo != other.codaplicativo) {
            return false;
        }
        if (this.codcliente != other.codcliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.AplicativoClientesPK[ codaplicativo=" + codaplicativo + ", codcliente=" + codcliente + " ]";
    }
    
}
