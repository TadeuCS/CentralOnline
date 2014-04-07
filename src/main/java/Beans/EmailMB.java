/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Email;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class EmailMB {

    Email email = new Email();

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public EmailMB() {
    }

//    public List<Email> listaEmails() {
//        return emailEJB.listaEmail();
//    }
}
