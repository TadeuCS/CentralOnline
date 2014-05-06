/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Origem;
import Util.Manager;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class OrigemMB extends Manager {

    Origem origem = new Origem();

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public OrigemMB() {

    }

    public void salvar() {
        if (origem.getCodorigem() == null) {
            try {
                em.getTransaction().begin();
                em.merge(origem);
                em.getTransaction().commit();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
                origem = new Origem();
            } catch (Exception e) {
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Origem!"));
            }
        } else {

            try {
                em.getTransaction().begin();
                em.merge(origem);
                em.getTransaction().commit();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Editado com sucesso!"));
                origem = new Origem();
            } catch (Exception e) {
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Origem!"));
            }
        }
    }

    public void excluir(Origem origem) {
        try {
            em.getTransaction().begin();
            em.remove(origem);
            em.getTransaction().commit();
            this.origem = new Origem();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Origem> listaDeOrigens() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Origem.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
