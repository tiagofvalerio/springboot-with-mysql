package br.com.financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.financeiro.dao.UsuarioDAO;
import br.com.financeiro.model.Usuario;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @RequestMapping("/criar")
    @ResponseBody
    public String criar(String email, String nome) {
        Usuario usuario = new Usuario();
        try {
            usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setNome(nome);
            usuarioDAO.save(usuario);
        } catch (Exception ex) {
            return "Erro ao tentar criar usuário!";
        }
        return "Usuário criado com sucesso com codigo: " + usuario.getCodigo();
    }

    @RequestMapping("/get-by-codigo")
    @ResponseBody
    public String getByCodigo(Integer codigo) {
        String codigoUsuario = "";
        try {
            Usuario usuario = usuarioDAO.findByCodigo(codigo);
            codigoUsuario = String.valueOf(usuario.getCodigo());
        } catch (Exception ex) {
            return "Usuário não encontrato.";
        }
        return "O código do usuário é: " + codigoUsuario;
    }
}
