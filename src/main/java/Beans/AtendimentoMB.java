/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Atendimento;
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
public class AtendimentoMB extends Manager {

    private Atendimento att = new Atendimento();

    public AtendimentoMB() {
    }

    public Atendimento getAtt() {
        return att;
    }

    public void setAtt(Atendimento att) {
        this.att = att;
    }

    public void Salvar() {
        try {
            att = new Atendimento();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Excluir(Atendimento att) {
        try {
            this.att = new Atendimento();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Atendimento> listaDeAtendimento() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Atendimento.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }

    public List<Atendimento> listaDeAtendimentoExecucao() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Atendimento.findExecucao");
        em.getTransaction().commit();
        return query.getResultList();
    }

    public List<Atendimento> listaDeAtendimentoConcluido() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Atendimento.findConcluido");
        em.getTransaction().commit();
        return query.getResultList();
    }

    public List<Atendimento> listaDeAtendimentoPendente() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Atendimento.findPendente");
        em.getTransaction().commit();
        return query.getResultList();
    }
}