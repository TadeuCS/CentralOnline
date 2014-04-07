/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.TipoAtendimento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class TipoAtendimentoMB {

    private TipoAtendimento tipoAtendimento = new TipoAtendimento();

  
    public TipoAtendimentoMB() {
    }
    
      public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoTipoAtendimento) {
        this.tipoAtendimento = tipoTipoAtendimento;
    }

//        public void Salvar() {
//        try {
//            tipoAtendimentoEJB.Salvar(tipoAtendimento);
//            tipoAtendimento = new TipoAtendimento();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    
//    public void Excluir(TipoAtendimento tipoAtendimento){
//        try {
//            tipoAtendimentoEJB.Excluir(tipoAtendimento);
//            this.tipoAtendimento = new TipoAtendimento();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    
//    public List<TipoAtendimento> listaDeTipoAtendimentos(){
//        return tipoAtendimentoEJB.listaTipoAtendimento();
//    }
}
