/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ponto;
import Model.Usuario;
import Util.Manager;
import javax.persistence.Query;

/**
 *
 * @author Tadeu
 */
public class PontoDAO extends Manager{

    public void salvar(Ponto ponto) {
        em.getTransaction().begin();
        em.merge(ponto);
        em.getTransaction().commit();
    }
    public String busca(Integer codUsuario){
        em.getTransaction().begin();
        Query query= em.createQuery("SELECT MAX(p.tipo) FROM Ponto p where p.codusuario =: codigo").setParameter("codigo", codUsuario);
        em.getTransaction().commit();
        return query.getSingleResult().toString();
    } 
}
