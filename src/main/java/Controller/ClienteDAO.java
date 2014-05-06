/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplicativoCliente;
import Model.Cliente;
import Model.Telefone;
import Util.Manager;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

/**
 *
 * @author tadeu
 */
public class ClienteDAO extends Manager {

//    public List<AplicativoCliente> listaDeLinks() {
//        em.getTransaction().begin();
//        Query query = em.createNamedQuery("AplicativoCliente.findAll");
//        em.getTransaction().commit();
//        return query.getResultList();
//    }
//
//    public List<Telefone> listaDeTelefone() {
//        em.getTransaction().begin();
//        Query query = em.createNamedQuery("Telefone.findAll");
//        em.getTransaction().commit();
//        return query.getResultList();
//    }
    public List<Cliente> listaDeClientes() {
        Query query = null;
        try {
            em.getTransaction().begin();
            query = em.createNamedQuery("Cliente.findAll");
            em.getTransaction().commit();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
        return query.getResultList();
    }

    public List<Cliente> listaDeClientesByNomeFantasia(String nomeFantasia) {
        Query query = null;
        try {
            em.getTransaction().begin();
            query = em.createNamedQuery("Cliente.findByNomeFantasia").setParameter("nomeFantasia", nomeFantasia);
            em.getTransaction().commit();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
        return query.getResultList();
    }
}
