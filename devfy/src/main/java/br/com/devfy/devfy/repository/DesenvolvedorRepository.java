package br.com.devfy.devfy.repository;

import br.com.devfy.devfy.model.Desenvolvedor;
import br.com.devfy.devfy.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Interface com os métodos de acesso a banco para a entidade Musica
<Musica, Integer>
 Musica -> Tipo da Entidade
 Integer -> Tipo da PK da Entidade (note que é o tipo do atributo anotado com @Id em Musica)
 */
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Integer> {

    public Desenvolvedor findDesenvolvedorByUsuarioEqualsAndSenhaEquals(String usuario,String senha);
}
