/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.TipoAtendimento;
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
public class TipoAtendimentoMB extends Manager {

    private TipoAtendimento tipoAtendimento = new TipoAtendimento();

    public TipoAtendimentoMB() {
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoTipoAtendimento) {
        this.tipoAtendimento = tipoTipoAtendimento;
    }

    public void Salvar() {
        try {

            em.getTransaction().begin();
            em.merge(tipoAtendimento);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Excluir(TipoAtendimento tipoAtendimento) {
        try {
            em.getTransaction().begin();
            em.remove(tipoAtendimento);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<TipoAtendimento> listaDeTipoAtendimentos() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("TipoAtendimento.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
