package br.com.ada.pablo.livraria.livro;

import br.com.ada.pablo.livraria.model.Produto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "livro")
public class Livro extends Produto {

    @Column
    private String escritor;
    @Column
    private String editora;
    @Column
    private Integer edicao;


}
