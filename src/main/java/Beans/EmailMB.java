/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Email;
import Util.Manager;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Query;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class EmailMB extends Manager {

    Email email = new Email();

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public EmailMB() {
    }

    public List<Email> listaEmails() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Email.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
