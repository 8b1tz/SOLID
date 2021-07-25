package br.edu.ifpb.padroes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import br.edu.ifpb.padroes.modelo.Postagem;
import br.edu.ifpb.padroes.modelo.PostagemPrivada;
import br.edu.ifpb.padroes.modelo.PostagemPublica;
import br.edu.ifpb.padroes.modelo.PostagemResposta;

public class PostagemDAO extends DAO<PostagemDAO>{

   
	public PostagemDAO(String arquivoBanco) {
		super(arquivoBanco);
	}

	public void addPostagemPublica(PostagemPublica postagem) {
        Connection conexao = super.connect();
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO POSTAGEM( ID, TITULO, USUARIO_ID, MENSAGEM, TIPO) VALUES (?, ?, ?, ?, 'PUBLICA')")) {
            stmt.setLong(1, postagem.getId());
            stmt.setString(2, postagem.getTitulo());
            stmt.setLong(3, postagem.getUsuario().getId());
            stmt.setString(4, postagem.getMensagem());

            stmt.execute();
        } catch (SQLException ex) {
            this.trataExcecao(ex);
        }
    }

    public void addPostagemPrivada(PostagemPrivada postagem) {
        Connection conexao = super.connect();
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO POSTAGEM( ID, TITULO, USUARIO_ID, MENSAGEM, TIPO) VALUES (?, ?, ?, ?, 'PRIVADA')")) {
            stmt.setLong(1, postagem.getId());
            stmt.setString(2, postagem.getTitulo());
            stmt.setLong(3, postagem.getUsuario().getId());
            stmt.setString(4, postagem.getMensagem());
            stmt.execute();
        } catch (SQLException ex) {
            this.trataExcecao(ex);
        }
    }

    public void addPostagemResposta(PostagemResposta postagem) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    public void updatePostagem(Postagem postagem) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    public void deletePostagem(Postagem postagem) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    public List<Postagem> listPostagens() {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }

    public Postagem getPostagem(Long id) {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }

    public void trataExcecao(Exception ex) {
        Logger.getLogger(UsuarioServiceImpl.class.getName()).warning(ex.getMessage());
    }


}
