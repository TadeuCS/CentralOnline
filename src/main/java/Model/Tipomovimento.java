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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tadeu
 */
@Entity
@Table(name = "tipomovimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomovimento.findAll", query = "SELECT t FROM Tipomovimento t"),
    @NamedQuery(name = "Tipomovimento.findByCodtipo", query = "SELECT t FROM Tipomovimento t WHERE t.codtipo = :codtipo"),
    @NamedQuery(name = "Tipomovimento.findByDescricao", query = "SELECT t FROM Tipomovimento t WHERE t.descricao = :descricao")})
public class Tipomovimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODTIPO")
    private Integer codtipo;
    @Size(max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;

    public Tipomovimento() {
    }

    public Tipomovimento(Integer codtipo) {
        this.codtipo = codtipo;
    }

    public Integer getCodtipo() {
        return codtipo;
    }

    public void setCodtipo(Integer codtipo) {
        this.codtipo = codtipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipo != null ? codtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomovimento)) {
            return false;
        }
        Tipomovimento other = (Tipomovimento) object;
        if ((this.codtipo == null && other.codtipo != null) || (this.codtipo != null && !this.codtipo.equals(other.codtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Tipomovimento[ codtipo=" + codtipo + " ]";
    }
    
}
