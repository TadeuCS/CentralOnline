/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Link;
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
public class LinksMB extends Manager {

    private Link link = new Link();

    public LinksMB() {

    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public void salvar() {
        em.getTransaction().begin();
        em.merge(link);
        em.getTransaction().commit();

    }

    public List<Link> listaLinks() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Link.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }
}