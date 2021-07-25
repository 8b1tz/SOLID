package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.modelo.Postagem;
import br.edu.ifpb.padroes.modelo.PostagemPrivada;
import br.edu.ifpb.padroes.modelo.PostagemPublica;

// Criado para atender o Single Responsibility e Interface Segregation
public interface PostagemService {
	
    void adicionarPostagemPublica(PostagemPublica postagem); //Criado para atender o Open/Closed Principle
    void adicionarPostagemPrivada(PostagemPrivada postagem); //Criado para atender o Open/Closed Principle
    void removerPostagem(Postagem postagem);
    void atualizarPostagem(Postagem postagem);
    void adicionarResposta(Postagem postagem, Postagem resposta);
}
