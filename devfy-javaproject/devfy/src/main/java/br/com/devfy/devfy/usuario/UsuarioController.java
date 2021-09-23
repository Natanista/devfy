package br.com.devfy.devfy.usuario;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public String cadastrarUsuario(
            @RequestBody String nome,
            @RequestBody String email,
            @RequestBody String senha
    ) {
        usuarios.add(new Usuario(nome, email, senha));
        return String.format("Usuario %s cadastrado com sucesso!", nome);
    }

    @PostMapping
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    @PostMapping
    public String logarUsuario(
            @RequestBody String email,
            @RequestBody String senha
    ) {
        for (Usuario usuario : usuarios) {
            if (usuario.isUserValid(email, senha)) {
                usuario.logarUsuario();
                return "Usuario logado com sucesso!";
            }
        }
        return "Erro ao logar usuario";
    }

    @PostMapping
    public String deslogarUsuario(
            @RequestBody String email,
            @RequestBody String senha
    ) {
        for (Usuario usuario : usuarios) {
            if (usuario.isUserValid(email, senha)) {
                usuario.deslogarUsuario();
                return "Usuario deslogado com sucesso!";
            }
        }
        return "Erro ao deslogar usuario";
    }



}



