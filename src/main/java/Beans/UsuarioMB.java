/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controller.TipoUsuarioDAO;
import Controller.UsuarioDAO;
import Model.TipoUsuario;
import Model.Usuario;
import Util.Criptografia;
import Util.Manager;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

/**
 *
 * @author Tadeu
 */
@ManagedBean
@RequestScoped
public class UsuarioMB extends Manager {

    private Usuario usuario;
    private String contraSenha;
    private String antigaSenha;
    private TipoUsuario tipoUsuario;
    private boolean bloqueado;
    static String usuarioLogado;

    public UsuarioMB() {
        novo();
    }

    public void novo() {
        usuario = new Usuario();
        tipoUsuario = new TipoUsuario();
    }

    public String getAntigaSenha() {
        return antigaSenha;
    }

    public void setAntigaSenha(String antigaSenha) {
        this.antigaSenha = antigaSenha;
    }

    public String getContraSenha() {
        return contraSenha;
    }

    public void setContraSenha(String contraSenha) {
        this.contraSenha = contraSenha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String alteraImagem(String usuarioLogado) {
        em.getTransaction().begin();
        Query query1 = em.createNativeQuery("SELECT u.foto from USUARIO u where u.usuario like '" + usuarioLogado + "'");
        Query query2 = em.createNativeQuery("SELECT u.sexo from USUARIO u where u.usuario like '" + usuarioLogado + "'");
        em.getTransaction().commit();
        if (query1.getSingleResult().toString().compareToIgnoreCase(usuarioLogado + ".png") == 0) {
            return usuarioLogado + ".png";
        } else {
            return "usuario_" + query2.getSingleResult().toString() + ".png";
        }
    }

    public String validaSenha() {
        if (usuario.getSenha().equals(contraSenha)) {
            Criptografia criptografia = new Criptografia();
            usuario.setSenha(criptografia.criptografar(usuario.getSenha()));
            return usuario.getSenha();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas Diferentes", ""));
            return null;
        }
    }

    public void validaBloqueado() {
        if (bloqueado == false) {
            usuario.setBloqueado('1');
        } else {
            usuario.setBloqueado('0');
        }
    }
    
    public void validaNovaSenha(String usuarioLogado) {
        this.usuarioLogado=usuarioLogado;
        String novaSenha=null;
        novaSenha=usuario.getSenha();
        antigaSenha = Criptografia.criptografar(antigaSenha);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (usuarioDAO.consulta(usuarioLogado, antigaSenha) != null) {
            this.usuario = usuarioDAO.consulta(usuarioLogado, antigaSenha);
            this.usuario.setSenha(novaSenha);
            salva();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Inválidos", ""));
        }
    }

    public void salva() {
        if (validaSenha() != null) {
            if (usuario.getCodusuario() == null) {
                try {
                    validaBloqueado();
                    usuario.setCodtipousuario(tipoUsuario);
                    usuario.setFoto("foto");
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    usuarioDAO.salva(usuario);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com Sucesso!", ""));
                    novo();
                } catch (Exception e) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Salvar Usuario\n" + e, ""));
                }
            } else {
                try {
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    TipoUsuarioDAO tipoUsuarioDAO= new TipoUsuarioDAO();
                    tipoUsuario= tipoUsuarioDAO.consulta(usuario.getCodtipousuario());
                    usuario.setCodtipousuario(tipoUsuario);
                    usuarioDAO.salva(usuario);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editado com Sucesso!", ""));
                    novo();
                } catch (Exception e) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Editar Usuario!\n" + e, ""));
                }
            }
        }
    }

    public void remover() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.exclui(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido com Sucesso!", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao remover Usuario!\n" + e, ""));
        }
    }

    public List<Usuario> listaSuportes() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.lista();
    }

    public String qtdeAtendimentosAbertos(String usuarioLogado) {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("SELECT COUNT(*) from ATENDIMENTO A "
                + "INNER JOIN USUARIO U ON A.CODUSUARIO=U.CODUSUARIO "
                + "INNER JOIN STATUS S ON A.CODSTATUS=S.CODSTATUS "
                + "WHERE U.USUARIO LIKE '" + usuarioLogado + "' AND S.DESCRICAO LIKE 'EXECUCAO' AND U.BLOQUEADO = 1");
        em.getTransaction().commit();

        return query.getSingleResult().toString();
    }

    public String qtdeAtendimentosConcluidos(String usuarioLogado) {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("SELECT COUNT(*) from ATENDIMENTO A "
                + "INNER JOIN USUARIO U ON A.CODUSUARIO=U.CODUSUARIO "
                + "INNER JOIN STATUS S ON A.CODSTATUS=S.CODSTATUS "
                + "WHERE U.USUARIO LIKE '" + usuarioLogado + "' AND S.DESCRICAO LIKE 'CONCLUIDO' AND U.BLOQUEADO = 1");
        em.getTransaction().commit();
        return query.getSingleResult().toString();
    }

    public String qtdeAtendimentosPendentes(String usuarioLogado) {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("SELECT COUNT(*) from ATENDIMENTO A "
                + "INNER JOIN USUARIO U ON A.CODUSUARIO=U.CODUSUARIO "
                + "INNER JOIN STATUS S ON A.CODSTATUS=S.CODSTATUS "
                + "WHERE U.USUARIO LIKE '" + usuarioLogado + "' AND S.DESCRICAO LIKE 'PENDENTE' AND U.BLOQUEADO = 1");
        em.getTransaction().commit();
        return query.getSingleResult().toString();
    }

    public String qtdeAllAtendimentosAbertos() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("SELECT COUNT(*) from ATENDIMENTO A "
                + "INNER JOIN STATUS S ON A.CODSTATUS=S.CODSTATUS "
                + "INNER JOIN USUARIO U ON A.CODUSUARIO=U.CODUSUARIO "
                + "WHERE S.DESCRICAO LIKE 'EXECUCAO' AND U.CODTIPOUSUARIO=1 AND U.BLOQUEADO = 1" );
        em.getTransaction().commit();
        return query.getSingleResult().toString();
    }

    public String qtdeAllAtendimentosConcluidos() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("SELECT COUNT(*) from ATENDIMENTO A "
                + "INNER JOIN STATUS S ON A.CODSTATUS=S.CODSTATUS "
                + "INNER JOIN USUARIO U ON A.CODUSUARIO=U.CODUSUARIO "
                + "WHERE S.DESCRICAO LIKE 'CONCLUIDO' AND U.CODTIPOUSUARIO=1 AND U.BLOQUEADO = 1" );
        em.getTransaction().commit();
        return query.getSingleResult().toString();
    }

    public String qtdeAllAtendimentosPendentes() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("SELECT COUNT(*) from ATENDIMENTO A "
                + "INNER JOIN STATUS S ON A.CODSTATUS=S.CODSTATUS "
                + "INNER JOIN USUARIO U ON A.CODUSUARIO=U.CODUSUARIO "
                + "WHERE S.DESCRICAO LIKE 'PENDENTE' AND U.CODTIPOUSUARIO=1 AND U.BLOQUEADO = 1");
        em.getTransaction().commit();
        return query.getSingleResult().toString();
    }

}
