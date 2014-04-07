/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class UsuarioMB {

    private Usuario usuario = new Usuario();
    private String contraSenha;
  
    public UsuarioMB() {
    }

    public String getContraSenha() {
        return contraSenha;
    }

    public void setContraSenha(String contraSenha) {
        this.contraSenha = contraSenha;
    }
    
      public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

//        public void Salvar() {
//        try {
//            usuarioEJB.Salvar(usuario);
//            usuario = new Usuario();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    
//    public void Excluir(Usuario usuario){
//        try {
//            usuarioEJB.Excluir(usuario);
//            this.usuario = new Usuario();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//////    public String listaDeUsuarioByUsuarioSenha(){
//////        if(usuarioEJB.usuarioLogin()!=null){
//////          return "/View/Suporte/index.jsf";
//////        }else
//////        if(usuarioEJB.usuarioLogin()==null){
//////          return "/View/HomePage/Login.jsf";
//////        }else
//////        return null;
////    }
//    public List<Usuario> listaDeUsuarios(){
//        return usuarioEJB.listaUsuario();
//    }
//    public int qtdeAtendimentosAbertos(){
//        return usuarioEJB.qtdeAbertos();
//    }
//    public int qtdeAtendimentosConcluidos(){
//        return usuarioEJB.qtdeConcluidos();
//    }
//    public int qtdeAtendimentosPendentes(){
//        return usuarioEJB.qtdePendentes();
//    }
}
