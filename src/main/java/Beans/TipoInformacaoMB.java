/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.TipoInformacao;
import Util.Manager;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Query;

/**
 *
 * @author tadeu
 */
@ManagedBean
@RequestScoped
public class TipoInformacaoMB extends Manager {

    private TipoInformacao tipoInformacao = new TipoInformacao();

    public TipoInformacao getTipoInformacao() {
        return tipoInformacao;
    }

    public void setTipoInformacao(TipoInformacao tipoInformacao) {
        this.tipoInformacao = tipoInformacao;
    }

    public TipoInformacaoMB() {
    }

    public List<TipoInformacao> lista() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("TipoInformacao.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
