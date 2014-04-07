/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tadeu
 */
@Entity
@Table(name = "rota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rota.findAll", query = "SELECT r FROM Rota r"),
    @NamedQuery(name = "Rota.findByCodrota", query = "SELECT r FROM Rota r WHERE r.codrota = :codrota"),
    @NamedQuery(name = "Rota.findByDiretorio", query = "SELECT r FROM Rota r WHERE r.diretorio = :diretorio")})
public class Rota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODROTA")
    private Integer codrota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DIRETORIO")
    private String diretorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codrota")
    private List<Cliente> clientesList;

    public Rota() {
    }

    public Rota(Integer codrota) {
        this.codrota = codrota;
    }

    public Rota(Integer codrota, String diretorio) {
        this.codrota = codrota;
        this.diretorio = diretorio;
    }

    public Integer getCodrota() {
        return codrota;
    }

    public void setCodrota(Integer codrota) {
        this.codrota = codrota;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    @XmlTransient
    public List<Cliente> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Cliente> clientesList) {
        this.clientesList = clientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrota != null ? codrota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rota)) {
            return false;
        }
        Rota other = (Rota) object;
        if ((this.codrota == null && other.codrota != null) || (this.codrota != null && !this.codrota.equals(other.codrota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Rota[ codrota=" + codrota + " ]";
    }
    
}
