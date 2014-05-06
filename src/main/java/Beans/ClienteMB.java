/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.ClienteDAO;
import Model.AplicativoCliente;
import Model.Cliente;
import Model.Rota;
import Model.Telefone;
import Util.Manager;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class ClienteMB extends Manager {

    private Cliente cliente;
    ClienteDAO clienteDAO = new ClienteDAO();
    private String mapa;

    public void retornaMapa() {
        this.mapa = mapa.replaceAll("<iframe src=\"", "");
        this.mapa = mapa.replaceAll("\" width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0\"></iframe>", "");
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public ClienteMB() {
        novo();
    }

    public void novo(){
        cliente= new Cliente();
    }
    public List<Cliente> listaClientes() {
        return clienteDAO.listaDeClientes();
    }

    public List<Cliente> listaClientesByNomeFantasia() {
        return clienteDAO.listaDeClientesByNomeFantasia(cliente.getNomeFantasia());
    }
}
