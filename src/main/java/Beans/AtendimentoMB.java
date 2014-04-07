/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import Model.Atendimento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class AtendimentoMB{

    private Atendimento att = new Atendimento();
    
    public AtendimentoMB() {
    }

    public Atendimento getAtt() {
        return att;
    }

    public void setAtt(Atendimento att) {
        this.att = att;
    }
    public void Salvar() {
        try {
            att = new Atendimento();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void Excluir(Atendimento att){
        try {
            this.att = new Atendimento();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
//    public List<Atendimento> listaDeAtendimento(){
//    }
//    public List<Atendimento> listaDeAtendimentoByUsuario(){
//    }
//    public List<Atendimento> listaDeAtendimentoConcluidos(){
//    }
//    public List<Atendimento> listaDeAtendimentoPendentes(){
//    }
}
