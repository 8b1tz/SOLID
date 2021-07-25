package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.modelo.Usuario;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDAO usuarioDAO = new UsuarioDAO("banco.db");

    @Override
    public void criarUsuario(Usuario usuario) {
        usuarioDAO.addUsuario(usuario);
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
        usuarioDAO.updateUsuario(usuario);
    }

    @Override
    public void removerUsuario(Usuario usuario) {
        usuarioDAO.deleteUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios(Usuario usuario) {
        return usuarioDAO.listUsuarios();
    }

    @Override
    public Usuario recuperarUsuario(Long id) {
        return usuarioDAO.getUsuario(id);
    }
}
