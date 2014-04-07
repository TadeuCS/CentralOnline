/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Link;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class LinksMB {
    private Link link= new Link();
    
    public LinksMB() {

    }
    
    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
    
//    public void salvar(){
//        linksEJB.Salvar(link);
//    }
//    
//    public List<Link> listaLinks() {
//        return linksEJB.listaLinks();
//    }
}
