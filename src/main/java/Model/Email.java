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
@Table(name = "email")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e"),
    @NamedQuery(name = "Email.findByCodemail", query = "SELECT e FROM Email e WHERE e.codemail = :codemail"),
    @NamedQuery(name = "Email.findByEmail", query = "SELECT e FROM Email e WHERE e.email = :email"),
    @NamedQuery(name = "Email.findBySmtp", query = "SELECT e FROM Email e WHERE e.smtp = :smtp"),
    @NamedQuery(name = "Email.findByPorta", query = "SELECT e FROM Email e WHERE e.porta = :porta"),
    @NamedQuery(name = "Email.findByNome", query = "SELECT e FROM Email e WHERE e.nome = :nome"),
    @NamedQuery(name = "Email.findBySenha", query = "SELECT e FROM Email e WHERE e.senha = :senha"),
    @NamedQuery(name = "Email.findByAssinatura", query = "SELECT e FROM Email e WHERE e.assinatura = :assinatura")})
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODEMAIL")
    private Integer codemail;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SMTP")
    private String smtp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORTA")
    private int porta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SENHA")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ASSINATURA")
    private String assinatura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codemail")
    private List<Empresa> empresaList;

    public Email() {
    }

    public Email(Integer codemail) {
        this.codemail = codemail;
    }

    public Email(Integer codemail, String email, String smtp, int porta, String nome, String senha, String assinatura) {
        this.codemail = codemail;
        this.email = email;
        this.smtp = smtp;
        this.porta = porta;
        this.nome = nome;
        this.senha = senha;
        this.assinatura = assinatura;
    }

    public Integer getCodemail() {
        return codemail;
    }

    public void setCodemail(Integer codemail) {
        this.codemail = codemail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codemail != null ? codemail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.codemail == null && other.codemail != null) || (this.codemail != null && !this.codemail.equals(other.codemail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Email[ codemail=" + codemail + " ]";
    }
    
}
