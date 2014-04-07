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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tadeu
 */
@Entity
@Table(name = "link")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Link.findAll", query = "SELECT l FROM Link l"),
    @NamedQuery(name = "Link.findByCodlinks", query = "SELECT l FROM Link l WHERE l.codlinks = :codlinks"),
    @NamedQuery(name = "Link.findByDescricao", query = "SELECT l FROM Link l WHERE l.descricao = :descricao")})
public class Link implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODLINKS")
    private Integer codlinks;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;
    @JoinColumn(name = "CODAPLICATIVO", referencedColumnName = "CODAPLICATIVO")
    @ManyToOne(optional = false)
    private Aplicativo codaplicativo;

    public Link() {
    }

    public Link(Integer codlinks) {
        this.codlinks = codlinks;
    }

    public Link(Integer codlinks, String descricao) {
        this.codlinks = codlinks;
        this.descricao = descricao;
    }

    public Integer getCodlinks() {
        return codlinks;
    }

    public void setCodlinks(Integer codlinks) {
        this.codlinks = codlinks;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash += (codlinks != null ? codlinks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Link)) {
            return false;
        }
        Link other = (Link) object;
        if ((this.codlinks == null && other.codlinks != null) || (this.codlinks != null && !this.codlinks.equals(other.codlinks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Link[ codlinks=" + codlinks + " ]";
    }
    
}
