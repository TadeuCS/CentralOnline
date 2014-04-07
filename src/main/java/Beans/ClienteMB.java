/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import Model.AplicativoClientes;
import Model.Cliente;
import Model.Rota;
import Model.Telefone;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class ClienteMB {
    
    Rota rota= new Rota();
    Telefone telefone = new Telefone();
    AplicativoClientes aplicativoClientes= new AplicativoClientes();
    Cliente cliente = new Cliente();
    private String mapa;
    
    public void retornaMapa(){
        this.mapa= mapa.replaceAll("<iframe src=\"", "");
        this.mapa = mapa.replaceAll("\" width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0\"></iframe>", "");
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
    
    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }
    
    public AplicativoClientes getAplicativoClientes() {
        return aplicativoClientes;
    }

    public void setAplicativoClientes(AplicativoClientes aplicativoClientes) {
        this.aplicativoClientes = aplicativoClientes;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public ClienteMB() {
    }
//    public List<AplicativoClientes> listaDeLinks(){
//        return clienteEJB.listaLinks();
//    }
//    public List<Telefone> listaDeTelefone(){
//        return clienteEJB.listaTelefones();
//    }
//    public List<Cliente> listaDeClientes(){
//        return clienteEJB.listaClientes();
//    }
//    public List<Cliente> listaDeClientesByNomeFantasia(){
//        return clienteEJB.listaClientesByNomeFantasia();
//    }
    
}
