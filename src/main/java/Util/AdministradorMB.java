/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class AdministradorMB {

    private UploadedFile file;

    public AdministradorMB() {
    }
    public String trocaLink(){
        FacesContext context= FacesContext.getCurrentInstance().getCurrentInstance();
        ExternalContext external= context.getExternalContext();
        HttpServletRequest request =(HttpServletRequest) external.getRequest();
        if(request.isUserInRole("ROLE_SUPORTE")){
            return "View/Suporte/index.jsf";
        }else
        if(request.isUserInRole("ROLE_ATENDENTE")){
            return "View/Atendente/index.jsf";
        }else
        if(request.isUserInRole("ROLE_ADMINISTRADOR")){
            return "View/Administrador/index.jsf";
        }else
            return null;
    }
    
    public void uparArquivo(FileUploadEvent event) throws IOException {
        try {
            UploadedFile arq = event.getFile();
            InputStream in = new BufferedInputStream(arq.getInputstream());
            File file = new File("C:\\Users\\Tadeu\\Documents\\NetBeansProjects\\CentralOnline\\web\\resources\\img\\" + "Tadeu" + ".png");

            FileOutputStream fout = new FileOutputStream(file);

            while (in.available() != 0) {
                fout.write(in.read());
            }
            fout.close();
            FacesMessage msg = new FacesMessage("O Arquivo ", file.getName()
                    + " foi salvo com Sucesso!");
            FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String trocaTemplate(String tipoUsuario) {
        if (tipoUsuario.contains("ADMINISTRADOR")) {
            return "/WEB-INF/Template_Administrador.xhtml";
        } else if (tipoUsuario.contains("ATENDENTE")) {
            return "/WEB-INF/Template_Atendente.xhtml";
        } else if (tipoUsuario.contains("SUPORTE")) {
            return "/WEB-INF/Template_Suporte.xhtml";
        } else {
            return null;
        }
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
}
