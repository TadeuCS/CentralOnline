/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Prioridade;
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
public class PrioridadeMB extends Manager{

    Prioridade prioridade = new Prioridade();

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public PrioridadeMB() {
    }

    public void salva(){
        em.getTransaction().begin();
        em.merge(prioridade);
        em.getTransaction().commit();
    }
    public List<Prioridade> listaPrioridades() {
        em.getTransaction().begin();
        Query query= em.createNamedQuery("Prioridade.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
