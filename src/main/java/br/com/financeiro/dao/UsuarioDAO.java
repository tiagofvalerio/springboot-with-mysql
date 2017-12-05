package br.com.financeiro.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.financeiro.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
    
    public Usuario findByCodigo(Integer codigo);
}
