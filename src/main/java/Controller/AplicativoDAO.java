/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplicativo;
import Util.Manager;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Tadeu
 */
public class AplicativoDAO extends Manager {

    public List<Aplicativo> listar() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Aplicativo.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
