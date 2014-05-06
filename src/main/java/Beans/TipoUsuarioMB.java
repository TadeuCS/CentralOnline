/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.TipoUsuarioDAO;
import Model.TipoUsuario;
import Util.Manager;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class TipoUsuarioMB extends Manager {

    private TipoUsuario tipoUsuario;
    TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();

    public TipoUsuarioMB() {
        novo();
    }

    public void novo() {
        tipoUsuario = new TipoUsuario();
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoTipoUsuario) {
        this.tipoUsuario = tipoTipoUsuario;
    }

    public List<TipoUsuario> listaTipoUsuarios() {
        return tipoUsuarioDAO.lista();
    }

    public void salvar() {
        try {
            tipoUsuarioDAO.Salvar(tipoUsuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Salvo com Sucesso", ""));
            novo();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
    }
}
