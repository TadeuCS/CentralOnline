/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Prioridade;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class PrioridadeMB {

    Prioridade prioridade = new Prioridade();

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public PrioridadeMB() {
    }

//    public void salva(){
//        prioridadeEJB.Salvar(prioridade);
//    }
//    public List<Prioridade> listaPrioridades() {
//        return prioridadeEJB.listaPrioridade();
//    }
}
