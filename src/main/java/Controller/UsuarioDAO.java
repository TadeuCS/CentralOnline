/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import Util.Manager;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author tadeu
 */
public class UsuarioDAO extends Manager {

    public void salva(Usuario usuario) {
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }

    public void exclui(Usuario usuario) {
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
    }

    public List<Usuario> lista() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Usuario.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }

    public Usuario consulta(String usuario, String senha) {
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT u from Usuario u where u.usuario like :usuario AND u.senha like :senha")
                    .setParameter("usuario", usuario).setParameter("senha", senha);
            em.getTransaction().commit();
            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }

}
