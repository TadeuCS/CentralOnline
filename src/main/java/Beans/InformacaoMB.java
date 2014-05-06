/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import Model.Informacao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author tadeu
 */
@ManagedBean
@RequestScoped
public class InformacaoMB {

    private Informacao informacao= new Informacao();

    public Informacao getInformacao() {
        return informacao;
    }

    public void setInformacao(Informacao informacao) {
        this.informacao = informacao;
    }
    
    public InformacaoMB() {
    }
    public void salvar(){
        
    }
}
