/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Empresa;
import Util.Manager;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Query;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class EmpresaMB extends Manager {

    Empresa empresa = new Empresa();

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public EmpresaMB() {
    }

    public List<Empresa> listaEmpresas() {
        em.getTransaction().begin();
        Query query=em.createNamedQuery("Empresa.findAll");
        em.getTransaction().commit();
        return query.getResultList();
    }
}
