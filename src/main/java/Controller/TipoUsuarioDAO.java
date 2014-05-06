/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TipoUsuario;
import Util.Manager;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author tadeu
 */
public class TipoUsuarioDAO extends Manager {

    public List<TipoUsuario> lista() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("TipoUsuario.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }

    public void Salvar(TipoUsuario tipoUsuario) {
        em.getTransaction().begin();
        em.merge(tipoUsuario);
        em.getTransaction().commit();
    }

    public TipoUsuario consulta(TipoUsuario tipo) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("TipoUsuario.findByCodtipousuario").setParameter("codtipousuario", tipo.getCodtipousuario());
        em.getTransaction().commit();
        return (TipoUsuario) query.getSingleResult();
    }

    public TipoUsuario consultaByCodigo(Integer codigo) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("TipoUsuario.findByCodtipousuario").setParameter("codtipousuario", codigo);
        em.getTransaction().commit();
        return (TipoUsuario) query.getSingleResult();
    }
}
