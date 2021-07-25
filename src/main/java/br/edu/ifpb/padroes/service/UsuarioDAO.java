package br.edu.ifpb.padroes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import br.edu.ifpb.padroes.modelo.Usuario;

public class UsuarioDAO extends DAO<UsuarioDAO>{
    
    public UsuarioDAO(String arquivoBanco) {
		super(arquivoBanco);
		// TODO Auto-generated constructor stub
	}

	public void addUsuario(Usuario usuario) {
        Connection conexao = super.connect();
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO USUARIO( ID, NOME, LOGIN, SENHA) VALUES (?, ?, ?, ?)")) {
            stmt.setLong(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.execute();
        } catch (SQLException ex) {
            this.trataExcecao(ex);
        }
    }

    public void updateUsuario(Usuario usuario) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    public void deleteUsuario(Usuario usuario) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    public List<Usuario> listUsuarios() {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }

    public Usuario getUsuario(Long id) {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }

    public void trataExcecao(Exception ex) {
        Logger.getLogger(UsuarioServiceImpl.class.getName()).warning(ex.getMessage());
    }


}
