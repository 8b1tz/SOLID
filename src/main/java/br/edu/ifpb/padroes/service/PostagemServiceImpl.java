package br.edu.ifpb.padroes.service;

import java.util.Date;

import br.edu.ifpb.padroes.modelo.Postagem;
import br.edu.ifpb.padroes.modelo.PostagemPrivada;
import br.edu.ifpb.padroes.modelo.PostagemPublica;
import br.edu.ifpb.padroes.modelo.PostagemResposta;

//Criado para atender o Single Responsibility e Interface Segregation
public class PostagemServiceImpl implements PostagemService{

    private PostagemDAO postagemDAO = new PostagemDAO("banco.db");

    //Criado para atender o Open/Closed Principle
    @Override
    public void adicionarPostagemPublica(PostagemPublica postagem) {
            this.postagemDAO.addPostagemPublica(postagem);
    }
    
    //Criado para atender o Open/Closed Principle
    @Override
    public void adicionarPostagemPrivada(PostagemPrivada postagem) {
            this.postagemDAO.addPostagemPrivada(postagem); 
    }

    @Override
    public void removerPostagem(Postagem postagem) {
        this.postagemDAO.deletePostagem(postagem);
    }

    @Override
    public void atualizarPostagem(Postagem postagem) {
        this.postagemDAO.updatePostagem(postagem);
    }

    @Override
    public void adicionarResposta(Postagem postagem, Postagem resposta) {
        PostagemResposta postagemResposta = new PostagemResposta();
        postagemResposta.setPostagem(postagem);
        postagemResposta.setUsuario(resposta.getUsuario());
        postagemResposta.setData(new Date());
        this.postagemDAO.addPostagemResposta(postagemResposta);
    }

}
