/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.AplicativoDAO;
import Model.Aplicativo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class AplicativoMB {

    private Aplicativo aplicativo = new Aplicativo();
    AplicativoDAO aplicativoDAO = new AplicativoDAO();

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }

    public AplicativoMB() {
        novo();
    }

    public void novo() {
        this.aplicativo = new Aplicativo();
    }

    public List<Aplicativo> lista() {
        return aplicativoDAO.listar();
    }
}
