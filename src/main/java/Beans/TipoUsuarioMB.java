/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.TipoUsuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class TipoUsuarioMB {

    private TipoUsuario tipoUsuario = new TipoUsuario();

  
    public TipoUsuarioMB() {
    }
    
      public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoTipoUsuario) {
        this.tipoUsuario = tipoTipoUsuario;
    }

//        public void Salvar() {
//        try {
//            tipoUsuarioEJB.Salvar(tipoUsuario);
//            tipoUsuario = new TipoUsuario();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    
//    public void Excluir(TipoUsuario tipoTipoUsuario){
//        try {
//            tipoUsuarioEJB.Excluir(tipoTipoUsuario);
//            this.tipoUsuario = new TipoUsuario();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    
//    public List<TipoUsuario> listaDeTipoUsuarios(){
//        return tipoUsuarioEJB.listaTipoUsuario();
//    }
}
