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
import javax.faces.context.FacesContext;
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

    public String direcionaIndex(int tipoUsuario) {
        if (tipoUsuario == 3) {
            return "/View/Administrador/index.jsf";
        } else if (tipoUsuario == 2) {
            return "/View/Atendente/index.jsf";
        } else if (tipoUsuario == 1) {
            return "/View/Suporte/index.jsf";
        } else {
            return null;
        }
    }

    public String trocaTemplate(int tipoUsuario) {
        if (tipoUsuario == 3) {
            return "/WEB-INF/Template_Administrador.xhtml";
        } else if (tipoUsuario == 2) {
            return "/WEB-INF/Template_Atendente.xhtml";
        } else if (tipoUsuario == 1) {
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
