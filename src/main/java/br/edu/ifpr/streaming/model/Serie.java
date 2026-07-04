package br.edu.ifpr.streaming.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Serie extends Conteudo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @OneToMany(mappedBy = "serie")
    private List<Episodio> episodios;
}
