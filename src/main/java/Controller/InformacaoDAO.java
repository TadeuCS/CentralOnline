/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Informacao;
import Util.Manager;

/**
 *
 * @author Tadeu
 */
public class InformacaoDAO extends Manager {

    public void salvar(Informacao informacao) {
            em.getTransaction().begin();
            em.merge(informacao);
            em.getTransaction().commit();
    }
}
