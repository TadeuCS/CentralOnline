/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.TipoInformacao;
import Util.Manager;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Tadeu
 */
public class TipoInformacaoDAO extends Manager{
    
    public List<TipoInformacao> lista(){
        Query consulta=null;
        try{
        em.getTransaction().begin();
        consulta=em.createNamedQuery("TipoInformacao.findAll");
        em.getTransaction().commit();
        }catch(Exception e){
            System.out.println("erro: "+e.getMessage());
        }
        return consulta.getResultList();
    }
    
    public TipoInformacao consulta(Integer codigo){
        Query query=null;
        try{
        em.getTransaction().begin();
        query=em.createNamedQuery("TipoInformacao.findByCodtipoinformacao").setParameter("codtipoinformacao", codigo);
        em.getTransaction().commit();
        }catch(Exception e){
            System.out.println("erro: "+e.getMessage());
        }
        return (TipoInformacao) query.getSingleResult();
    }
}
